package org.example.controller;

import org.example.Auxiliares.CarritoAux;
import org.example.DTO.Carrito.DTOCarritoCreateRequest;
import org.example.DTO.Carrito.DTOCarritoCreateResponse;
import org.example.DTO.Carrito.DTOCarritoProduct;
import org.example.DTO.Carrito.DTOCarritoResponse;
import org.example.Respoitory.*;
import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@CrossOrigin
@RepositoryRestController(path = "/carritos")
public class CarritoControllerComplement {

    @Autowired
    private RepoCarritos repoCarritos;

    @Autowired
    private RepoUsuarios repoUsuarios;

    @Autowired
    private RepoProductos repoProductos;

    @Autowired
    private RepoProductosCarritos repoProductosCarritos;

    @Autowired
    private RepoCategorias repoCategorias;





    @PostMapping(path = {"/", ""})
    public ResponseEntity<Object> createCarrito(@RequestBody DTOCarritoCreateRequest dtoCarritoCreateRequest){
        Carrito carrito = new Carrito();
        Usuario usuario = repoUsuarios.findById(dtoCarritoCreateRequest.getUsuario_id()).get();
        LocalDate localDate1 = LocalDate.now();
        carrito.setUsuario(usuario);
        carrito.setFechaCreacion(localDate1);
        repoCarritos.save(carrito);
        DTOCarritoCreateResponse dtoCarritoCreateResponse = new DTOCarritoCreateResponse();
        dtoCarritoCreateResponse.setCarrito_id(carrito.getId());
        return ResponseEntity.ok(dtoCarritoCreateResponse);

    }


    @PostMapping(path = "{id}/insert")
    public ResponseEntity<Object> insertACarrito(@PathVariable("id") Integer carritoId , @RequestBody DTOCarritoProduct dtoCarritoProduct) throws IOException {

        //Algoritmos auxiliares
        CarritoAux carritoAux = new CarritoAux();
        //Obtengo producto
        Producto producto = repoProductos.findById(dtoCarritoProduct.getProducto_id()).get();
        //Obtengo carrito
        Carrito carrito = repoCarritos.findById(carritoId).get();


        ProductoCarrito productoCarritoEnProceso = carritoAux.pivotConProcuto(carrito, producto);


        if(productoCarritoEnProceso != null){
            //Si ese producto ya esta en el carrito le aumento la cantidad
            Integer cantidadAnterior = productoCarritoEnProceso.getCantidad();
            productoCarritoEnProceso.setCantidad(cantidadAnterior+1);
            repoProductosCarritos.save(productoCarritoEnProceso);
        }else {
            //Creo tabla pivot de producto  en carrito
            productoCarritoEnProceso = new ProductoCarrito();
            productoCarritoEnProceso.setCarrito(carrito);
            productoCarritoEnProceso.setProducto(producto);
            productoCarritoEnProceso.setCantidad(1);

            List<ProductoCarrito> productoCarritos = carrito.getProductoCarritos();
            productoCarritos.add(productoCarritoEnProceso);
            carrito.setProductoCarritos(productoCarritos);


        }
        carritoAux.actualizarPrecioProductoCarrito(productoCarritoEnProceso);
        repoProductosCarritos.save(productoCarritoEnProceso);
        carritoAux.actualizar(carrito);
        repoCarritos.save(carrito);

        /*
        DTOCarritoCreateResponse dtoCarritoCreateResponse = new DTOCarritoCreateResponse();
        dtoCarritoCreateResponse.setCarrito_id(carrito.getId());

         */

        DTOCarritoResponse dtoCarritoResponse = new DTOCarritoResponse();
        dtoCarritoResponse.setMensaje("TODO BIEN");


        return ResponseEntity.ok(dtoCarritoResponse);

    }

    @PostMapping(path = "{id}/remove")
    public ResponseEntity<Object> removeDeCarrito(@PathVariable("id") Integer carritoId , @RequestBody DTOCarritoProduct dtoCarritoProduct) throws IOException {

        //Algoritmos auxiliares
        CarritoAux carritoAux = new CarritoAux();
        //Obtengo producto
        Producto producto = repoProductos.findById(dtoCarritoProduct.getProducto_id()).get();
        //Obtengo carrito
        Carrito carrito = repoCarritos.findById(carritoId).get();


        ProductoCarrito productoCarritoEnProceso = carritoAux.pivotConProcuto(carrito, producto);

        if(productoCarritoEnProceso != null){
            if (productoCarritoEnProceso.getCantidad()>1){
                Integer cantidadAnterior = productoCarritoEnProceso.getCantidad();
                productoCarritoEnProceso.setCantidad(cantidadAnterior-1);

                carritoAux.actualizarPrecioProductoCarrito(productoCarritoEnProceso);
                repoProductosCarritos.save(productoCarritoEnProceso);
            }else{
                carrito.getProductoCarritos().remove(productoCarritoEnProceso);
                repoProductosCarritos.delete(productoCarritoEnProceso);
            }

            carritoAux.actualizar(carrito);
            repoCarritos.save(carrito);


        }


        return ResponseEntity.ok("Removido");
    }


    @PostMapping(path = "{id}/comprar")
    public ResponseEntity<Object> comprarCarrito(@PathVariable("id") Integer carritoId){
        //Obtengo carrito
        Carrito carrito = repoCarritos.findById(carritoId).get();

        LocalDate localDate1 = LocalDate.now();
        carrito.setFechaPago(localDate1);
        repoCarritos.save(carrito);

        return ResponseEntity.ok("Comprado");
    }





}
