package org.example.DTO.Carrito;

public class DTOCarritoCreateResponse {

    private Integer carrito_id;

    public DTOCarritoCreateResponse(Integer carrito_id) {
        this.carrito_id = carrito_id;
    }

    public DTOCarritoCreateResponse() {}

    public Integer getCarrito_id() {
        return carrito_id;
    }

    public void setCarrito_id(Integer carrito_id) {
        this.carrito_id = carrito_id;
    }
}
