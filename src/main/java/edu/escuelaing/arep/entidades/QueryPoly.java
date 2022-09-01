/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.arep.entidades;

import java.util.List;

/**
 *
 * @author jaime.cacuna
 */
public class QueryPoly {

    private final static String POLY_URL = "https://api.polygon.io/";
    private final static String POLY_KEY = "&apiKey=bjbp6YiIVJyxfKtvI4BsfKUQMVUxnMWd";
    private String queryConsulta;

    public QueryPoly(String simbolo, String fechaInicio, String fechaFin, String limite) {
        queryConsulta = POLY_URL + "v2/aggs/ticker/" + simbolo + "/range" + "/1/day/" + fechaInicio + "/" + fechaFin + "?adjusted=true&sort=asc&limit=" + limite + POLY_KEY;
    }

    /**
     * Método que retorna el query creado para consulta
     *
     * @return
     */
    public String getQuery() {
        return queryConsulta;
    }

}
