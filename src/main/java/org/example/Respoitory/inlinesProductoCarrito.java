package org.example.Respoitory;


import org.example.model.Carrito;
import org.example.model.Producto;
import org.example.model.ProductoCarrito;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlinesProductoCarrito", types = { ProductoCarrito.class })
public interface inlinesProductoCarrito {
    public Integer getId();

    public double getTotalParcial();

    public Integer getCantidad();

    public Producto getProducto();

    public Carrito getCarrito();
}
