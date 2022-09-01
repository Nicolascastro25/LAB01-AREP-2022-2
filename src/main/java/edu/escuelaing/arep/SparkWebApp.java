package edu.escuelaing.arep;

import static spark.Spark.*;

/**
 *
 * @author jaime.cacuna
 */
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        getEndPoints();
    }

    /**
     * Método que retorna el puerto sobre el cual se desplegará nuestra
     * aplicación
     *
     * @return
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;// returns default port if heroku-port isn't set (i.e. on localhost)
    }

    /*
    Método con las funciones lambda que usaremos para consultar el API
     */
    public static void getEndPoints() {

        get("/getSimbolo", (req, res) -> {
            String simbolo = req.queryParams("simbolo");
            return "La acción es: " + simbolo;
        });
        get("/getTiempo", (req, res) -> {
            String tiempo = req.queryParams("tiempo");
            return "El tiempo de busqueda es: " + tiempo;
        });
        get("/getSimboloPoly", (req, res) -> {
            String simboloPoly = req.queryParams("simboloPoly");
            return "La acción es: " + simboloPoly;
        });
        get("/getFechaInicio", (req, res) -> {
            String fechaInicio = req.queryParams("fechaInicio");
            return "Fecha de inicio de la busqueda: " + fechaInicio;
        });
        get("/getFechaFin", (req, res) -> {
            String fechaFin = req.queryParams("fechaFin");
            return "Fecha de fin de la busqueda:" + fechaFin;
        });
        get("/getLimite", (req, res) -> {
            String limite = req.queryParams("limite");
            return "Limite de datos de la busqueda: " + limite;
        });
        get("/getQueryAlpha", (req, res) -> {
            String tiempo = req.queryParams("tiempo");
            String simbolo = req.queryParams("simbolo");
            res.type("/application.json");
            return HttpConnection.getApiAlpha(simbolo, tiempo);
        });
        get("/getQueryPolygon", (req, res) -> {
            String simboloPoly = req.queryParams("simboloPoly");
            String fechaInicio = req.queryParams("fechaInicio");
            String fechaFin = req.queryParams("fechaFin");
            String limite = req.queryParams("limite");
            res.type("/application.json");
            return HttpConnection.getApiPolygon(simboloPoly, fechaInicio, fechaFin, limite);
        });

    }

}
