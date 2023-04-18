
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.ConsultaCuenta;
import com.usuarios.usuarios.Dto.CuentaDto;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class pesajePesoCabalServices { 
    
    @Autowired
    pesajePesoCabalRepositories pesajePesoCabalRepositories;
    
    
    @Transactional
    public List<pesajePesoCabal> getAllPesajes(){
        return pesajePesoCabalRepositories.findAll();
    }
    
    @Transactional
    public String createPesaje(pesajePesoCabalDto dto) {
        final pesajePesoCabal pesajePesoCabal = new pesajePesoCabal();
        
        Integer cuenta=dto.getId_cuenta();
        pesajePesoCabal.setId_peso(dto.getId_peso());
        pesajePesoCabal.setId_cuenta(dto.getId_cuenta());
        pesajePesoCabal.setMatricula(dto.getMatricula());
        pesajePesoCabal.setNumero_licencia(dto.getNumero_licencia());
        pesajePesoCabal.setPeso_marcado(dto.getPeso_marcado());
        pesajePesoCabal.setPeso_de_camion(dto.getPeso_de_camion());
        pesajePesoCabal.setPeso_cargamento((dto.getPeso_marcado()) - (dto.getPeso_de_camion()));

        if (dto.getPeso_marcado() < dto.getPeso_de_camion()) {
            return "El pesaje marcado no puede ser menor al peso del camion.";
        } else {
            this.consultarCuenta(cuenta);
            
            //pesajePesoCabalRepositories.save(pesajePesoCabal);
            return "El pesaje Fue registrado con exito.";
        }
    }
    
    public String consultarCuenta(Integer id_cuenta){
    Integer pid_cuenta = id_cuenta;
    String respuesta = pesajePesoCabalRepositories.consultarCuenta(pid_cuenta);
     //Cuenta respuestas = new Cuenta();
       //CuentaDto respuestas = pesajePesoCabalRepositories.consultarCuenta(pid_cuenta);
       //ArrayList<Cuenta> respuestas = pesajePesoCabalRepositories.consultarCuenta(pid_cuenta);
        //System.out.println("Imprimiento metodo:   "+ pesajePesoCabalRepositories.consultarCuenta(pid_cuenta));
        //System.out.println("Estos son los datos de la cuenta: ");
        //System.out.println("verificando idCuenta: ");
        String[] parts = respuesta.split(","); 
        String part1 = parts[0]; // 123 String part2 = parts[1]; // 654321
        String part2 = parts[1];
        String part3 = parts[2];
     //   Map<String, Object> params = new HashMap<>();
        System.out.println("Mostrando variables: "+part1+" "+part2+" "+part3);
       // List<ConsultaCuenta> resultado = finder.findByNamedQueryParam("cuenta", params, ConsultaCuenta.class);
        
        
    return "Mostrando resultado";
    }
    
    
    
}
