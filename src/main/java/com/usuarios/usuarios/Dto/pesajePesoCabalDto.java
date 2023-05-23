package com.usuarios.usuarios.Dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class pesajePesoCabalDto {
    private Integer id_cuenta ;
    private String matricula;
    private String numero_licencia;
    private Integer peso_marcado;
    private Integer peso_de_camion;
    private String agricultor;
    private String usuario_registro_pesaje;
    private Date fecha_creacion ;
    //private Integer peso_cargamento;
 }
