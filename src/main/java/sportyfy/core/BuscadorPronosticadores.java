package sportyfy.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

/**
 * Clase que busca pronosticadores en un directorio
 */
public class BuscadorPronosticadores {
    private final Logger logger = Logger.getLogger(BuscadorPronosticadores.class.getName());

    /**
     * Busca pronosticadores en un directorio
     * @param ruta Ruta del directorio
     * @return Conjunto de pronosticadores
     * @throws FileNotFoundException Si no existe el directorio
     */
    public Set<Pronosticador> buscarPronosticadores(String ruta) throws FileNotFoundException {
        Set<Pronosticador> pronosticadores = new HashSet<>();

        File directorio = new File(ruta);

        // Si el directorio existe y es un directorio
        if (directorio.exists() && directorio.isDirectory()) {
            // Obtenemos los archivos del directorio
            File[] archivos = directorio.listFiles();

            // Si hay archivos
            if (archivos != null) {
                // Por cada archivo
                for (File archivo : archivos) {
                    // Si es un archivo y termina en .jar
                    if (archivo.isFile() && archivo.getName().endsWith(".jar")) {
                        // Agregamos los pronosticadores del archivo
                        pronosticadores.addAll(obtenerPronosticadoresDesdeJar(archivo));
                    }
                    else if(archivo.isFile() && !archivo.getName().endsWith(".gitkeep")){
                      throw new IllegalArgumentException("La extensión del archivo encontrado no es .jar");
                    }
                }
            }
        }
        else{
            throw new FileNotFoundException("No existe o no es un directorio la dirección proporcionada");
        }

        return pronosticadores;
    }

    /**
     * Obtiene los pronosticadores de un archivo .jar
     * @param archivoJar Archivo .jar
     * @return Conjunto de pronosticadores
     * @throws IllegalArgumentException Si la extensión del archivo no es .jar
     */
    private Set<Pronosticador> obtenerPronosticadoresDesdeJar(File archivoJar) {
        Set<Pronosticador> pronosticadores = new HashSet<>();

        // Intentamos abrir el archivo
        try (JarFile archivoJAR = new JarFile(archivoJar)) {
            // Obtenemos las entradas del archivo
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { archivoJar.toURI().toURL() });

            // Por cada entrada del archivo si termina en .class
            for (JarEntry entrada : archivoJAR.stream().filter(e -> e.getName().endsWith(".class"))
                    .toArray(JarEntry[]::new)) {
                // Obtenemos el nombre de la clase sin el .class
                String nombreClase = entrada.getName().replace('/', '.').substring(0, entrada.getName().length() - 6);
                // Intentamos obtener la clase
                try {
                    // Si la clase es un pronosticador la agregamos
                    Class<?> cls = Class.forName(nombreClase, true, classLoader);

                    if (Pronosticador.class.isAssignableFrom(cls)) {
                        pronosticadores.add((Pronosticador) cls.getDeclaredConstructor().newInstance());
                    }
                    // ClassNotFoundException sale si no se encuentra la clase en el classpath
                    // NoSuchMethodException sale si no se encuentra el constructor
                    // IllegalAccessException sale si no se puede acceder al constructor
                    // InstantiationException sale si no se puede instanciar la clase
                    // InvocationTargetException sale si el constructor lanza una excepción
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                        | InstantiationException | InvocationTargetException e) {
                    if(e instanceof ClassNotFoundException) {
                        logger.severe("No se encontro la clase " + nombreClase);
                    } else if(e instanceof NoSuchMethodException) {
                        logger.severe("No se encontro el constructor sin argumentos de la clase " + nombreClase);
                    } else if(e instanceof IllegalAccessException) {
                        logger.severe("No se puede acceder al constructor sin argumentos de la clase " + nombreClase);
                    } else if(e instanceof InstantiationException) {
                        logger.severe("No se puede instanciar la clase " + nombreClase);
                    } else {
                        logger.severe("El constructor sin argumentos de la clase " + nombreClase + " lanzo una excepcion");
                    }
                }
            }
        } catch (IOException e) {
            Logger.getLogger("BuscadorPronosticadores").severe("No se pudo abrir el archivo " + archivoJar.getName());
        }

        return pronosticadores;
    }

    /**
     * Busca un pronosticador en un conjunto de pronosticadores
     * @param pronosticadores Conjunto de pronosticadores
     * @param nombre Nombre del pronosticador
     * @return Pronosticador encontrado o null
     */
    public Pronosticador buscarPronosticador(Set<Pronosticador> pronosticadores, String nombre) {
        return pronosticadores.stream()
                .filter(p -> p.getClass().getSimpleName().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}
