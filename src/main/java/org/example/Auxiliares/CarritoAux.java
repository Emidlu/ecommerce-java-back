package org.example.Auxiliares;
import org.example.entities.Dolar;
import org.example.model.Carrito;
import org.example.model.Producto;
import org.example.model.ProductoCarrito;
import org.example.servicios.ServicioDolar;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class CarritoAux {

    public Carrito actualizar(Carrito carrito) throws IOException {
        List<ProductoCarrito> productoCarritos = carrito.getProductoCarritos();
        double total = 0;
        for(ProductoCarrito elemento : productoCarritos){
            total += elemento.getTotalParcial();
        }
        carrito.setTotal(total);
        carrito.setTotalDolares(convertirADolares(total));

        return carrito;
    }

    public Double convertirADolares(Double montoEnPesos) throws IOException {
        ServicioDolar servicioDolar = new ServicioDolar();
        Dolar dolar = servicioDolar.dolar();
        Number valorDolar = dolar.blue.value_sell;
        return (  (double)Math.round(montoEnPesos / valorDolar.doubleValue() * 100d) / 100d  );
    }

    public ProductoCarrito actualizarPrecioProductoCarrito(ProductoCarrito productoCarrito){
        Producto producto = productoCarrito.getProducto();
        productoCarrito.setTotalParcial(producto.getPrecio() * productoCarrito.getCantidad());

        return productoCarrito;
    }


    public ProductoCarrito pivotConProcuto(Carrito carrito, Producto producto){

        List <ProductoCarrito> productoCarritos = carrito.getProductoCarritos();

        ProductoCarrito productoCarritoEncontrado = null;

        for(ProductoCarrito element : productoCarritos){
            if(element.getProducto().equals(producto)){
                productoCarritoEncontrado = element;
                break;
            }
        }
        return productoCarritoEncontrado;
    }




}


