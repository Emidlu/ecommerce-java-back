package org.example.Respoitory;

import org.example.model.Usuario;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@RepositoryRestResource(path = "usuarios", excerptProjection = inlinesUsuario.class)
public interface RepoUsuarios extends JpaRepository<Usuario, Integer> {

    public Usuario findByEmail(String email);
    //public Usuario findAllByDeleted(Boolean deleted);

}
