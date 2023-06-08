/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.BeneficioDto;
import com.usuarios.usuarios.Dto.mensajeDto;
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
    private String registro_par;
    
    @Transactional
    public mensajeDto registrarIngreso(BeneficioDto dto) {
        java.util.Date fecha = new Date();
        mensajeDto mensaje = new mensajeDto();
        final Beneficio Beneficio = new Beneficio();
        Beneficio.setId_cuenta(dto.getId_cuenta());
        Beneficio.setUsuario_agricultor(dto.getUsuario_agricultor());
        Beneficio.setMatricula_autorizada(dto.getMatricula_autorizada());
        Beneficio.setLicencia_autorizada(dto.getLicencia_autorizada());
        Beneficio.setUsuario_beneficio(dto.getUsuario_beneficio());
        Beneficio.setFecha_asignacion(fecha);
        String user = dto.getUsuario_agricultor();
        String placa = dto.getMatricula_autorizada();
        String licencia = dto.getLicencia_autorizada();
        String activo = "1020";

        if (this.parcialidad(dto.getUsuario_beneficio(), dto.getId_cuenta(), dto.getId_parcialidad())) {
            if (registro_par == "true") {
                mensaje.setMensaje("No Autorizado, ya existe registro de ingreso para este identificador de parcialidad");
                return mensaje;
            } else {
                System.out.println("cuenta///"+dto.getId_cuenta());
                if (this.consultarCuenta(dto.getId_cuenta())) {
                    if (this.usuario_agricultor.equals(user)) {
                        System.out.println("Mostrando...." + this.usuario_agricultor);
                        String res = BeneficioRepositories.consultarMatricula(placa, user);
                        if (res != null) {
                            if (res.equals(activo)) {
                                String lic = BeneficioRepositories.consultarLicencia(licencia, user);
                                if (lic != null) {
                                    if (lic.equals(activo)) {
                                        mensaje.setMensaje("El ingreso es permitido, Bienvenido a Beneficio");

                                        int actualizarEstado = BeneficioRepositories.actualizaE(dto.getId_cuenta(), fecha);
                                        int actualizarParcialidad = BeneficioRepositories.actualizaParcialidad(dto.getId_parcialidad(),dto.getUsuario_beneficio(), fecha);
                                        BeneficioRepositories.save(Beneficio);
                                        return mensaje;
                                    } else {
                                        mensaje.setMensaje("El transportista no tiene permitido el ingreso.  ");
                                        return mensaje;
                                    }
                                } else {
                                    mensaje.setMensaje("No se obtuvieron datos del Transportista");
                                    return mensaje;
                                }
                            } else {
                                mensaje.setMensaje("La matricula del Transporte no tiene permitido el ingreso. ");
                                return mensaje;
                            }
                        } else {
                            mensaje.setMensaje("No se obtuvieron datos del Transporte.");
                            return mensaje;
                        }
                    } else {
                        mensaje.setMensaje("El usuario no tiene asignado el numero de cuenta ingresado. ");
                        return mensaje;
                    }
                } else {
                    mensaje.setMensaje("No se obtuvieron datos de la cuenta");
                    return mensaje;
                }
            }
        } else {
            mensaje.setMensaje("Operacion fallida, no se obtuvo informacion del identificador de parcialidad");
            return mensaje;
        }
    }

    public boolean parcialidad(String u, Integer c, String id) {
        String datos = BeneficioRepositories.consultarparcialidad(u, c, id);
        if (datos != null || datos != "") {
            this.registro_par = datos;
            return true;
        } else {
            return false;
        }
    }

    public boolean consultarCuenta(Integer id_cuenta) {  //Metodo para consultar datos sobre la cuenta ingresada por medio del parametro recibido id_cuenta
        String respuesta = BeneficioRepositories.consultarCuenta(id_cuenta);
        if (respuesta != null && respuesta != "") {
            String[] parts = respuesta.split(",");
            this.id_cuenta = parts[0]; //numero de cuenta
            this.estado_cuenta = parts[1]; //estado de la cuenta
            this.usuario_agricultor = parts[2]; //Usuario del agricultor
            this.numero_pesajes_registrados = Integer.parseInt(parts[3]); //pesajes realizados
            this.numero_parcialidades = Integer.parseInt(parts[4]); //numero de parcialidades

            System.out.println("Mostrando variables: " + this.id_cuenta + " " + estado_cuenta + " " + usuario_agricultor + " " + numero_pesajes_registrados + " " + numero_parcialidades);
            return true;
        } else {
            System.out.println("hola");
            return false;
        }
    }
}
