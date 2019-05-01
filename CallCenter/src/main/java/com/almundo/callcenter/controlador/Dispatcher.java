/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.controlador;

import com.almundo.callcenter.bussines.dto.EmpleadoDTO;
import com.almundo.callcenter.bussines.dto.Llamada;
import com.almundo.callcenter.bussines.dto.ParametrosGlobales;
import com.almundo.callcenter.bussines.dto.RespuestaLlamada;
import com.almundo.callcenter.bussines.dto.TipoEmpleado;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase encargada de gestionar las llamadas entrantes
 *
 * @author Andres Alarcon
 */
public class Dispatcher {

    private final int CANTIDAD_LLAMADAS = 10;

    private final ExecutorService executor = Executors.newFixedThreadPool(CANTIDAD_LLAMADAS);
    private final CompletionService<RespuestaLlamada> service = new ExecutorCompletionService<>(executor);

    /**
     * Metodo encargado de asignar la llamada a cada empleado segun la
     * disponibilidad de cada uno validando inicialmente los Operadores
     * disponibles, de no existir ningun operador disponible buscara los
     * supervisores disponibles, de no existir tampoco ni ngun supervisor la
     * llamada sera redireccionada a un director de lo contrario esta llamada
     * quedara en la lista de espera hasta que haya un empleado disponible
     *
     *
     * @param llamada objeto que representa la llamada entrante
     */
    public void dispatchCall(Llamada llamada) {
        EmpleadoDTO empleadoDTO;
        if ((empleadoDTO = buscarEmpleadoDisponible(TipoEmpleado.OPERADOR)) != null) {
            empleadoDTO.setLlamada(llamada);
            asignarLlamada(empleadoDTO);
        } else if ((empleadoDTO = buscarEmpleadoDisponible(TipoEmpleado.SUPERVISOR)) != null) {
            empleadoDTO.setLlamada(llamada);
            asignarLlamada(empleadoDTO);
        } else if ((empleadoDTO = buscarEmpleadoDisponible(TipoEmpleado.DIRECTOR)) != null) {
            empleadoDTO.setLlamada(llamada);
            asignarLlamada(empleadoDTO);
        } else {
            System.out.println("No hay empleados disponibles llamada " + llamada.getId() + " esta en cola");
            ParametrosGlobales.getInstance().getLlamadaEnEspera().add(llamada);
        }

    }

    /**
     * Asigna la llamada al empleado recibido por parametro y la envia a traves
     * de un hilo de ejcucion haciendo uso del objeto {@link ExecutorService}
     *
     * @param empleadoDTO representa el empleado disponible para recibir la
     * llamada
     */
    private void asignarLlamada(EmpleadoDTO empleadoDTO) {
        ResponderLlamada responderLlamada = new ResponderLlamada(empleadoDTO);
        service.submit(responderLlamada);
    }

    /**
     * Este metodo actua como un listener esperando la respuesta de cada llamada
     * recibida, una vez se finaliza una llamada se libera al empleado para que
     * este disponible para recibir la siguiente llamada
     *
     * @throws Exception
     */
    public void monitorearResultados() throws Exception {
        while (!executor.isTerminated()) {
            try {
                RespuestaLlamada respuestaLlamada = service.take().get();
                System.out.println(respuestaLlamada.getEmpleadoDTO().getTipoEmpleado().getCargo()
                        + " ID " + respuestaLlamada.getEmpleadoDTO().getId() + " TERMINA llamada ["
                        + respuestaLlamada.getEmpleadoDTO().getLlamada().getId() + "] Dracion: "
                        + respuestaLlamada.getEmpleadoDTO().getLlamada().getDuracionLlamada());
                liberarEmpleado(respuestaLlamada.getEmpleadoDTO());
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
        executor.shutdown();
        System.out.println("Finalizo ");
    }

    /**
     * Busca de manera jerquica cual de los empleados esta disponible empezando
     * por los operadores
     *
     * @param tipoEmpleado {@link TipoEmpleado} tipo del empleado a buscar
     * @return {@link TipoEmpleado} de lo contrario retonara null si no hay
     * ningun empleado disponible
     */
    private EmpleadoDTO buscarEmpleadoDisponible(TipoEmpleado tipoEmpleado) {
        for (int i = 0; i < ParametrosGlobales.getInstance().getPilaEmpleados().size(); i++) {
            EmpleadoDTO empleado = ParametrosGlobales.getInstance().getPilaEmpleados().get(i);
            if (empleado.isDisponible() && empleado.getTipoEmpleado().equals(tipoEmpleado)) {
                ParametrosGlobales.getInstance().getPilaEmpleados().get(i).setDisponible(false);
                return ParametrosGlobales.getInstance().getPilaEmpleados().get(i);
            }
        }
        return null;
    }

    /**
     * Libera al empeado que termina de recibir una llamada
     *
     * @param empleado {@link EmpleadoDTO} empleado a liberar
     */
    private void liberarEmpleado(EmpleadoDTO empleado) {
        int posicionEmpleado = ParametrosGlobales.getInstance().getPilaEmpleados().size()
                - ParametrosGlobales.getInstance().getPilaEmpleados().search(empleado);
        ParametrosGlobales.getInstance().getPilaEmpleados().get(posicionEmpleado).setDisponible(true);
        if (!ParametrosGlobales.getInstance().getLlamadaEnEspera().isEmpty()) {
            dispatchCall(ParametrosGlobales.getInstance().getLlamadaEnEspera().poll());
        }

    }
}
