/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.bussines.dto;

/**
 * Representa el tipo de cargo que tiene un empleado
 *
 * @author Andres Alarcon
 */
public enum TipoEmpleado {

    OPERADOR(1L, "OPERADOR"),
    SUPERVISOR(2L, "SUPERVISOR"),
    DIRECTOR(3L, "DIRECTOR");
    public Long idTipoEmpelado;
    public String cargo;

    private TipoEmpleado(Long idTipoEmpelado, String cargo) {
        this.idTipoEmpelado = idTipoEmpelado;
        this.cargo = cargo;
    }

    /**
     * @return the idTipoEmpelado
     */
    public Long getIdTipoEmpelado() {
        return idTipoEmpelado;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

}
