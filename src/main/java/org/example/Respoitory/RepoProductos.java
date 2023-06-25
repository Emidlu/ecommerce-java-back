package org.example.Respoitory;

import org.example.model.Producto;
import org.example.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "productos", excerptProjection = inlinesProducto.class)
public interface RepoProductos extends JpaRepository<Producto, Integer> {


    public Producto findByNombre(String nombre);
    //public Producto findAllByCategoria(String categoria);


    //public List<Producto> findByCategoria_IdAndAndNombre(Integer id, String nombre);


    //public Page<Producto> findByCategoria_IdAndAndNombre(Integer id, String nombre, Pageable pageable);

    public Page<Producto> findByCategoria_Id(Integer id, Pageable pageable);

    public Page<Producto> findByNombreOrCategoria_IdAndNombre(String nombreSolo, Integer id, String nombre, Pageable pageable);
    //Esto se puede consultar asi
    // Para categoria y nombre
    // http://localhost:8080/productos/search/findByNombreOrCategoria_IdAndNombre?id=2&nombre=Madera chota&size=3&page=0
    // o para nombre solamente escribiendo en la ruta nombreSolo
    // http://localhost:8080/productos/search/findByNombreOrCategoria_IdAndNombre?nombreSolo=Madera chota&size=3&page=0



}
