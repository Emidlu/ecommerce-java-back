package org.example.DTO.Carrito;

public class DTOCarritoProduct {
    private Integer producto_id;

    public DTOCarritoProduct(Integer producto_id) {
        this.setProducto_id(producto_id);
    }
    public DTOCarritoProduct() {}

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }
}
