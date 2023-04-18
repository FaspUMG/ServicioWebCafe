
package com.usuarios.usuarios.controllers;

import com.usuarios.usuarios.Dto.pesajePesoCabalDto;
import com.usuarios.usuarios.models.Transportista;
import com.usuarios.usuarios.models.pesajePesoCabal;
import com.usuarios.usuarios.services.TransportistaServices;
import com.usuarios.usuarios.services.pesajePesoCabalServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pesajePesoCabalController {
    @Autowired
    pesajePesoCabalServices pesajePesoCabalServices;
    
    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="pesajePesoCabal/findAllPesajes")
    public List<pesajePesoCabal> getAllPesajes (){
        return pesajePesoCabalServices.getAllPesajes();
    }
    
    //metodo para crear un usuario
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="pesajePesoCabal/createPesaje")
    public String createPesaje(@RequestBody pesajePesoCabalDto dto){
        return pesajePesoCabalServices.createPesaje(dto);
    }
}
