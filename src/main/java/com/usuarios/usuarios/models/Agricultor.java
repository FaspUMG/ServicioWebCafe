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
    private String cuenta;
    private String id_parcialidad; 
    private String  usuario;
    private String matricula;
    private String numero_licencia;
    private String peso_de_envio;
    private Date fecha_creacion;
    private Date fecha_entrega;
    private String usuario_concedio_ingreso;
    private boolean ingreso_en_beneficio;
    private Integer ba2;
    private String usuario_registro_pesaje;

    public Agricultor() {
    }

    public Agricultor(String id_parcialidad, Integer String, String usuario, String matricula, String numero_licencia, String peso_de_envio, Date fecha_creacion, Date fecha_entrega, String usuario_concedio_ingreso, boolean ingreso_en_beneficio, Integer ba2, String usuario_registro_pesaje) {
        this.id_parcialidad = id_parcialidad;
        this.cuenta = cuenta;
        this.usuario = usuario;
        this.matricula = matricula;
        this.numero_licencia = numero_licencia;
        this.peso_de_envio = peso_de_envio;
        this.fecha_creacion = fecha_creacion;
        this.fecha_entrega = fecha_entrega;
        this.usuario_concedio_ingreso = usuario_concedio_ingreso;
        this.ingreso_en_beneficio = ingreso_en_beneficio;
        this.ba2 = ba2;
        this.usuario_registro_pesaje = usuario_registro_pesaje;
    }

    @Id
    @Column (name="id_parcialidad")
    public String getId_parcialidad() {
        return id_parcialidad;
    }

    @Column (name="cuenta")
    public String getCuenta() {
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

    @Column (name="ingreso_en_beneficio")
    public boolean isIngreso_en_beneficio() {
        return ingreso_en_beneficio;
    }

    @Column (name="ba2")
    public Integer getBa2() {
        return ba2;
    }

    @Column (name="usuario_concedio_ingreso")
    public String getUsuario_concedio_ingreso() {
        return usuario_concedio_ingreso;
    }

    @Column (name="usuario_registro_pesaje")
    public String getUsuario_registro_pesaje() {
        return usuario_registro_pesaje;
    }

    public void setId_parcialidad(String id_parcialidad) {
        this.id_parcialidad = id_parcialidad;
    }

    public void setCuenta(String cuenta) {
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

    public void setBa2(Integer ba2) {
        this.ba2 = ba2;
    }

    public void setUsuario_concedio_ingreso(String usuario_concedio_ingreso) {
        this.usuario_concedio_ingreso = usuario_concedio_ingreso;
    }

    public void setUsuario_registro_pesaje(String usuario_registro_pesaje) {
        this.usuario_registro_pesaje = usuario_registro_pesaje;
    }

    public void setIngreso_en_beneficio(boolean ingreso_en_beneficio) {
        this.ingreso_en_beneficio = ingreso_en_beneficio;
    }
}
