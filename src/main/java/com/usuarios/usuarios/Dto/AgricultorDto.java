/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.Dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fasp9
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AgricultorDto {
    private String nit;
    private String nombre_comercial;
    private String contrasena;
    private String correo;
    private Integer edad;
    private String telefono;
    private String direccion;
    //private String estado;
    //private Date fecha_inscripcion;
    //private Date fecha_modificacion;
    
}
