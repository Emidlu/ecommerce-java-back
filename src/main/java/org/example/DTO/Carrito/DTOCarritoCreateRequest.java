package org.example.DTO.Carrito;

public class DTOCarritoCreateRequest {


    private Integer usuario_id;

    public DTOCarritoCreateRequest(Integer usuario_id) {
        this.setUsuario_id(usuario_id);
    }

    public DTOCarritoCreateRequest() { }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }
}
