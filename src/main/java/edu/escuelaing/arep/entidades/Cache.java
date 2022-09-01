/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.arep.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * La clase cache es la encargada de almacenar la información de URL previamente
 * ya consultadas
 *
 * @author jaime.cacuna
 */
public class Cache {

    private static final Cache instancia = new Cache();
    
    private HashMap<String, String> cache = new HashMap<>();

    /**
     * Metodo que inserta una valor en el cache
     *
     * @param llave Es la clave del valor a insertar
     * @param valor Es el valor a insertar
     */
    public void insert(String llave, String valor) {
        cache.put(llave, valor);
    }

    /**
     * Metodo que obtiene el valor asociado a una llave
     *
     * @param llave Es la llave a buscar
     * @return Valor asociado a la llave
     */
    public String get(String llave) {
        return cache.get(llave);
    }

    /**
     * Metodo que devuelve si el cache contiene la llave
     *
     * @param llave es la llave buscar
     * @return verdadero si el cache contiene la llave, falso en el caso contrario
     */
    public boolean contains(String llave) {
        return cache.containsKey(llave);
    }

    /**
     * Metodo que devuelve la instancia del cache
     *
     * @return la instancia
     */
    public static Cache getInstance() {
        return instancia;
    }
}
