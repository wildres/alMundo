/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.bussines.dto;

/**
 * Abstrae la respuesta de una llamada
 * @author andresalarcon
 */
public class RespuestaLlamada {
    private EmpleadoDTO empleadoDTO;
    
    public RespuestaLlamada(EmpleadoDTO empleadoDTO){
        this.empleadoDTO=empleadoDTO;
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
