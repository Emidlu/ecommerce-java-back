package org.example.Respoitory;

import org.example.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "carritos"/*, excerptProjection = inlinesCarrito.class*/)
public interface RepoCarritos extends JpaRepository<Carrito, Integer> {


    //public List<Carrito> findByUsuario_Email(String email);

    //public List<Carrito> findByUsuario_EmailAndAndFechaPagoNotNull(String email);

    public List<Carrito> findByUsuario_IdAndAndFechaPagoNotNull(Integer id);


    //public List<Carrito> findByUsuario_IdAAndAndFechaPagoNotNull(Integer id); esta rompe

    //public List<Carrito> findAllByUsuario_EmailAndAndFechaPagoNotNull(String email);

    //public List<Carrito> findByIdAndFechaPagoNull(Integer id);

}
