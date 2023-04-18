package com.usuarios.usuarios.controllers;

import com.usuarios.usuarios.Dto.TransportistaDto;
import com.usuarios.usuarios.models.Transportista;
import com.usuarios.usuarios.services.TransportistaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransportistaController {
    @Autowired
    TransportistaServices TransportistaServices;
    
    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="Transportista/EncuentraTransportista")
    public List<Transportista> getAllTransportista (){
        return TransportistaServices.getAllTransportista();
    }
    
    //metodo para crear un usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="Transportista/InscribirTransportista")
    public String InscribirTransportista(
            @RequestBody TransportistaDto dto,
            @RequestParam(required=false)String nit,
            @RequestParam(required=false)String contrasena
    ) throws Exception{
        return TransportistaServices.InscribirTransportista(dto, nit, contrasena);
    }
    
    //metodo para crear un usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="Transportista/consultaTransportista")
    public String consultaTransportista(
            @RequestBody TransportistaDto dto,
            @RequestParam(required=false)String nit,
            @RequestParam(required=false)String contrasena
    )throws Exception{
        return TransportistaServices.consultaTransportista(dto, nit, contrasena);
    }
    
    //metodo para crear un usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="Transportista/eliminarTransportista")
    public String eliminarTransportista(
            @RequestBody TransportistaDto dto,
            @RequestParam(required=false)String nit,
            @RequestParam(required=false)String contrasena
    )throws Exception{
        return TransportistaServices.eliminarTransportista(dto, nit, contrasena);
    }
    
}
