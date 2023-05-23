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
public class BeneficioDto {
    private Integer id_ingreso;
    private Integer id_cuenta;
    private String usuario_agricultor;
    private String matricula_autorizada;
    private String licencia_autorizada;
    //private Date fecha_asignacion;
}
