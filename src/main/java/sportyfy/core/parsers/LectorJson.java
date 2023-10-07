package sportyfy.core.parsers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LectorJson {
    public String leerArchivoJson(String rutaArchivo) throws IOException {
        return new String(Files.readAllBytes(Paths.get(rutaArchivo)));
    }

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
