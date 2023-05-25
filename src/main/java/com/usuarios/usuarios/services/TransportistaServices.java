/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.TransportistaDto;
import com.usuarios.usuarios.Dto.mensajeDto;
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
    java.util.Date fecha = new Date();
   
     @Autowired
    TransportistaRepositories TransportistaRepositories;
    
    @Transactional
    public List<Transportista> getAllTransportista(){
        return TransportistaRepositories.findAll();
    }
    
    @Transactional
    public List<Transportista> getAllTransportista(String a) {
        return this.TransportistaRepositories.consulta(a);  
    }
    
    @Transactional
   public mensajeDto InscribirTransportista (TransportistaDto dto) throws Exception{       
        
       final Transportista Transportista = new Transportista ();
       mensajeDto mensaje = new mensajeDto();
       Transportista.setNumero_licencia(dto.getNumero_licencia());
       Transportista.setNombres(dto.getNombres());
       Transportista.setApellidos(dto.getApellidos());
       Transportista.setTipo_licencia(dto.getTipo_licencia());
       Transportista.setFecha_inscripcion(this.fecha);
       Transportista.setUsuario_creo(dto.getUsuario_creo());
       Transportista.setEstado(1020);
       Transportista.setDisponibilidad(true);
       if(dto.getTipo_licencia().equals("A")){
           System.out.println("Mostrando el ingreso del usuario_creo: "+dto.getUsuario_creo() );
         TransportistaRepositories.save(Transportista);
         mensaje.setMensaje("El Transportista fue Inscrito Correctamente en el Beneficio");
         return mensaje;
           
       }else{
           mensaje.setMensaje( "El Transportista debe tener licencia tipo A");
        return mensaje;
       } 
   }
   
   //Metodo que consulta el estado del estado del transportista en el beneficio.
   public String consultaTransportista(TransportistaDto dto) throws Exception{
       
        String pLicencia = dto.getNumero_licencia();
        mensajeDto mensaje = new mensajeDto();
        String numeroLicencia = this.TransportistaRepositories.consultaTransportista(pLicencia);
        
       if(numeroLicencia==null || numeroLicencia.equals("")){
           //mensaje.setMensaje("No se obtuvieron los datos del Transportista Ingresado");
       return "No se obtuvieron los datos del Transportista Ingresado";
       }else{
           System.out.println("Los datos son 555555555555555555555555555555555555555555555"+numeroLicencia);
       switch(numeroLicencia){
           
                case "1028":
                   // mensaje.setMensaje("El Transportista con el numero de Licencia: "+pLicencia+" se encuentra Inactivo");
                    return "El Transportista con el numero de Licencia: "+pLicencia+" se encuentra Inactivo";
                    
                case "1020":
                   // mensaje.setMensaje("El Transportista con el numero de Licencia: "+pLicencia+" se encuentra Activo");
                    return "El Transportista con el numero de Licencia: "+pLicencia+" se encuentra Activo";
                    
                case "1030":
                   
                    return "El Transportista con el numero de Licencia: "+pLicencia+" se encuentra Eliminado";
                    
                default :
               
                      return  "No se obtuvo el estado del Transportista con el numero de Licencia: "+pLicencia;
            }
       }
        
   }
   
   //Metodo para eliminar Transporte activo o inactivo.
    public String eliminarTransportista(TransportistaDto dto) throws Exception {
        Date pfecham = this.fecha;
        String plicencia = dto.getNumero_licencia();  
            int licencia = this.TransportistaRepositories.eliminarTransportista(plicencia, pfecham);
            if (licencia > 0) {
                return "El transporte con las placas: "+ plicencia + " fue eliminado con exito";
            } else {
                return "Error al eliminar el transporte con las placas: "+ plicencia;
            }
    }
    
   /*public boolean consultaDatos(String a, String b) {
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
    }*/
     
}
