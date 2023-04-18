/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fasp9
 */
@Entity
@Table(name="Agricultor", schema="public")
public class Agricultor {
    private String nit;
    private String nombre_comercial;
    private String contrasena;
    private String correo;
    private Integer edad;
    private String telefono;
    private String direccion;
    private String estado;
    private Date fecha_inscripcion;
    private Date fecha_modificacion;

    public Agricultor() {
    }

    public Agricultor(String nit, String nombre_comercial, String contrasena, String correo, Integer edad, String telefono, String direccion, String estado, Date fecha_inscripcion, Date fecha_modificacion) {
        this.nit = nit;
        this.nombre_comercial = nombre_comercial;
        this.contrasena = contrasena;
        this.correo = correo;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_modificacion = fecha_modificacion;
    }

    @Id
    @Column (name="nit", length=50)
    public String getNit() {
        return nit;
    }

    @Column (name="nombre_comercial", length=50)
    public String getNombre_comercial() {
        return nombre_comercial;
    }

   

    @Column (name="contrasena", length=50)
    public String getContrasena() {
        return contrasena;
    }

    @Column (name="correo", length=50)
    public String getCorreo() {
        return correo;
    }

    @Column (name="edad")
    public Integer getEdad() {
        return edad;
    }

    @Column (name="telefono", length=50)
    public String getTelefono() {
        return telefono;
    }

    @Column (name="direccion", length=50)
    public String getDireccion() {
        return direccion;
    }

    @Column (name="estado", length=50)
    public String getEstado() {
        return estado;
    }

    @Column (name="fecha_inscripcion")
    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    @Column (name="fecha_modificacion")
    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
    
    
    
}
