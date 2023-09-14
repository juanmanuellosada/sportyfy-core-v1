package sportyfy.core;

import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Data
public class BuscadorPronosticadores {
    private Set<Pronosticador> pronosticadores;

    public Set<Pronosticador> buscarPronosticadores(String ruta) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("Buscando pronosticadores...");
        System.out.println("Ruta: " + ruta);
        Set<Pronosticador> pronosticadores = new HashSet<>();

        File directorio = new File(ruta);

        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            System.out.println("Archivos encontrados: " + archivos.length);

            if (archivos != null) {
                for (File archivo : archivos) {
                    System.out.println("Archivo: " + archivo.getName());

                    if (archivo.isFile() && archivo.getName().endsWith(".jar")) {
                        Set<Class<?>> clases = obtenerClasesDesdeJar(archivo);

                        for (Class<?> cls : clases) {
                            if (Pronosticador.class.isAssignableFrom(cls)) {
                                pronosticadores.add((Pronosticador) cls.getDeclaredConstructor().newInstance());
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Pronosticadores encontrados: " + pronosticadores.size());
        return pronosticadores;
    }

    private Set<Class<?>> obtenerClasesDesdeJar(File archivoJar) throws ClassNotFoundException {
        Set<Class<?>> clases = new HashSet<>();

        try (JarFile jarFile = new JarFile(archivoJar)) {
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{archivoJar.toURI().toURL()});
            Enumeration<JarEntry> entries = jarFile.entries();

            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                    String className = entry.getName().replace("/", ".").replace(".class", "");
                    Class<?> cls = Class.forName(className, true, classLoader);
                    clases.add(cls);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clases;
    }
}
