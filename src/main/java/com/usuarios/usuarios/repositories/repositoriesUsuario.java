
package com.usuarios.usuarios.repositories;

import com.usuarios.usuarios.models.usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface repositoriesUsuario extends CrudRepository<usuario,Integer>  {
    @Override
    public List<usuario> findAll();
}
