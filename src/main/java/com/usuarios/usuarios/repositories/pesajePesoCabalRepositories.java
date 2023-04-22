
package com.usuarios.usuarios.repositories;

import com.usuarios.usuarios.Dto.CuentaDto;
import com.usuarios.usuarios.models.Cuenta;
import com.usuarios.usuarios.models.Transportista;
import com.usuarios.usuarios.models.pesajePesoCabal;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface pesajePesoCabalRepositories extends CrudRepository<pesajePesoCabal,Integer> {
    @Override
    public List<pesajePesoCabal> findAll();
   
    
    @Transactional
    @Query(value = "select id_cuenta,estado_cuenta,nit_agricultor,numero_pesajes_registrados,numero_parcialidades,peso_total_de_envio  from cuenta where id_cuenta= :pid_cuenta", nativeQuery = true)
    public String consultarCuenta(@Param("pid_cuenta") Integer pid_cuenta);
    
   
    @Transactional
    @Query(value = "select matriculas_autorizadas from cuenta where id_cuenta= :pid_cuenta", nativeQuery = true)
    public String consultarMatriculas(@Param("pid_cuenta") Integer pid_cuenta);
    
    @Transactional
    @Query(value = "select estado from transporte where matricula= :matricula_evaluada", nativeQuery = true)
    public Integer consultarestadoMatricula(@Param("matricula_evaluada") String matricula_evaluada);
    
    @Transactional
    @Query(value = "select estado from transportista where numero_licencia= :licencia", nativeQuery = true)
    public int consultarEstadoTransportista(@Param("licencia") String licencia);
    
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update cuenta set estado_cuenta= 'Pesaje Iniciado',numero_pesajes_registrados=numero_pesajes_registrados+1 where id_cuenta=:pid_cuenta", nativeQuery = true)
    public int actualizaPrimerPeso(@Param("pid_cuenta") Integer pid_cuenta);
    
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update cuenta set numero_pesajes_registrados=numero_pesajes_registrados+1 where id_cuenta=:pid_cuenta", nativeQuery = true)
    public int actualizaNumeroParcialidades(@Param("pid_cuenta") Integer pid_cuenta);
    
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update cuenta set  estado_cuenta= 'Pesaje Finalizado',numero_pesajes_registrados=numero_pesajes_registrados+1 where id_cuenta=:pid_cuenta", nativeQuery = true)
    public int actualizaUltimoPesaje(@Param("pid_cuenta") Integer pid_cuenta);
    
}
