/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.util;

import com.usuarios.usuarios.security.models.Rol;
import com.usuarios.usuarios.security.roles.RolNombre;
import com.usuarios.usuarios.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author fasp9
 */
@Component
public class CreateRoles implements CommandLineRunner{
    
    @Autowired
    RolService rolService;
    
    @Override
    public void run(String... args) throws Exception {
        /*Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        Rol rolAgr.icultor = new Rol(RolNombre.ROLE_AGRICULTOR);
        Rol rolPesoCabal = new Rol(RolNombre.ROL_PESOCABAL);
        rolService.save(rolAdmin);
        rolServicesave(rolUser);
        rolService.save(rolAgricultor);
        rolService.save(rolPesoCabal); */ 
    }
}
