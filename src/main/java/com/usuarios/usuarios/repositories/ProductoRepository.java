/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.repositories;
import com.usuarios.usuarios.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 *
 * @author fasp9
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    Optional<Producto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
