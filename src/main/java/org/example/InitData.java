package org.example;

import org.example.Respoitory.RepoProductos;
import org.example.Respoitory.RepoUsuarios;
import org.example.model.Producto;
import org.example.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

public class InitData implements CommandLineRunner {

    @Autowired
    RepositoryRestConfiguration config;


    @Override
    public void run(String... args) throws Exception {
        config.exposeIdsFor(Usuario.class);
        config.exposeIdsFor(Producto.class);


    }
}
