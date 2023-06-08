
package com.usuarios.usuarios.repositories;

import com.usuarios.usuarios.models.Transporte;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransporteRepositories extends CrudRepository<Transporte,Integer> {
    @Override
    public List<Transporte> findAll();
    
    //Area de Consultas a BD
    @Query(value = "select transporte.estado from transporte  where transporte.matricula= :pMatricula limit 1", nativeQuery = true)
    @Transactional 
    public String consultaTransporte(@Param("pMatricula") String pMatricula);
    
    //Area de Consultas a BD
    @Query(value = "select agricultor.estado from  agricultor where agricultor.nit= :pnit limit 1", nativeQuery = true)
    @Transactional 
    public String consultaNit(@Param("pnit") String pnit);
    
    //Area de Consultas a BD
    @Query(value = "select agricultor.estado from  agricultor where agricultor.contrasena = :pcontrasena limit 1", nativeQuery = true)
    @Transactional 
    public String consultaContrasena(@Param("pcontrasena") String pcontrasena);
    
    //Area de Consultas a BD
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update transporte  set estado=1028 where matricula= :pMatricula", nativeQuery = true)
    public int eliminaTransporte(@Param("pMatricula") String pMatricula);
    
    
    @Query(value = "select * from transporte where estado=1020 and usuario_creo=:pa  ", nativeQuery = true)
    @Transactional 
    public List<Transporte> consulta( @Param("pa")String a);
}
