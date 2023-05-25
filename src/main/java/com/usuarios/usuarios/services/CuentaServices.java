/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.CuentaDto;
import com.usuarios.usuarios.Dto.mensajeDto;
import com.usuarios.usuarios.models.Cuenta;
import com.usuarios.usuarios.repositories.CuentaRepositories;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fasp9
 */
@Service
@Transactional
public class CuentaServices {
    
    @Autowired
    CuentaRepositories CuentaRepositories;
    
    public int getFiveDigitsNumber() {
    double fiveDigits = 10000 + Math.random() * 90000;
    return (int) fiveDigits;
}
    @Transactional
    public List<Cuenta> getAllCuenta() {
        return CuentaRepositories.findAll();
    }
    
     
    @Transactional
    public List<Cuenta> getAllCuentas(String a) {
        return this.CuentaRepositories.consulta(a);  
    }
    
    @Transactional
    public mensajeDto crearCuenta(CuentaDto dto) {
        mensajeDto mensaje = new mensajeDto();
        int valor = this.getFiveDigitsNumber();
        java.util.Date fecha = new Date();
        final Cuenta Cuenta = new Cuenta();
        Cuenta.setId_cuenta(valor);
        Cuenta.setFecha_creacion(fecha);
        Cuenta.setEstado_cuenta("Cuenta Creada");
        Cuenta.setPeso_total_de_envio(dto.getPeso_total_de_envio());
        Cuenta.setNumero_parcialidades(dto.getNumero_parcialidades());
        Cuenta.setMatriculas_autorizadas(dto.getMatriculas_autorizadas());
        Cuenta.setUsuario_agricultor(dto.getUsuario_agricultor());
        Cuenta.setNumero_pesajes_registrados(0);
        Cuenta.setParcialidades_generadas(0);
        CuentaRepositories.save(Cuenta);
        mensaje.setMensaje("Cuenta Creada Exitosamente, su numero de cuenta es: "+ valor);
        return  mensaje;
    }
    
     
    
}
