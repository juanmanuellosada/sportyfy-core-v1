package sportyfy.core.parsers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que lee archivos JSON.
 */
public class LectorJson {

    /**
     * Lee un archivo JSON.
     * @param rutaArchivo Ruta del archivo JSON.
     * @return Contenido del archivo JSON.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public String leerArchivoJson(String rutaArchivo) throws IOException {
        return new String(Files.readAllBytes(Paths.get(rutaArchivo)));
    }

    /**
     * Lee todos los archivos JSON de una carpeta.
     * @param rutaCarpeta Ruta de la carpeta que contiene los archivos JSON.
     * @return Lista de JSONs leídos.
     * @throws IOException Si ocurre un error al leer los archivos.
     */
    public List<String> leerArchivosJson(String rutaCarpeta) throws IOException {
        List<String> jsonsPartidosTotales = new ArrayList<>();
        File carpeta = new File(rutaCarpeta);

        if (carpeta.isDirectory()) {
            for (File archivo : Objects.requireNonNull(carpeta.listFiles(File::isFile))) {
                jsonsPartidosTotales.add(leerArchivoJson(archivo.getAbsolutePath()));
            }
        }

        return jsonsPartidosTotales;
    }
}
