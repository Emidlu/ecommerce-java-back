package org.example.DTO.Usuario;

public class DTOUsuarioLoginResponse {
    private Integer id;
    private String nombre;
    private String email;

    public DTOUsuarioLoginResponse(String nombre, Integer id, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
    public DTOUsuarioLoginResponse() {}




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
