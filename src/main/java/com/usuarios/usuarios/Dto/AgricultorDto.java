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
   // private Integer id_parcialidad;
    private Integer cuenta;
    private String  usuario;
    private String matricula;
    private String numero_licencia;
    private String peso_de_envio;
    //private Date fecha_creacion;
    //private Date fecha_entrega;
    //private String usuario_recibio;
    //private boolean ba1;
    //private Integer ba2;
    //private String ba3;
    
    
}
