/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.bussines.dto;

import com.almundo.callcenter.common.base.AbstractEntity;

/**
 * Abstrae la representacion de un empleado
 * @author Andres Alarcon
 */
public class EmpleadoDTO extends AbstractEntity  {
    
    private TipoEmpleado tipoEmpleado;
    private Llamada llamada;
    private boolean disponible;
    
    public EmpleadoDTO(TipoEmpleado tipoEmpleado, Long id,boolean disponible) {
        super.setId(id);
        this.tipoEmpleado = tipoEmpleado;
        this.disponible=disponible;
        
    }
    
    public EmpleadoDTO(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    /**
     * @return the tipoEmpleado
     */
    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    /**
     * @param tipoEmpleado the tipoEmpleado to set
     */
    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    /**
     * @return the llamada
     */
    public Llamada getLlamada() {
        return llamada;
    }

    /**
     * @param llamada the llamada to set
     */
    public void setLlamada(Llamada llamada) {
        this.llamada = llamada;
    }

    /**
     * @return the disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
}
