package com.usuarios.usuarios.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class pesajePesoCabalDto {
    private Integer id_peso;
    private Integer id_cuenta ;
    private String matricula;
    private String numero_licencia;
    private Integer peso_marcado;
    private Integer peso_de_camion;
    //private Integer peso_cargamento;
 }
