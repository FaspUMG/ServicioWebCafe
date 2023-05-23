
package com.usuarios.usuarios.models;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Transportista", schema="public")
public class Transportista {
    private String numero_licencia ; 
    private String nombres; 
    private String apellidos; 
    private String tipo_licencia;
    private Integer estado;
    private Date fecha_inscripcion;
    private Date fecha_modificacion;
    private String usuario_creo;
    private String usuario_modifico;
    private boolean disponibilidad;
    //private String nit;

    public Transportista() {
    }

    public Transportista(String numero_licencia, String nombres, String apellidos, String tipo_licencia, Integer estado, Date fecha_inscripcion, Date fecha_modificacion, String usuario_creo, String usuario_modifico, boolean disponibilidad) {
        this.numero_licencia = numero_licencia;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo_licencia = tipo_licencia;
        this.estado = estado;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_modificacion = fecha_modificacion;
        this.usuario_creo = usuario_creo;
        this.usuario_modifico = usuario_modifico;
        this.disponibilidad = disponibilidad;
        //this.nit = nit;
    }

    @Id
    @Column (name="numero_licencia", length=13)
    public String getNumero_licencia() {
        return numero_licencia;
    }

    @Column (name="nombres", length=50)
    public String getNombres() {
        return nombres;
    }

    @Column (name="apellidos", length=50)
    public String getApellidos() {
        return apellidos;
    }

    @Column (name="tipo_licencia", length=13)
    public String getTipo_licencia() {
        return tipo_licencia;
    }

    @Column (name="estado")
    public Integer getEstado() {
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

    @Column (name="usuario_creo", length=13)
    public String getUsuario_creo() {
        return usuario_creo;
    }
    
    @Column (name="usuario_modifico", length=13)
    public String getUsuario_modifico() {
        return usuario_modifico;
    }
    
    @Column (name="disponibilidad")
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    
    /*@Column (name="nit", length=13)
    public String getNit() {
        return nit;
    }*/
    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public void setUsuario_creo(String usuario_creo) {
        this.usuario_creo = usuario_creo;
    }

    public void setUsuario_modifico(String usuario_modifico) {
        this.usuario_modifico = usuario_modifico;
    }

    /*public void setNit(String nit) {
        this.nit = nit;
    }*/

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
}
