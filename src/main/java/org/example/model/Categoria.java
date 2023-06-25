package org.example.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public Categoria() {}

    public Categoria(Integer id, List<Producto> productos, String nombre) {
        this.id = id;
        this.productos = productos;
        this.nombre = nombre;
    }

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();



    private String nombre;


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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
