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
@Table(name="Beneficio", schema="public")
public class Beneficio {
    private Integer id_ingreso;
    private Integer id_cuenta;
    private String usuario_agricultor;
    private String matricula_autorizada;
    private String licencia_autorizada;
    private Date fecha_asignacion;

    public Beneficio() {
    }

    public Beneficio(Integer id_ingreso, Integer id_cuenta, String usuario_agricultor, String matricula_autorizada, String licencia_autorizada, Date fecha_asignacion) {
        this.id_ingreso = id_ingreso;
        this.id_cuenta = id_cuenta;
        this.usuario_agricultor = usuario_agricultor;
        this.matricula_autorizada = matricula_autorizada;
        this.licencia_autorizada = licencia_autorizada;
        this.fecha_asignacion = fecha_asignacion;
    }

    @Id
    @Column (name="id_ingreso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_ingreso() {
        return id_ingreso;
    }

    @Column (name="id_cuenta", length=13)
    public Integer getId_cuenta() {
        return id_cuenta;
    }

    @Column (name="usuario_agricultor", length=25)
    public String getUsuario_agricultor() {
        return usuario_agricultor;
    }

    @Column (name="matricula_autorizada", length=13)
    public String getMatricula_autorizada() {
        return matricula_autorizada;
    }

    @Column (name="licencia_autorizada", length=13)
    public String getLicencia_autorizada() {
        return licencia_autorizada;
    }

    @Column (name="fecha_asignacion", length=13)
    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setId_ingreso(Integer id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    
    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public void setUsuario_agricultor(String usuario_agricultor) {
        this.usuario_agricultor = usuario_agricultor;
    }

    public void setMatricula_autorizada(String matricula_autorizada) {
        this.matricula_autorizada = matricula_autorizada;
    }

    public void setLicencia_autorizada(String licencia_autorizada) {
        this.licencia_autorizada = licencia_autorizada;
    }

    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }
      
}

