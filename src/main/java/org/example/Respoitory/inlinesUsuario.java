package org.example.Respoitory;

import org.example.model.Producto;
import org.example.model.Usuario;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "InlinesUsuario", types = { Usuario.class })
public interface inlinesUsuario {
    Integer getId();
    String getNombre();
    String getApellido();
    String getEmail();
    String getDireccion();
    //Boolean getDeleted();




}
