/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.common.base;

/**
 * Entidad base abstracta que mantiene un id único para el objeto.
 *
 * @author Andres Alarcon
 */
public class AbstractEntity {

    private static final long serialVersionUID = SerialVersion.SERIAL_VERSION_UID;
    /**
     * Id único dominio.
     */
    private Long id;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
