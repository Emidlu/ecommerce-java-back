package org.example.controller;


import org.example.DTO.Usuario.DTOUsuarioLoginRequest;
import org.example.DTO.Usuario.DTOUsuarioLoginResponse;
import org.example.Respoitory.RepoUsuarios;
import org.example.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RepositoryRestController
public class UsuarioControllerComplement {

    @Autowired
    private RepoUsuarios repoUsuarios;




    @PostMapping(path = {"/usuarios/login"})
    public ResponseEntity<Object> loginUsuario(@RequestBody DTOUsuarioLoginRequest dtoUsuarioLoginRequest){
        Usuario usuario = repoUsuarios.findByEmail(dtoUsuarioLoginRequest.getEmail());
        if(usuario == null){
            return new ResponseEntity<>("Email invalido", HttpStatus.BAD_REQUEST);
        }else if(!usuario.getPassword().equals(dtoUsuarioLoginRequest.getPassword())){
            return new ResponseEntity<>("Password invalida", HttpStatus.BAD_REQUEST);
        }else {
            DTOUsuarioLoginResponse dtoUsuarioLoginResponse = new DTOUsuarioLoginResponse();
            dtoUsuarioLoginResponse.setId(usuario.getId());
            dtoUsuarioLoginResponse.setNombre(usuario.getNombre());
            dtoUsuarioLoginResponse.setEmail(usuario.getEmail());
            return ResponseEntity.ok(dtoUsuarioLoginResponse);
        }
    }


    @DeleteMapping(path = {"/usuarios/{user_id}"})
    public ResponseEntity<String> deleteUsuario(@PathVariable(name = "user_id") Integer userId) {

        Optional<Usuario> usuarioOptional = repoUsuarios.findById(userId);
        if (!usuarioOptional.isPresent()) {
            return new ResponseEntity<>("Este usuario no existe", HttpStatus.BAD_REQUEST);
        }


        usuarioOptional.get().setDeleted(true);
        Usuario usuarioCambiado = repoUsuarios.save(usuarioOptional.get());
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);


    }



}


