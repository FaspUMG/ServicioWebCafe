
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.CuentaDto;
import com.usuarios.usuarios.Dto.mensajeDto;
import com.usuarios.usuarios.Dto.pesajePesoCabalDto;
import com.usuarios.usuarios.models.Cuenta;
import com.usuarios.usuarios.models.pesajePesoCabal;
import com.usuarios.usuarios.repositories.CuentaRepositories;
import com.usuarios.usuarios.repositories.pesajePesoCabalRepositories;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usuarios.usuarios.repositories.TransportistaRepositories;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class pesajePesoCabalServices { 
    private String creada= "Cuenta Creada";
    private String completada= "Pesaje Finalizado";
    private String confirmada = "Cuenta Confirmada";
    private String cerrada = "Cuenta Cerrada";
    private String id_cuenta;
    private String estado_cuenta;
    private Integer peso_total_de_envio;
    private Integer numero_parcialidades;
    private String matriculas_autorizadas;
    private String usuario_agricultor;
    private Integer numero_pesajes_registrados;
    private String matriculas;
    private int completado;
    
    @Autowired
    pesajePesoCabalRepositories pesajePesoCabalRepositories;
    
    @Autowired
    CuentaRepositories CuentaRepositories;
    
    @Transactional
    public List<pesajePesoCabal> getAllPesajes(){
        return pesajePesoCabalRepositories.findAll();
    }
    
    @Transactional
    public mensajeDto createPesaje(pesajePesoCabalDto dto) {
        java.util.Date fecha = new Date();
        mensajeDto mensaje = new mensajeDto();
        final pesajePesoCabal pesajePesoCabal = new pesajePesoCabal();
        pesajePesoCabal.setId_cuenta(dto.getId_cuenta());
        pesajePesoCabal.setMatricula(dto.getMatricula());
        pesajePesoCabal.setNumero_licencia(dto.getNumero_licencia());
        pesajePesoCabal.setPeso_marcado(dto.getPeso_marcado());
        pesajePesoCabal.setPeso_de_camion(dto.getPeso_de_camion());
        pesajePesoCabal.setAgricultor(dto.getAgricultor());
        pesajePesoCabal.setFecha_creacion(fecha);
        pesajePesoCabal.setUsuario_registro_pesaje(dto.getUsuario_registro_pesaje());
        pesajePesoCabal.setPeso_cargamento((dto.getPeso_marcado()) - (dto.getPeso_de_camion()));
        Integer cuenta = dto.getId_cuenta();
        String id = cuenta.toString();
        String user = dto.getAgricultor();
        String placa = dto.getMatricula();
        if (dto.getPeso_marcado() <= dto.getPeso_de_camion()) {
            mensaje.setMensaje("El pesaje marcado no puede ser menor al peso del camion.");
            return mensaje;
        } else {
            if(this.consultarCuenta(cuenta)){
            this.consultarCuenta(cuenta);
            if(this.estado_cuenta.equals(this.creada) || this.estado_cuenta.equals(this.completada) || this.estado_cuenta.equals(this.confirmada )|| this.estado_cuenta.equals(this.cerrada )){
                mensaje.setMensaje("No se permite registrar el pesaje.  Estado de la cuenta: "+ this.estado_cuenta);
                return mensaje;
            }else{
                System.out.println("El estado actual de la cuenta es: "+this.estado_cuenta);
            if (id.equals(this.id_cuenta)) {
                System.out.println("El numero de cuenta es si esta almacenado.");
                if (user.equals(this.usuario_agricultor)) {
                    System.out.println("El nit es correcto para la cuenta");
                    String[] placas = this.matriculas.split(",");
                    String placa_encontrada = "";
                    for (int i = 0; i < placas.length; i++) {
                        if (placa.equals(placas[i])) {
                            System.out.println("Mostrando la placa enviada para pesaje: " + placas[i]);
                            placa_encontrada = placas[i];
                            //     return "la placa ingresada es permitida para registrar cargamentos.";
                        } else {
                            System.out.println("La placa ingresada no esta permitida para la cuenta seleccionada");
                        }
                        System.out.println("Las placas encontradas son: " + placas[i]);
                    }
                    Integer estado_matricula = pesajePesoCabalRepositories.consultarestadoMatricula(placa_encontrada);
                    if (estado_matricula != null) {
                        if (estado_matricula == 1020) {
                            System.out.println("Matricula Aceptada");
                            Integer estado_Transportista = pesajePesoCabalRepositories.consultarEstadoTransportista(dto.getNumero_licencia());
                            System.out.println("*********"+estado_Transportista);
                            if (estado_Transportista != null) {
                                System.out.println("*********"+estado_Transportista);
                                if (estado_Transportista == 1020) {
                                    System.out.println("Licencia Valida ");
                                    if (this.numero_pesajes_registrados == 0) {
                                        this.completado = pesajePesoCabalRepositories.actualizaPrimerPeso(cuenta);
                                        if (this.completado > 0) {
                                            int modmatri = this.pesajePesoCabalRepositories.actualizaDisTransporte(dto.getMatricula());
                                            if (modmatri > 0) {
                                                int modlic = this.pesajePesoCabalRepositories.actualizaDisLic(dto.getNumero_licencia());
                                                if (modmatri > 0) {
                                                    pesajePesoCabalRepositories.save(pesajePesoCabal);
                                                    mensaje.setMensaje("Pesaje Almacenado con exito y Cuenta actualizada ");
                                                    return mensaje;
                                                } else {
                                                    mensaje.setMensaje("Ocurrio un error al actuaizar disponibilidad del Transportista.");
                                                    return mensaje;
                                                }
                                            } else {
                                                mensaje.setMensaje("Ocurrio un error al actuaizar disponibilidad del Transporte.");
                                                return mensaje;
                                            }
                                        } else {
                                            mensaje.setMensaje("Se produjo un error al realizar la actualizacion de cuenta.");
                                            return mensaje;
                                        }
                                    } else if (this.numero_pesajes_registrados > this.numero_parcialidades) {
                                        mensaje.setMensaje("no se permiten mas ingresos de los estipulados en cuenta.");
                                        return mensaje;
                                    } else if (this.numero_pesajes_registrados == this.numero_parcialidades) {
                                        mensaje.setMensaje("No se permiten mas pesajes para esta cuenta.");
                                        return mensaje;
                                    } else if (this.numero_pesajes_registrados > 0 && this.numero_pesajes_registrados <= this.numero_parcialidades - 2) {
                                        this.completado = pesajePesoCabalRepositories.actualizaNumeroParcialidades(cuenta);
                                        if (this.completado > 0) {
                                            mensaje.setMensaje("Pesaje y Cuenta actualizados correctamente.");
                                            return mensaje;
                                        } else {
                                            mensaje.setMensaje("Se produjo un error al realizar la actualizacion de cuenta.");
                                            return mensaje;
                                        }
                                    } else if (this.numero_pesajes_registrados > 0 && this.numero_pesajes_registrados <= this.numero_parcialidades - 1) {
                                        this.completado = pesajePesoCabalRepositories.actualizaUltimoPesaje(cuenta);
                                        if (this.completado > 0) {
                                            pesajePesoCabalRepositories.save(pesajePesoCabal);
                                            mensaje.setMensaje("Pesaje Almacenado con exito y Cuenta actualizada ");
                                            return mensaje;
                                        } else {
                                            mensaje.setMensaje("Se produjo un error al realizar la actualizacion de cuenta.");
                                            return mensaje;
                                        }
                                    } else {
                                        mensaje.setMensaje("No se pudo registrar el numero de pesaje");
                                        return mensaje;
                                    }
                                } else {
                                    mensaje.setMensaje("El Transportista no tiene permisos para ingreso de parcialidades en beneficio de café.");
                                    return mensaje;
                                }
                            } else {
                                System.out.println("*********"+estado_Transportista);
                                mensaje.setMensaje("No se encontro registro de la licencia de conducir ingresada.");
                                return mensaje;
                            }
                        } else {
                            System.out.println("Matricula no aceptada");
                            mensaje.setMensaje("La placa del Transporte no tiene permisos para ingreso al beneficio de café.");
                            return mensaje;
                        }
                    } else {
                        mensaje.setMensaje("No se encontro registro de la Matricula Ingresada");
                        return mensaje;
                    }
                } else {
                    mensaje.setMensaje("La cuenta no esta asociada al Usuario Agricultor Ingresado");
                    return mensaje;
                }
            } else {
                mensaje.setMensaje("El numero Id de cuenta ingresado no existe en los registros de Productores de café");
                return mensaje;
            }
            }
        }else{
                mensaje.setMensaje("No hay registros de la cuenta Ingresada");
            return mensaje;
            }
        }
    }
    
    public Boolean consultarCuenta(Integer id_cuenta) {  //Metodo para consultar datos sobre la cuenta ingresada por medio del parametro recibido id_cuenta
        Integer pid_cuenta = id_cuenta;
        String respuesta = pesajePesoCabalRepositories.consultarCuenta(pid_cuenta);
        if (respuesta != null && respuesta != "") {
            String[] parts = respuesta.split(",");
            this.id_cuenta = parts[0]; //numero de cuenta
            this.estado_cuenta = parts[1]; //estado de la cuenta
            this.usuario_agricultor = parts[2]; //Usuario del agricultor
            this.numero_pesajes_registrados = Integer.parseInt(parts[3]); //pesajes realizados
            this.numero_parcialidades = Integer.parseInt(parts[4]); //numero de parcialidades
            this.peso_total_de_envio = Integer.parseInt(parts[5]); //peso total enviado en qintales
            System.out.println("Mostrando variables: " + id_cuenta + " " + estado_cuenta + " " + usuario_agricultor + " " + numero_pesajes_registrados + " " + numero_parcialidades + " " + peso_total_de_envio);
            this.matriculas = pesajePesoCabalRepositories.consultarMatriculas(pid_cuenta);
            return true;
        } else {
            System.out.println("No existe");
            return false;
        }
    }
}
