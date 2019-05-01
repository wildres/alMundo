/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.controlador;

import com.almundo.callcenter.bussines.dto.EmpleadoDTO;
import com.almundo.callcenter.bussines.dto.RespuestaLlamada;
import com.almundo.callcenter.common.base.AbstractEntity;
import java.util.concurrent.Callable;

/**
 * Clase encargada de procesar una llamada simulando un tiempo determinado
 *
 * @author andresalarcon
 */
public class ResponderLlamada extends AbstractEntity implements Callable<RespuestaLlamada> {

    private EmpleadoDTO empleadoDTO;

    /**
     * Constructor de la clase
     *
     * @param empleadoDTO {@link  EmpleadoDTO} empleado quien respondera la
     * llamada
     */
    public ResponderLlamada(EmpleadoDTO empleadoDTO) {
        this.empleadoDTO = empleadoDTO;
    }

    @Override
    public RespuestaLlamada call() throws Exception {
        System.out.println(getEmpleadoDTO().getTipoEmpleado().getCargo() + " ID " + this.getEmpleadoDTO().getId() + " Inicia Llamada [" + getEmpleadoDTO().getLlamada().getId() + "]");
        long startTime = System.nanoTime();
        this.simularTiempoDeLlamada((int) (Math.random() * 10) + 1);
        double finalza = (System.nanoTime() - startTime) / 1000000000.0;
//        System.out.println("....TERMINA LLAMADA [" + this.llamada.getId() + "]");
        getEmpleadoDTO().getLlamada().setDuracionLlamada(finalza);
        return new RespuestaLlamada(getEmpleadoDTO());

    }

    /**
     * Simula el tiempo que podria tardar una llamada en segundos
     * @param segundos tiempo en que esperara llamada
     */
    private void simularTiempoDeLlamada(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * @return the empleadoDTO
     */
    public EmpleadoDTO getEmpleadoDTO() {
        return empleadoDTO;
    }

    /**
     * @param empleadoDTO the empleadoDTO to set
     */
    public void setEmpleadoDTO(EmpleadoDTO empleadoDTO) {
        this.empleadoDTO = empleadoDTO;
    }
}
