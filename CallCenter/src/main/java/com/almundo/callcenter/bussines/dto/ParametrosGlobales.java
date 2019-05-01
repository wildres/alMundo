/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.bussines.dto;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Esta clase contiene los objetos necesarios que deben estar disponibles en la
 * aplicacion mantieniedo una unica instancia en toda la aplicacion
 *
 * @author Andres Alarcon
 */
public class ParametrosGlobales {

    private final Stack<EmpleadoDTO> pilaEmpleados;
    private static ParametrosGlobales parametrosGlobales;
    private final Queue<Llamada> llamadaEnEspera;

    private ParametrosGlobales() {
        llamadaEnEspera = new ArrayDeque<>();
        pilaEmpleados = new Stack();
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.DIRECTOR, 1L, true));
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.DIRECTOR, 2L, true));
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.SUPERVISOR, 3L, true));
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.SUPERVISOR, 4L, true));
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.SUPERVISOR, 5L, true));
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.OPERADOR, 6L, true));
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.OPERADOR, 7L, true));
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.OPERADOR, 8L, true));
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.OPERADOR, 9L, true));
        pilaEmpleados.add(new EmpleadoDTO(TipoEmpleado.OPERADOR, 10L, true));
    }

    /**
     * @return the pilaEmpleados
     */
    public Stack<EmpleadoDTO> getPilaEmpleados() {
        return pilaEmpleados;
    }

    public static ParametrosGlobales getInstance() {
        if (parametrosGlobales == null) {
            parametrosGlobales = new ParametrosGlobales();
        }
        return parametrosGlobales;
    }

    /**
     * @return the llamadaEnEspera
     */
    public Queue<Llamada> getLlamadaEnEspera() {
        return llamadaEnEspera;
    }

}
