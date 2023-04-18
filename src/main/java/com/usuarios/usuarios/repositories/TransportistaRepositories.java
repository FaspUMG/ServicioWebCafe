
package com.usuarios.usuarios.repositories;

import com.usuarios.usuarios.models.Transportista;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TransportistaRepositories extends CrudRepository<Transportista,Integer>{
    @Override
    public List<Transportista> findAll();
    
    //Area de Consultas a BD
    @Query(value = "select transportista.estado from transportista  where transportista.numero_licencia= :pLicencia limit 1", nativeQuery = true)
    @Transactional 
    public String consultaTransportista(@Param("pLicencia") String pLicencia);
    
    //Consulta por nit del agricultor
    @Query(value = "select usuario.estado from  usuario where usuario.nit= :pnit limit 1", nativeQuery = true)
    @Transactional 
    public String consultaNit(@Param("pnit") String pnit);
    
    //Consulta Contraseña del agricultor
    @Query(value = "select usuario.estado from  usuario where usuario.contrasena = :pcontrasena limit 1", nativeQuery = true)
    @Transactional 
    public String consultaContrasena(@Param("pcontrasena") String pcontrasena);
    
    //Area de Consultas a BD
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update transportista  set estado=1030 where numero_licencia= :plicencia", nativeQuery = true)
    public int eliminarTransportista(@Param("plicencia") String plicencia);


}
