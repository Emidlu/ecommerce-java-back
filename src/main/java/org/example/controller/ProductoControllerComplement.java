package org.example.controller;


import org.example.Respoitory.RepoProductos;
import org.example.Respoitory.RepoUsuarios;
import org.example.model.Producto;
import org.example.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin
@RepositoryRestController
public class ProductoControllerComplement {
    @Autowired
    private RepoProductos repoProductos;

    @Autowired
    private RepoUsuarios repoUsuarios;


    /*
    @GetMapping(path = "/productos/hola")
    public ResponseEntity<Object> getHola() {
        List<Producto> productos = repoProductos.findByCategoria_IdAndAndNombre(1, "madera");
        //return ResponseEntity.ok(categoria);

        //List <Producto> carrito = repoCarritos.findAll();
        System.out.println("hola");
        return ResponseEntity.ok(productos);
    }

     */



    @PostMapping(path = "/productos")
    public @ResponseBody String guardarProducto(@Valid @RequestBody Producto producto){

        Optional<Usuario> usuarioOptional = repoUsuarios.findById(producto.getUsuario().getId());
        if (!usuarioOptional.isPresent()){
            return "error";
        }

        producto.setUsuario(usuarioOptional.get());
        Producto productoGuardado = repoProductos.save(producto);


        return "agregado";


    }



}
