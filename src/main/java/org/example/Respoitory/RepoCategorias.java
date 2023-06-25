package org.example.Respoitory;


import org.example.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "categorias", excerptProjection = inlinesCategoria.class)
public interface RepoCategorias extends JpaRepository<Categoria, Integer> {
}
