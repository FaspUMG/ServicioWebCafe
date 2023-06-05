/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.repositories;

import com.usuarios.usuarios.models.Agricultor;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author fasp9
 */
public interface AgricultorRepositories extends CrudRepository<Agricultor,Integer> {
    
    @Transactional
    @Query(value = "select id_cuenta , estado_cuenta, usuario_agricultor, numero_pesajes_registrados, numero_parcialidades, peso_total_de_envio from cuenta where id_cuenta=:pid_cuenta", nativeQuery = true)
    public String consultarCuenta(@Param("pid_cuenta") Integer pid_cuenta);
    
    @Transactional
    @Query(value = "select  matriculas_autorizadas from cuenta where id_cuenta= :pid_cuenta", nativeQuery = true)
    public String consultarMatriculas(@Param("pid_cuenta") Integer pid_cuenta);
    
    @Transactional
    @Query(value = "select estado from transporte where matricula=:pa", nativeQuery = true)
    public Integer consultarestadoMatricula(@Param("pa") String a);
    
    @Transactional
    @Query(value = "select usuario_creo from transporte where matricula=:pa", nativeQuery = true)
    public String consultarestausuario(@Param("pa") String a);
    
    @Transactional
    @Query(value = "select disponibilidad from transporte where matricula=:pa", nativeQuery = true)
    public String consultardisponibilidad(@Param("pa") String a);
    
    @Transactional
    @Query(value = "select estado from transportista where numero_licencia=:pa", nativeQuery = true)
    public Integer consultarli(@Param("pa") String a);
    
    @Transactional
    @Query(value = "select usuario_creo from transportista where numero_licencia=:pa", nativeQuery = true)
    public String consultarLiUser(@Param("pa") String a);
    
    @Transactional
    @Query(value = "select disponibilidad from transportista where numero_licencia=:pa", nativeQuery = true)
    public String consultarLiDis(@Param("pa") String a);
    
    @Transactional
    @Query(value = "select numero_parcialidades from cuenta where id_cuenta=:pa", nativeQuery = true)
    public Integer consultarPar(@Param("pa") Integer a);
    
    @Transactional
    @Query(value = "select parcialidades_generadas from cuenta where id_cuenta=:pa", nativeQuery = true)
    public Integer consultarGen(@Param("pa") Integer a);
    
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update cuenta set parcialidades_generadas=parcialidades_generadas+1 where id_cuenta=:pid_cuenta", nativeQuery = true)
    public int actualizaPar(@Param("pid_cuenta") Integer pid_cuenta);
    
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update transporte set  disponibilidad=false where matricula=:plic", nativeQuery = true)
    public int actualizaDisTransporte(@Param("plic") String lic);
    
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update transportista set  disponibilidad=false where numero_licencia=:plic", nativeQuery = true)
    public int actualizaDisLic(@Param("plic") String lic);
    
}
