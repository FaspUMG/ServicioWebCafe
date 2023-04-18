/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.TransportistaDto;
import com.usuarios.usuarios.models.Transportista;
import java.util.List;
import javax.transaction.Transactional;
import com.usuarios.usuarios.repositories.TransportistaRepositories;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author fasp9
 */
@Service
@Transactional
public class TransportistaServices {
    private static final String clave = "MiClaveSecreta12"; // Clave secreta para encriptar
   
     @Autowired
    TransportistaRepositories TransportistaRepositories;
    
    @Transactional
    public List<Transportista> getAllTransportista(){
        return TransportistaRepositories.findAll();
    }
    
    @Transactional
   public String InscribirTransportista (TransportistaDto dto, String nit, String contrasena) throws Exception{
        String a = nit;
        String b = this.encriptar(contrasena);
        String c = this.desencriptar(b);
        java.util.Date fecha = new Date();
       String passEncriptado = encriptar(contrasena);
       final Transportista Transportista = new Transportista ();
       Transportista.setNumero_licencia(dto.getNumero_licencia());
       Transportista.setNombres(dto.getNombres());
       Transportista.setApellidos(dto.getApellidos());
       Transportista.setTipo_licencia(dto.getTipo_licencia());
       Transportista.setFecha_inscripcion(fecha);
       Transportista.setEstado(1020);
       if (this.consultaDatos(a,b)) {
       if(dto.getTipo_licencia().equals("A")){
         TransportistaRepositories.save(Transportista);
         return "El Transportista fue Inscrito Correctamente en el Beneficio";
       }else{
        return "El Transportista debe tener licencia tipo A";
       }
       }else {
            return "Estimado Agricultor, sus credenciales no son correctas.   Acceso no autorizado";
        }
   }
   
   //Metodo que consulta el estado del estado del transportista en el beneficio.
   public String consultaTransportista(TransportistaDto dto, String nit, String contrasena) throws Exception{
        String a = nit;
        String b = this.encriptar(contrasena);
        String c = this.desencriptar(b);
        String pLicencia = dto.getNumero_licencia();
        String numeroLicencia = this.TransportistaRepositories.consultaTransportista(pLicencia);
        if (this.consultaDatos(a,b)) {
       if(numeroLicencia==null || numeroLicencia.equals("")){
       return "No se obtuvieron los datos del Transportista Ingresado";
       }else{
           System.out.println("Los datos son 555555555555555555555555555555555555555555555"+numeroLicencia);
       switch(numeroLicencia){
           
                case "1028":
                    return "El Transportista con el numero de Licencia: "+pLicencia+" se encuentra Inactivo";
                    
                case "1020":
                    return "El Transportista con el numero de Licencia: "+pLicencia+" se encuentra Activo";
                    
                case "1030":
                    return "El Transportista con el numero de Licencia: "+pLicencia+" se encuentra Eliminado";
                    
                default :
                      return  "No se obtuvo el estado del Transportista con el numero de Licencia: "+pLicencia;
            }
       }
        }else {
            return "Estimado Agricultor, sus credenciales no son correctas.   Acceso no autorizado";
        }
   }
   
   //Metodo para eliminar Transporte activo o inactivo.
    public String eliminarTransportista(TransportistaDto dto, String nit, String contrasena) throws Exception {
        String a = nit;
        String b = this.encriptar(contrasena);
        String plicencia = dto.getNumero_licencia();
        if (this.consultaDatos(a, b)) {
            int licencia = this.TransportistaRepositories.eliminarTransportista(plicencia);
            if (licencia > 0) {
                return "El transporte con las placas: "+ plicencia + " fue eliminado con exito";
            } else {
                return "Error al eliminar el transporte con las placas: "+ plicencia;
            }
        } else {
            return "Estimado Agricultor, sus credenciales no son correctas.   Acceso no autorizado";
        }
    }
    
   public boolean consultaDatos(String a, String b) {
        String pnit = a;
        String pcontrasena = b;
        String nit = this.TransportistaRepositories.consultaNit(pnit);
        String contrasena = this.TransportistaRepositories.consultaContrasena(pcontrasena);
        if (nit !=null && nit!="" && contrasena!=null && contrasena!="") {
            System.out.println("Los datos del agricultor son validos");
            return true;
        } else {
            return false;
        }
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
