
package com.usuarios.usuarios.Dto;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransporteDto {
    private String matricula;
    private Integer modelo;
    private String numero_ejes;
    private String marca;
    private String color;
    //private Integer peso_de_camion;
    private String usuario_creo;
    
}
