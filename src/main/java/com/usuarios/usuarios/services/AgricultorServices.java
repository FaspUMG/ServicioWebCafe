/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.AgricultorDto;
import com.usuarios.usuarios.models.Agricultor;
import com.usuarios.usuarios.repositories.AgricultorRepositories;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;
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
    
    @Transactional
    public List<Agricultor> getAllAgricultor(){
        return AgricultorRepositories.findAll();
    }
    
    @Transactional
    public Agricultor crearAgricultor(AgricultorDto dto) throws Exception{
        String passEncriptada =  encriptar(dto.getContrasena());
        String pasDesencriptada = desencriptar(passEncriptada);
        java.util.Date fecha = new Date();
        final Agricultor Agricultor = new Agricultor();
        Agricultor.setNit(dto.getNit());
        Agricultor.setNombre_comercial(dto.getNombre_comercial());
        Agricultor.setContrasena(passEncriptada);
        Agricultor.setCorreo(dto.getCorreo());
        Agricultor.setEdad(dto.getEdad());
        Agricultor.setTelefono(dto.getTelefono());
        Agricultor.setDireccion(dto.getDireccion());
        Agricultor.setEstado("1020");
        Agricultor.setFecha_inscripcion(fecha);
        return AgricultorRepositories.save(Agricultor);
    }
    
    public static String encriptar(String texto) throws Exception {
        SecretKeySpec claveSecreta = new SecretKeySpec(clave.getBytes(), "AES");
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.ENCRYPT_MODE, claveSecreta);
        byte[] textoEncriptado = cifrador.doFinal(texto.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(textoEncriptado);
    }
     
     public static String desencriptar(String textoEncriptado) throws Exception {
        SecretKeySpec claveSecreta = new SecretKeySpec(clave.getBytes(), "AES");
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.DECRYPT_MODE, claveSecreta);
        byte[] textoDesencriptado = cifrador.doFinal(Base64.getDecoder().decode(textoEncriptado));
        return new String(textoDesencriptado, "UTF-8");
    }
}
