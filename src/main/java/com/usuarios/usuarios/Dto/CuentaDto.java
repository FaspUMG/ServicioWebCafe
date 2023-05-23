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
public class CuentaDto {
   // private Integer id_cuenta;
    //private String estado_cuenta;
    private Integer peso_total_de_envio;
    private Integer numero_parcialidades;
    private String matriculas_autorizadas;
    private String usuario_agricultor;
    //private Integer numero_pesajes_registrados;
}
