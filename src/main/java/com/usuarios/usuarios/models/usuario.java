
package com.usuarios.usuarios.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario", schema="public")
public class usuario {
    private String nit;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String correo;
    private Integer edad;
    private String telefono;
    private String direccion;
    private  String estado;
    private Date fecha_inscripcion;
    private Date fecha_modificacion;

    public usuario() {
    }

    public usuario(String nit, String nombre, String apellido, String contrasena, String correo, Integer edad, String telefono, String direccion, String estado, Date fecha_inscripcion, Date fecha_modificacion) {
        this.nit = nit;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.correo = correo;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_modificacion = fecha_modificacion;
    }

    @Column (name="fecha_modificacion", length=30)
    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    @Id
    @Column (name="nit", length=50)
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    @Column (name="nombre", length=50)
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    @Column (name="estado", length=50)
    public String getEstado() {
        return estado;
    }
    
     public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column (name="fecha_inscripcion", length=50)
    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }
    
    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    @Column (name="apellido", length=50)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @Column (name="contrasena", length=30)
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    @Column( name = "correo" , length = 50)
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Column(name = "edad" )
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name = "direccion", length=50)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
