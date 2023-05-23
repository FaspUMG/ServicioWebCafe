/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.security.controller;
import com.usuarios.usuarios.Dto.Mensaje;
import com.usuarios.usuarios.security.dto.JwtDto;
import com.usuarios.usuarios.security.dto.LoginUsuario;
import com.usuarios.usuarios.security.dto.NuevoUsuario;
import com.usuarios.usuarios.security.models.Rol;
import com.usuarios.usuarios.security.models.Usuario;
import com.usuarios.usuarios.security.roles.RolNombre;
import com.usuarios.usuarios.security.jwt.JwtProvider;
import com.usuarios.usuarios.security.service.RolService;
import com.usuarios.usuarios.security.service.UsuarioService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author fasp9
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    java.util.Date fecha = new Date();
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Ingreso de correo invalido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Ya Existe un nombre de usuario con ese nombre"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("El email ingresado ya esta registrado."), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.getFecha_creacion(), nuevoUsuario.getNit(), nuevoUsuario.getDireccion(), nuevoUsuario.getTelefono());
        Set<Rol> roles = new HashSet<>();
        if(nuevoUsuario.getRoles().contains("Agricultor"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_AGRICULTOR).get());
        if(nuevoUsuario.getRoles().contains("PesoCabal"))
            roles.add(rolService.getByRolNombre(RolNombre.ROL_PESOCABAL).get());
        if(nuevoUsuario.getRoles().contains("Beneficio"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
