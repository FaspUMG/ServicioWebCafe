/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.modelsPesaje;

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
@Table(name="pesaje_peso_cabal", schema="public")
public class Pesajes {
    private Integer id_peso;
    private Integer id_cuenta ;
    private String matricula;
    private String numero_licencia;
    private Integer peso_de_camion;
    private Integer peso_marcado;
    private Integer peso_cargamento;
    private String agricultor;
    private String usuario_registro_pesaje;
    private Date fecha_creacion ;

    public Pesajes(Integer id_peso, Integer id_cuenta, String matricula, String numero_licencia, Integer peso_de_camion, Integer peso_marcado, Integer peso_cargamento, String agricultor, String usuario_registro_pesaje, Date fecha_creacion) {
        this.id_peso = id_peso;
        this.id_cuenta = id_cuenta;
        this.matricula = matricula;
        this.numero_licencia = numero_licencia;
        this.peso_de_camion = peso_de_camion;
        this.peso_marcado = peso_marcado;
        this.peso_cargamento = peso_cargamento;
        this.agricultor = agricultor;
        this.usuario_registro_pesaje = usuario_registro_pesaje;
        this.fecha_creacion = fecha_creacion;
    }

    public Pesajes() {
    }

    @Id
    @Column (name="id_peso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_peso() {
        return id_peso;
    }

    @Column (name="id_cuenta")
    public Integer getId_cuenta() {
        return id_cuenta;
    }

     @Column (name="matricula")
    public String getMatricula() {
        return matricula;
    }

     @Column (name="numero_licencia")
    public String getNumero_licencia() {
        return numero_licencia;
    }

     @Column (name="peso_de_camion")
    public Integer getPeso_de_camion() {
        return peso_de_camion;
    }

     @Column (name="peso_marcado")
    public Integer getPeso_marcado() {
        return peso_marcado;
    }

     @Column (name="peso_cargamento")
    public Integer getPeso_cargamento() {
        return peso_cargamento;
    }

     @Column (name="agricultor")
    public String getAgricultor() {
        return agricultor;
    }

     @Column (name="usuario_registro_pesaje")
    public String getUsuario_registro_pesaje() {
        return usuario_registro_pesaje;
    }

     @Column (name="fecha_creacion")
    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setId_peso(Integer id_peso) {
        this.id_peso = id_peso;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public void setPeso_de_camion(Integer peso_de_camion) {
        this.peso_de_camion = peso_de_camion;
    }

    public void setPeso_marcado(Integer peso_marcado) {
        this.peso_marcado = peso_marcado;
    }

    public void setPeso_cargamento(Integer peso_cargamento) {
        this.peso_cargamento = peso_cargamento;
    }

    public void setAgricultor(String agricultor) {
        this.agricultor = agricultor;
    }

    public void setUsuario_registro_pesaje(String usuario_registro_pesaje) {
        this.usuario_registro_pesaje = usuario_registro_pesaje;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
}
