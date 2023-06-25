package org.example.Respoitory;

import org.example.model.Categoria;
import org.example.model.Producto;
import org.springframework.data.rest.core.config.Projection;


@Projection(name = "InlinesProducto", types = { Producto.class })
public interface inlinesProducto {
    public Integer getId();
    public String getNombre();
    public String getDescripcion();
    public String getImagen();
    public double getprecio();




    public Categoria getCategoria();
}
