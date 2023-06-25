package org.example.DTO.Carrito;

public class DTOCarritoResponse {



    private String mensaje;

    public DTOCarritoResponse(String mensaje) {
        this.setMensaje(mensaje);
    }

    public DTOCarritoResponse() {  }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
