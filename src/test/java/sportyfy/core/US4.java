package sportyfy.core;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import sportyfy.apiFootball.GeneradorJsons;
import sportyfy.core.parsers.LectorJson;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US4 {
    /*
    private static final String rutaCarpetaEquipos = "equipos";
    private static final String rutaCarpetaPartidos = "partidos";

    @BeforeAll
    public static void escenario() {
        // Limpiar directorio antes de las pruebas
        limpiarDirectorio(rutaCarpetaEquipos);
        limpiarDirectorio(rutaCarpetaPartidos);

        // Verificar que los directorios se creen correctamente
        assertTrue(crearDirectorio(rutaCarpetaEquipos), "No se pudo crear la carpeta: " + rutaCarpetaEquipos);
        assertTrue(crearDirectorio(rutaCarpetaPartidos), "No se pudo crear la carpeta: " + rutaCarpetaPartidos);
    }

    @Test
    @Order(1)
    public void CA1_GenerarJsonEquipos() {
        assertDoesNotThrow(() -> GeneradorJsons.generarJsonEquipos(rutaCarpetaEquipos));

        // Verificar que se haya generado el archivo
        File archivoEquipos = new File(rutaCarpetaEquipos + File.separator + "equipos.json");
        assertTrue(archivoEquipos.exists(), "El archivo de equipos no se ha generado.");

    }

    @Test
    @Order(2)
    public void CA2_GenerarJsonEquiposVerificarContenido() {
        File archivoEquipos = new File(rutaCarpetaEquipos + File.separator + "equipos.json");

        assertTrue(archivoEquipos.exists(), "El archivo de equipos no existe.");

        try {
            JSONArray equipos = new JSONArray(new LectorJson().leerArchivoJson(archivoEquipos.getAbsolutePath()));
            assertNotNull(equipos, "El archivo de equipos está vacío.");

            for (int i = 0; i < equipos.length(); i++) {
                JSONObject equipo = equipos.getJSONObject(i);

                assertTrue(equipo.has("id"), "El equipo no tiene un ID.");
                assertTrue(equipo.has("nombre"), "El equipo no tiene un nombre.");

                assertTrue(equipo.getInt("id") > 0, "ID de equipo no válido.");
                assertFalse(equipo.getString("nombre").isEmpty(), "Nombre de equipo vacío.");
            }
        } catch (IOException e) {
            fail("Error al leer el archivo de equipos: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    public void CA3_GenerarJsonsPartidos() {
        assertDoesNotThrow(() -> GeneradorJsons.generarJsonsPartidos(rutaCarpetaPartidos));

        File directorioPrueba = new File(rutaCarpetaPartidos);
        assertTrue(directorioPrueba.exists(), "El directorio de partidos no existe.");

        File[] archivosPartidos = directorioPrueba.listFiles((dir, name) -> name.startsWith("ultimos_resultados_"));
        assertNotNull(archivosPartidos, "No se encontraron archivos de partidos.");
    }

    @Test
    @Order(4)
    public void CA4_GenerarJsonsPartidosVerificarContenido() {
        File directorioPrueba = new File(rutaCarpetaPartidos);
        assertTrue(directorioPrueba.exists(), "El directorio de partidos no existe.");

        File[] archivosPartidos = directorioPrueba.listFiles((dir, name) -> name.startsWith("ultimos_resultados_"));
        assertNotNull(archivosPartidos, "No se encontraron archivos de partidos.");

        for (File archivo : archivosPartidos) {
            verificarArchivoDePartido(archivo);
        }
    }

    private void verificarArchivoDePartido(File archivo) {
        assertTrue(archivo.isFile(), "No es un archivo.");
        assertTrue(archivo.getName().startsWith("ultimos_resultados_"), "Nombre de archivo incorrecto.");
        assertTrue(archivo.getName().endsWith(".json"), "Extensión de archivo incorrecta.");

        verificarContenidoDeArchivo(archivo);
    }

    private void verificarContenidoDeArchivo(File archivo) {
        try {
            JSONArray partidos = new JSONArray(new LectorJson().leerArchivoJson(archivo.getAbsolutePath()));
            assertNotNull(partidos, "El archivo de partidos está vacío.");

            for (int i = 0; i < partidos.length(); i++) {
                JSONObject partido = partidos.getJSONObject(i);

                assertTrue(partido.has("equipoLocal"), "El partido no tiene equipo local.");
                assertTrue(partido.has("equipoVisitante"), "El partido no tiene equipo visitante.");
                assertTrue(partido.has("golesLocal"), "El partido no tiene goles locales.");
                assertTrue(partido.has("golesVisitante"), "El partido no tiene goles visitantes.");

                verificarGolesDePartido(partido);
            }
        } catch (IOException e) {
            fail("Error al leer el archivo de partidos: " + e.getMessage());
        }
    }

    private void verificarGolesDePartido(JSONObject partido) {
        assertTrue(partido.getInt("golesLocal") >= 0, "Cantidad de goles locales no válida.");
        assertTrue(partido.getInt("golesVisitante") >= 0, "Cantidad de goles visitantes no válida.");
    }

    @AfterAll
    public static void limpiarArchivosGenerados() {
        limpiarDirectorio(rutaCarpetaEquipos);
        limpiarDirectorio(rutaCarpetaPartidos);
    }

    private static boolean crearDirectorio(String ruta) {
        File carpeta = new File(ruta);
        return carpeta.exists() || carpeta.mkdirs();
    }

    private static void limpiarDirectorio(String ruta) {
        File directorio = new File(ruta);
        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (!archivo.isDirectory()) {
                    archivo.delete();
                }
            }
        }
    }*/

}
