/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.security.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author fasp9
 */
public class UsuarioPrincipal implements UserDetails {
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private String fecha_creacion;
    private String nit;
    private String direccion;
    private String telefono;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password, String fecha_creacion, String nit, String direccion, String telefono,  Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.fecha_creacion = fecha_creacion;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.authorities = authorities;
        
    }

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
        usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), usuario.getFecha_creacion(), usuario.getNit(), usuario.getDireccion(), usuario.getTelefono(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

}
