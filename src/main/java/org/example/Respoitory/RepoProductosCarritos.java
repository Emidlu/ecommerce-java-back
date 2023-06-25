package org.example.Respoitory;

import org.example.model.ProductoCarrito;
import org.omg.CORBA.INTERNAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RepositoryRestResource(excerptProjection = inlinesProductoCarrito.class)
public interface RepoProductosCarritos extends JpaRepository<ProductoCarrito, Integer> {
    //public ProductoCarrito findByCarrito_IdAndAndProductoId();
}
