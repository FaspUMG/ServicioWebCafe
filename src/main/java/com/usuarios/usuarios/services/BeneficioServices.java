/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.BeneficioDto;
import com.usuarios.usuarios.models.Beneficio;
import com.usuarios.usuarios.repositories.BeneficioRepositories;
import com.usuarios.usuarios.repositories.pesajePesoCabalRepositories;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fasp9
 */
@Service
@Transactional
public class BeneficioServices {
    @Autowired
    BeneficioRepositories BeneficioRepositories;
    
    private String id_cuenta;
    private String estado_cuenta;
    private String usuario_agricultor;
    private int numero_pesajes_registrados;
    private int numero_parcialidades;
    private String matriculas;
    private String estadoMatricula;
    private String disponibilidad;
    
    @Transactional
    public String registrarIngreso(BeneficioDto dto) {
        java.util.Date fecha = new Date();
        final Beneficio Beneficio = new Beneficio();
        Beneficio.setId_cuenta(dto.getId_cuenta());
        Beneficio.setUsuario_agricultor(dto.getUsuario_agricultor());
        Beneficio.setMatricula_autorizada(dto.getMatricula_autorizada());
        Beneficio.setLicencia_autorizada(dto.getLicencia_autorizada());
        Beneficio.setFecha_asignacion(fecha);
        Integer cuenta = dto.getId_cuenta();
        String id = cuenta.toString();
        String user = dto.getUsuario_agricultor();
        String placa = dto.getMatricula_autorizada();
        String licencia = dto.getLicencia_autorizada();
        String activo = "1020";
        if(this.consultarCuenta(cuenta)==true){
        if (this.usuario_agricultor.equals(user)) {
            System.out.println("Mostrando...."+this.usuario_agricultor);
            String res = BeneficioRepositories.consultarMatricula(placa, user);
            if (res != null) {
                if (res.equals(activo)) {
                    String lic = BeneficioRepositories.consultarLicencia(licencia, user);
                    if (lic != null) {
                        if (lic.equals(activo)) {
                            return " El ingreso es permitido";
                        } else {
                            return "El transportista no tiene permitido el ingreso.  ";
                        }
                    } else {
                        return "No se obtuvieron datos del Transportista";
                    }
                } else {
                    return "La matricula del Transporte no tiene permitido el ingreso. ";
                }
            } else {
                return "No se obtuvieron datos del Transporte.";
            }
        } else {
            return "El usuario no tiene asignado el numero de cuenta ingresado. ";
        }
        }else{
            return "No se obtuvieron datos de la cuenta";
        }
    }
    
    
    public boolean consultarCuenta(Integer id_cuenta) {  //Metodo para consultar datos sobre la cuenta ingresada por medio del parametro recibido id_cuenta
        Integer pid_cuenta = id_cuenta;
        String respuesta = BeneficioRepositories.consultarCuenta(pid_cuenta);
        if (respuesta != null && respuesta != "") {
            String[] parts = respuesta.split(",");
            this.id_cuenta = parts[0]; //numero de cuenta
            this.estado_cuenta = parts[1]; //estado de la cuenta
            this.usuario_agricultor = parts[2]; //Usuario del agricultor
            this.numero_pesajes_registrados = Integer.parseInt(parts[3]); //pesajes realizados
            this.numero_parcialidades = Integer.parseInt(parts[4]); //numero de parcialidades
            
            System.out.println("Mostrando variables: " +this.id_cuenta + " " + estado_cuenta + " " + usuario_agricultor + " " + numero_pesajes_registrados + " " + numero_parcialidades);
            return true;
        } else {
            System.out.println("hola");
            return false;
        }
    }
    
    
     /*public String consultarMatricula(String matricula) {  //Metodo para consultar datos sobre la cuenta ingresada por medio del parametro recibido id_cuenta
        String pmatricula = matricula;
        
        if (respuesta != null && respuesta != "") {
            String[] parts = respuesta.split(",");
            this.estadoMatricula = parts[0]; //numero de cuenta
            this.disponibilidad = parts[1]; //estado de la cuenta
            System.out.println("Mostrando variables: " + estadoMatricula + " " + disponibilidad );
            return "Mostrando resultado";
        } else {
            return "no se encontraron los datos de la cuenta";
        }
    }*/
    
}
