package org.example.Respoitory;


import org.example.model.Categoria;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlinesCategoria", types = { Categoria.class })
public interface inlinesCategoria {

    public Integer getId();
    public String getNombre();
}
