package org.example.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Where(clause = "deleted = false")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String password;

    private Boolean deleted;


    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos = new ArrayList<>();


    @OneToMany(mappedBy = "usuario")
    private List<Carrito> carritos = new ArrayList<>();

    public Usuario(Integer id, String nombre, String apellido, String email, String direccion, String password, Boolean deleted, List<Producto> productos, List<Carrito> carritos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.password = password;
        this.deleted = deleted;
        this.productos = productos;
        this.carritos = carritos;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean activo) {
        this.deleted = activo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        for(Producto producto : productos){
            producto.setUsuario(this);
        }
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
                + ", direccion=" + direccion + ", deleted=" + deleted + ", password=" + password
                + "]";
    }


    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }
}
