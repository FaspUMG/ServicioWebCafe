
package com.usuarios.usuarios.Dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class usuarioDto {
    private String nit;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String correo;
    private Integer edad;
    private String telefono;
    private String direccion;
   
    
}
