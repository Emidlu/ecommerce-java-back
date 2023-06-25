package org.example.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "carritos")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double total;

    private double totalDolares;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaCreacion;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaPago;


    @OneToMany(mappedBy = "carrito")//, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProductoCarrito> productoCarritos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Carrito(Integer id, double total, double totalDolares, LocalDate fechaCreacion, LocalDate fechaPago, List<ProductoCarrito> productoCarritos, Usuario usuario) {
        this.id = id;
        this.total = total;
        this.totalDolares = totalDolares;
        this.fechaCreacion = fechaCreacion;
        this.fechaPago = fechaPago;
        this.productoCarritos = productoCarritos;
        this.usuario = usuario;
    }

    public Carrito() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }


    public List<ProductoCarrito> getProductoCarritos() {
        return productoCarritos;
    }

    public void setProductoCarritos(List<ProductoCarrito> productoCarritos) {
        this.productoCarritos = productoCarritos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getTotalDolares() {
        return totalDolares;
    }

    public void setTotalDolares(double totalDolares) {
        this.totalDolares = totalDolares;
    }
}
