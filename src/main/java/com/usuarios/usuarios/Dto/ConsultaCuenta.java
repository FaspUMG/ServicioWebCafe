/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.Dto;

import java.util.Date;

/**
 *
 * @author fasp9
 */
public class ConsultaCuenta {
    
    
    private Integer id_cuenta;
    private String estado_cuenta;
    private Integer peso_total_de_envio;
    private Integer numero_parcialidades;
    private String[] matriculas_autorizadas = new String[]{};
    private String nit_agricultor;
    private Integer numero_pesajes_registrados;
    private Date fecha_creacion;
    private Date fecha_modificacion;

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public Integer getPeso_total_de_envio() {
        return peso_total_de_envio;
    }

    public void setPeso_total_de_envio(Integer peso_total_de_envio) {
        this.peso_total_de_envio = peso_total_de_envio;
    }

    public Integer getNumero_parcialidades() {
        return numero_parcialidades;
    }

    public void setNumero_parcialidades(Integer numero_parcialidades) {
        this.numero_parcialidades = numero_parcialidades;
    }

    public String[] getMatriculas_autorizadas() {
        return matriculas_autorizadas;
    }

    public void setMatriculas_autorizadas(String[] matriculas_autorizadas) {
        this.matriculas_autorizadas = matriculas_autorizadas;
    }

    public String getNit_agricultor() {
        return nit_agricultor;
    }

    public void setNit_agricultor(String nit_agricultor) {
        this.nit_agricultor = nit_agricultor;
    }

    public Integer getNumero_pesajes_registrados() {
        return numero_pesajes_registrados;
    }

    public void setNumero_pesajes_registrados(Integer numero_pesajes_registrados) {
        this.numero_pesajes_registrados = numero_pesajes_registrados;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
    
    
}
