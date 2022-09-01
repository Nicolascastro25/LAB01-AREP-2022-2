/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.arep.entidades;

import java.util.List;

/**
 * Clase que construye el Query que se va a consultar en el API alphavantage
 *
 * @author jaime.cacuna
 */
public class QueryAlpha {

    private final String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=";
    private String queryConsulta;

    /**
     * Constructor de la clase Query
     *
     * @param simbolo
     * @param tiempo
     */
    public QueryAlpha(String simbolo, String tiempo) {
        queryConsulta = url + simbolo + "&interval=" + tiempo + "&apikey=G0PV1W2FLYMLQ6JL";
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
