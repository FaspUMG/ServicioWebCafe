
package com.usuarios.usuarios.repositories;

import com.usuarios.usuarios.Dto.CuentaDto;
import com.usuarios.usuarios.models.Cuenta;
import com.usuarios.usuarios.models.Transportista;
import com.usuarios.usuarios.models.pesajePesoCabal;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface pesajePesoCabalRepositories extends CrudRepository<pesajePesoCabal,Integer> {
    @Override
    public List<pesajePesoCabal> findAll();
   
    
    @Transactional
    @Query(value = "select id_cuenta,estado_cuenta,nit_agricultor,numero_pesajes_registrados,numero_parcialidades,peso_total_de_envio  from cuenta where id_cuenta= :pid_cuenta", nativeQuery = true)
    //public CuentaDto  consultarCuenta(@Param("pid_cuenta") Integer pid_cuenta);
    public String consultarCuenta(@Param("pid_cuenta") Integer pid_cuenta);
    //public String  consultarCuenta(@Param("pid_cuenta") Integer pid_cuenta);
   
}
