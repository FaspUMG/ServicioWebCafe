/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.PesajesDto;
import com.usuarios.usuarios.Dto.mensajeDto;
import com.usuarios.usuarios.modelsPesaje.Pesajes;
import com.usuarios.usuarios.repositoriesPesaje.RepoPesajes;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fasp9
 */
@Service
@Transactional
public class PesajeServices {
    @Autowired
    RepoPesajes RepoPesajes;
    
    
    @Transactional
    public mensajeDto crearCuenta(PesajesDto dto) {
        mensajeDto mensaje = new mensajeDto();
        final Pesajes Cuenta = new Pesajes();
        Cuenta.setId_cuenta(dto.getId_cuenta());
        Cuenta.setId_peso(dto.getId_peso());
        RepoPesajes.save(Cuenta);
        mensaje.setMensaje("Pesaje Almacenado ");
        return  mensaje;
    }
    
}
