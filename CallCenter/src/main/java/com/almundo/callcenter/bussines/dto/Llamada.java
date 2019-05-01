/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.bussines.dto;

import com.almundo.callcenter.common.base.AbstractEntity;
import java.util.Date;

/**
 * Objeto que representa una llamada
 *
 * @author Andres Alarcon
 */
public class Llamada extends AbstractEntity  {

    private String numeroTelefonico;
    private String paisProveniente;
    private Date horaLlamada;
    private Double duracionLlamada;
    private EmpleadoDTO empleadoDTO;
    

    /**
     * @return the numeroTelefonico
     */
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    /**
     * @param numeroTelefonico the numeroTelefonico to set
     */
    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    /**
     * @return the paisProveniente
     */
    public String getPaisProveniente() {
        return paisProveniente;
    }

    /**
     * @param paisProveniente the paisProveniente to set
     */
    public void setPaisProveniente(String paisProveniente) {
        this.paisProveniente = paisProveniente;
    }

    /**
     * @return the horaLlamada
     */
    public Date getHoraLlamada() {
        return horaLlamada;
    }

    /**
     * @param horaLlamada the horaLlamada to set
     */
    public void setHoraLlamada(Date horaLlamada) {
        this.horaLlamada = horaLlamada;
    }

    /**
     * @return the duracionLlamada
     */
    public Double getDuracionLlamada() {
        return duracionLlamada;
    }

    /**
     * @param duracionLlamada the duracionLlamada to set
     */
    public void setDuracionLlamada(Double duracionLlamada) {
        this.duracionLlamada = duracionLlamada;
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
