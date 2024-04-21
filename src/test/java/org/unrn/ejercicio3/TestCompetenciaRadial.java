package org.unrn.ejercicio3;

import org.junit.jupiter.api.Test;
import org.unrn.ejercicio3.aplicacion.Modelo;
import org.unrn.ejercicio3.servicio.EmisorDeRegistros;
import org.unrn.ejercicio3.servicio.LectorDeConcursos;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompetenciaRadial {
    private final String RUTA_CONCURSOS = "./src/main/resources/concursos.txt";
    private final String RUTA_INSCRIPTOS = "./src/main/resources/inscriptos.txt";

    @Test
    public void seLeeArchivoDeTexto() {
        try {
            var lector = new LectorDeConcursos(RUTA_CONCURSOS);
            var lista = lector.leerArchivo();
            corroborarTexto(lista);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void corroborarTexto(List<String[]> lista) {
        String res = "";
        for (String[] linea : lista) {
            res += Arrays.toString(linea);
        }
        assertEquals("[idconcurso, nombre, fechaInicioInscripcion, fechaFinInscripcion]" +
                "[1, concurso x, 2020/06/01, 2020/07/01][2, concurso y, 2020/08/01, 2020/09/01]" +
                "[3, concurso z, 2020/10/01, 2020/11/01][4, concurso a, 2020/12/01, 2021/01/01]" +
                "[5, concurso b, 2021/02/01, 2021/03/01][6, concurso c, 2021/04/01, 2021/05/01]" +
                "[7, concurso d, 2021/06/01, 2021/07/01][8, concurso e, 2021/08/01, 2021/09/01]" +
                "[9, concurso f, 2021/10/01, 2021/11/01][10, concurso g, 2021/12/01, 2022/01/01]" +
                "[11, concurso h, 2022/02/01, 2022/03/01][12, concurso i, 2022/04/01, 2022/05/01]" +
                "[13, concurso j, 2022/06/01, 2022/07/01][14, concurso k, 2022/08/01, 2022/09/01]" +
                "[15, concurso l, 2022/10/01, 2022/11/01][16, concurso m, 2022/12/01, 2023/01/01]" +
                "[17, concurso n, 2023/02/01, 2023/03/01][18, concurso o, 2023/04/01, 2023/05/01]" +
                "[19, concurso p, 2023/06/01, 2023/07/01][20, concurso q, 2023/08/01, 2023/09/01]" +
                "[21, concurso r, 2023/10/01, 2023/11/01][22, concurso s, 2023/12/01, 2024/01/01]" +
                "[23, concurso t, 2024/02/01, 2024/03/01][24, concurso u, 2024/04/01, 2024/05/01]" +
                "[25, concurso v, 2024/06/01, 2024/07/01][26, concurso w, 2024/08/01, 2024/09/01]" +
                "[27, concurso x1, 2024/10/01, 2024/11/01][28, concurso y1, 2024/12/01, 2025/01/01]" +
                "[29, concurso z1, 2025/02/01, 2025/03/01][30, concurso a1, 2025/04/01, 2025/05/01]", res);
    }

    @Test
    public void seGrabaArchivoDeTexto() {
        var lector = new LectorDeConcursos(RUTA_CONCURSOS);
        var emisor = new EmisorDeRegistros(RUTA_INSCRIPTOS);
        var modelo = new Modelo(lector, emisor);
        modelo.guardarDatos("Juan", "Perez",
                "JuanPerez@acdc.com", "1234-123423", "concurso u");
    }

    @Test
    public void seActualizaComboBox() {
        var lector = new LectorDeConcursos(RUTA_CONCURSOS);
        var emisor = new EmisorDeRegistros(RUTA_INSCRIPTOS);
        var modelo = new Modelo(lector, emisor);
        assertEquals("[concurso u]", Arrays.toString(modelo.cargarConcursos()));
    }
}
