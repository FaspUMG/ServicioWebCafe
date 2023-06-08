
package com.usuarios.usuarios.services;

import com.usuarios.usuarios.Dto.TransporteDto;
import com.usuarios.usuarios.Dto.mensajeDto;
import com.usuarios.usuarios.models.Transporte;
import com.usuarios.usuarios.repositories.TransporteRepositories;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransporteServices {

     private static final String clave = "MiClaveSecreta12"; // Clave secreta para encriptar
    @Autowired
    TransporteRepositories TransporteRepositories;
    
    @Transactional
    public List<Transporte> getAllTransporte() {
        return TransporteRepositories.findAll();
    }
    
    
    @Transactional
    public List<Transporte> getAllTransporte(String a) {
        return this.TransporteRepositories.consulta(a);  
    }

    @Transactional
    public mensajeDto InscribirTransporte(TransporteDto dto) throws Exception {
        java.util.Date fecha = new Date();
        mensajeDto mensaje = new mensajeDto();
        final Transporte Transporte = new Transporte();
        Transporte.setMatricula(dto.getMatricula());
        Transporte.setModelo(dto.getModelo());
        Transporte.setNumero_ejes(dto.getNumero_ejes());
        Transporte.setMarca(dto.getMarca());
        //Transporte.setPeso_de_camion(dto.getPeso_de_camion());
        Transporte.setUsuario_creo(dto.getUsuario_creo());
        Transporte.setDisponibilidad(true);
        //Transporte.setNit(dto.getNit());
        //Transporte.setPeso_de_mercaderia(dto.getPeso_de_mercaderia());
        Transporte.setFecha_inscripcion(fecha);
        Transporte.setColor(dto.getColor());
        Transporte.setEstado(1020);
            if (dto.getModelo() >= 1960) {
                TransporteRepositories.save(Transporte);
                mensaje.setMensaje("Transporte Inscrito Correctamente en el beneficio");
                return mensaje;
            } else {
                mensaje.setMensaje("El Transporte debe ser modelo 1960 o mas reciente");
                return mensaje;
            } 
    }

    public mensajeDto consultarTransporte(TransporteDto dto) throws Exception {
        String pMatricula = dto.getMatricula();
        mensajeDto mensaje = new mensajeDto();
        String matricula = this.TransporteRepositories.consultaTransporte(pMatricula);
        if (matricula == null || matricula.equals("")) {
            mensaje.setMensaje("No se Obtuvieron datos del Transporte ingresado");
            return mensaje;
        } else {
            switch(matricula){
                case "1028":
                    mensaje.setMensaje("El vehiculo con las placas: "+pMatricula+" se encuentra Inactivo");
                    return mensaje;
                    
                case "1020":
                    mensaje.setMensaje("El vehiculo con las placas: "+pMatricula+" se encuentra Activo");
                    return mensaje;
                    
                case "1030":
                    mensaje.setMensaje("El vehiculo con las placas: "+pMatricula+" se encuentra Eliminado");
                    return mensaje;
                    
                default :
                    mensaje.setMensaje("No se obtuvo el estado del vehiculo con las placas: "+pMatricula);
                      return  mensaje;
            }
        }  
    }
    
    

    public boolean consultaDatos(String a, String b) {
        String pnit = a;
        String pcontrasena = b;
        String nit = this.TransporteRepositories.consultaNit(pnit);
        String contrasena = this.TransporteRepositories.consultaContrasena(pcontrasena);
        if (nit !=null && nit!="" && contrasena!=null && contrasena!="") {
            System.out.println("Los datos del agricultor son validos");
            System.out.println("Este es el nit que trajo: "+nit);
            System.out.println("Este es contraseña y trajo: "+contrasena);
            return true;
        } else {
            System.out.println("Los datos del agricultor son invalidos");
            System.out.println("Este es el nit que trajo: "+nit);
            System.out.println("Este es contraseña y trajo: "+contrasena);
            return false;
        }
    }
    
    //Metodo para eliminar Transporte activo o inactivo por medio del numero de matriculas.
    public mensajeDto eliminarTransporte(TransporteDto dto) throws Exception { 
        
        String pMatricula = dto.getMatricula(); 
        mensajeDto mensaje = new mensajeDto();
            int matricula = this.TransporteRepositories.eliminaTransporte(pMatricula);
            if (matricula > 0) {
                mensaje.setMensaje("El transporte fue inactivado con exito");
                return mensaje;
            } else {
                mensaje.setMensaje("Ocurrio un error, Verifique No. de Matricula Ingresada");
                return mensaje;
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
