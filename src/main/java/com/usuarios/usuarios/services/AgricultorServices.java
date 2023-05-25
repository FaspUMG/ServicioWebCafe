/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.AgricultorDto;
import com.usuarios.usuarios.models.Agricultor;
import com.usuarios.usuarios.models.Cuenta;
import com.usuarios.usuarios.repositories.AgricultorRepositories;
import com.usuarios.usuarios.repositories.CuentaRepositories;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;
import static jdk.nashorn.internal.objects.Global.undefined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fasp9
 */
@Service
@Transactional
public class AgricultorServices {
    private static final String clave = "MiClaveSecreta12"; // Clave secreta para encriptar
    
    @Autowired
    AgricultorRepositories AgricultorRepositories;
    
    @Autowired
    CuentaRepositories CuentaRepositories;
    
    private String id_cuenta;
    private String estado_cuenta;
    private String usuario_agricultor;
    private int numero_pesajes_registrados;
    private int numero_parcialidades;
    private int peso_total_de_envio;
    private String matriculas_autorizadas;
    private Integer parcialidadesCuenta;
    private Integer generadas;
    
    @Transactional
    public String registrarParcialidad(AgricultorDto dto) throws Exception {
        java.util.Date fecha = new Date();
        final Agricultor Agricultor = new Agricultor();
        Agricultor.setCuenta(dto.getCuenta());
        Agricultor.setUsuario(dto.getUsuario());
        Agricultor.setMatricula(dto.getMatricula());
        Agricultor.setNumero_licencia(dto.getNumero_licencia());
        Agricultor.setPeso_de_envio(dto.getPeso_de_envio());
        Agricultor.setFecha_creacion(fecha);
        String placa = dto.getMatricula();
        String placa_encontrada = "";
        
        
        
        Integer parcialidades = AgricultorRepositories.consultarPar(dto.getCuenta());
        if (parcialidades != null) {
            this.parcialidadesCuenta = parcialidades;
        } else {
            return "Operacion fallida, verifique numero de parcialidades.";
        }
        
        Integer gen = AgricultorRepositories.consultarGen(dto.getCuenta());
        if (gen != null) {
            this.generadas = gen;
        } else {
            return "Operacion fallida, verifique parcialidades generdas.";
        }
        //Inician validaciones para la parcialidad.
        if (this.consultarCuenta(dto.getCuenta())) {
            if(estado_cuenta!="Pesaje Finalizado"){
            if(this.generadas < this.parcialidadesCuenta){
            if (this.usuario_agricultor.equals(dto.getUsuario())) {
                if (this.matriculas(dto.getCuenta())) { //llamando a metodo y validando matriculas
                    String[] placas = this.matriculas_autorizadas.split(",");
                    for (int i = 0; i < placas.length; i++) {
                        if (placa.equals(placas[i])) {
                            System.out.println("Mostrando la placa enviada para pesaje: " + placas[i]);
                            placa_encontrada = placas[i];
                        } else {
                            System.out.println("La no hay registro de la placa ingresada");
                            //Se validad que la placa ingresada no esta registrada.
                        }
                    }
                    if (placa_encontrada == null || placa_encontrada == "") {
                        return "Placa no tiene registro";
                    } else {
                        Integer estado_matricula = AgricultorRepositories.consultarestadoMatricula(placa_encontrada);
                        if (estado_matricula != null) {
                            if (estado_matricula == 1020) {
                                System.out.println("Matricula inscrita y Activa");
                                //return "matricula activa";
                                String asignacion = AgricultorRepositories.consultarestausuario(placa_encontrada);
                                if (asignacion != null) {
                                    if (asignacion.equals(dto.getUsuario())) {
                                        System.out.println("Matricula pertenece al usuario");
                                        String disponibilidad = AgricultorRepositories.consultardisponibilidad(placa_encontrada);
                                        if (disponibilidad != null) {
                                            System.out.println("disponibilidad****************" + disponibilidad);
                                            if (disponibilidad == "true") {
                                                //return "Proceda con la asignacion de vehiculo";
                                                Integer estado_li = AgricultorRepositories.consultarli(dto.getNumero_licencia());
                                                if (estado_li != null) {
                                                    if (estado_li == 1020) {
                                                        System.out.println("Matricula inscrita y Activa");
                                                        //return "matricula activa";
                                                        String liUser = AgricultorRepositories.consultarLiUser(dto.getNumero_licencia());
                                                        if (liUser != null) {
                                                            if (liUser.equals(dto.getUsuario())) {
                                                                System.out.println("Transportista pertenece al usuario");
                                                                String liDis = AgricultorRepositories.consultarLiDis(dto.getNumero_licencia());
                                                                if (liDis != null) {
                                                                    System.out.println("disponibilidad Licencia****************" + liDis);
                                                                    if (liDis == "true") {
                                                                        Integer registroPar = AgricultorRepositories.actualizaPar(dto.getCuenta());
                                                                        if (registroPar > 0) {
                                                                            AgricultorRepositories.save(Agricultor);
                                                                            return "Parcialidad Registrada con exito";
                                                                        } else {
                                                                            return "Se produjo un error al realizar la actualizacion de cuenta.";
                                                                        }  
                                                                    } else {
                                                                        return "El Transportista esta asignada a otro envío";
                                                                    }
                                                                } else {
                                                                    return "No se puede asignar este vehiculo, no se obtuvo la disponibilidad.";
                                                                }
                                                            } else {
                                                                return "Transportista no pertenece al Agricultor";
                                                            }
                                                        } else {
                                                            return "No puede asignarse este Transportista, no se obtuvieron datos.";
                                                        }
                                                    } else {
                                                        return "El transportista no puede asignarse por estar inactivo.";
                                                    }
                                                } else {
                                                    return "No se puede asignar este al Transportista, no se obtuvieron datos.";
                                                }
                                            } else {
                                                return "La matricula esta asignada a otro envío";
                                            }
                                        } else {
                                            return "No se puede asignar este vehiculo, no se obtuvo disponibilidad.";
                                        }
                                    } else {
                                        return "La matricula no pertenece al usuario";
                                    }
                                } else {
                                    return "No se puede asignar este vehiculo, no se obtuvieron datos.";
                                }
                            } else {
                                return "El transporte no puede asignarse por estar inactivo.";
                            }
                        } else {
                            return "No se puede asignar este vehiculo, no se obtuvieron datos.";
                        }
                    }
                } else {
                    return "No se obtuvieron datos de las placas ingresadas";  //Se verifican que no hay registro de matriculas en la cuenta.
                }
            } else {
                return "El usuario no tiene asignado esta cuenta.";  //Se verifica que el usuario de la cuenta ingresada no es el correcto
            }}else{
                return "No se permite el ingreso de mas parcialidades para esta cuenta";
            }}else{
                return "La cuenta ya no permite mas registro de parcialidades";
            }
        } else {
            return "No se obtuvieron datos de la cuenta";  //Si la cuenta no existe
        }
    }
    
    
    public boolean consultarCuenta(Integer id_cuenta) {
        String respuesta = AgricultorRepositories.consultarCuenta(id_cuenta);
        String matriculas = AgricultorRepositories.consultarMatriculas(id_cuenta);
        if (respuesta != null && respuesta != "") {
            String[] parts = respuesta.split(",");
            this.id_cuenta = parts[0]; //numero de cuenta
            this.estado_cuenta = parts[1]; //estado de la cuenta
            this.usuario_agricultor = parts[2]; //Usuario del agricultor
            this.numero_pesajes_registrados = Integer.parseInt(parts[3]); //pesajes realizados
            this.numero_parcialidades = Integer.parseInt(parts[4]); //numero de parcialidades
            this.peso_total_de_envio = Integer.parseInt(parts[5]); //peso total enviado en qintales
            System.out.println("Mostrando variables: " + id_cuenta + " " + estado_cuenta + " " + usuario_agricultor + " " + numero_pesajes_registrados + " " + numero_parcialidades + " " + peso_total_de_envio);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean matriculas(Integer id){
        String matriculas = AgricultorRepositories.consultarMatriculas(id);
        if (matriculas != null && matriculas != "") {
         this.matriculas_autorizadas = matriculas;
            return true;
        } else {
            return false;
        }
    }
    
    
}
