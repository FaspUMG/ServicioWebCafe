/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fasp9
 */
@Entity
@Table(name="Agricultor", schema="public")
public class Agricultor {
    private Integer cuenta;
    private Integer id_parcialidad; 
    private String  usuario;
    private String matricula;
    private String numero_licencia;
    private String peso_de_envio;
    private Date fecha_creacion;
    private Date fecha_entrega;
    private String usuario_recibio;
    private boolean ba1;
    private Integer ba2;
    private String ba3;

    public Agricultor() {
    }

    public Agricultor(Integer id_parcialidad, Integer cuenta, String usuario, String matricula, String numero_licencia, String peso_de_envio, Date fecha_creacion, Date fecha_entrega, String usuario_recibio, boolean ba1, Integer ba2, String ba3) {
        this.id_parcialidad = id_parcialidad;
        this.cuenta = cuenta;
        this.usuario = usuario;
        this.matricula = matricula;
        this.numero_licencia = numero_licencia;
        this.peso_de_envio = peso_de_envio;
        this.fecha_creacion = fecha_creacion;
        this.fecha_entrega = fecha_entrega;
        this.usuario_recibio = usuario_recibio;
        this.ba1 = ba1;
        this.ba2 = ba2;
        this.ba3 = ba3;
    }

    @Id
    @Column (name="id_parcialidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_parcialidad() {
        return id_parcialidad;
    }

    @Column (name="cuenta")
    public Integer getCuenta() {
        return cuenta;
    }
    
    @Column (name="usuario")
    public String getUsuario() {
        return usuario;
    }

    @Column (name="matricula")
    public String getMatricula() {
        return matricula;
    }

    @Column (name="numero_licencia")
    public String getNumero_licencia() {
        return numero_licencia;
    }

    @Column (name="peso_de_envio")
    public String getPeso_de_envio() {
        return peso_de_envio;
    }

    @Column (name="fecha_creacion")
    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    @Column (name="fecha_entrega")
    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    @Column (name="usuario_recibio")
    public String getUsuario_recibio() {
        return usuario_recibio;
    }

    @Column (name="ba1")
    public boolean isBa1() {
        return ba1;
    }

    @Column (name="ba2")
    public Integer getBa2() {
        return ba2;
    }

    @Column (name="ba3")
    public String getBa3() {
        return ba3;
    }

    public void setId_parcialidad(Integer id_parcialidad) {
        this.id_parcialidad = id_parcialidad;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public void setPeso_de_envio(String peso_de_envio) {
        this.peso_de_envio = peso_de_envio;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setUsuario_recibio(String usuario_recibio) {
        this.usuario_recibio = usuario_recibio;
    }

    public void setBa1(boolean ba1) {
        this.ba1 = ba1;
    }

    public void setBa2(Integer ba2) {
        this.ba2 = ba2;
    }

    public void setBa3(String ba3) {
        this.ba3 = ba3;
    }
    
    
 
}
