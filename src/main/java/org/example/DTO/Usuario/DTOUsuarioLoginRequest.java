package org.example.DTO.Usuario;

public class DTOUsuarioLoginRequest {
    private String email;
    private String password;

    public DTOUsuarioLoginRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public DTOUsuarioLoginRequest() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
