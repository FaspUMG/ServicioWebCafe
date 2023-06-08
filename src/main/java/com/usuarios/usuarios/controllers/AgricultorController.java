/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.controllers;

import com.usuarios.usuarios.Dto.AgricultorDto;
import com.usuarios.usuarios.Dto.PesajesDto;
import com.usuarios.usuarios.Dto.mensajeDto;
import com.usuarios.usuarios.models.Agricultor;
import com.usuarios.usuarios.services.AgricultorServices;
import com.usuarios.usuarios.services.PesajeServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fasp9
 */
@RestController
public class AgricultorController {
    @Autowired
    AgricultorServices AgricultorServices;
    
    @Autowired
    PesajeServices PesajeServices;
    
    //metodo para crear un usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="Agricultor/RegistrarParcialidad")
    public mensajeDto crearAgricultor(@RequestBody AgricultorDto dto) throws Exception{
        System.out.println("mostrando controlador"+ dto.getMatricula());
        return AgricultorServices.registrarParcialidad(dto);
    }
    
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="Pesajes/Almacenar")
    public mensajeDto crearCuenta(@RequestBody PesajesDto dto) throws Exception{
        return PesajeServices.crearCuenta(dto);
    }
               
}
