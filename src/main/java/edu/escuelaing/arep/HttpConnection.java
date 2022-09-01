package edu.escuelaing.arep;

import edu.escuelaing.arep.entidades.Cache;
import edu.escuelaing.arep.entidades.QueryAlpha;
import edu.escuelaing.arep.entidades.QueryPoly;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 *
 * @author jaime.cacuna
 */
public class HttpConnection {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static Cache cache = Cache.getInstance();

    /**
     * Método encargado de entablar la conexión con el API, y traer la
     * información a nuestra pagina dado un query específico
     *
     * @param simbolo
     * @param tiempo
     * @return
     * @throws IOException
     */
    public static String getApiAlpha(String simbolo, String tiempo) throws IOException {
        QueryAlpha query = new QueryAlpha(simbolo, tiempo);
        URL obj = new URL(query.getQuery());
        return getStock(obj);
    }

    public static String getApiPolygon(String simbolo, String fechaInicio, String fechaFin, String limite) throws IOException {
        QueryPoly query = new QueryPoly(simbolo, fechaInicio, fechaFin, limite);
        URL obj = new URL(query.getQuery());
        System.out.println(obj);
        return getStock(obj);
    }

    public static String getStock(URL obj) throws IOException {
        if (cache.contains(obj.toString())) {
            System.out.println("Cache consultada con exito");
            return cache.get(obj.toString());
        } else {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
                cache.insert(obj.toString(), response.toString());
                return response.toString();
            } else {
                System.out.println("GET request not worked");
                return "";
            }
        }

    }
}
