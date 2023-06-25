package org.example;

import org.example.Respoitory.RepoCategorias;
import org.example.Respoitory.RepoProductos;
import org.example.Respoitory.RepoUsuarios;
import org.example.model.Categoria;
import org.example.model.Producto;
import org.example.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Main {
    @Autowired
    private RepoCategorias repoCategorias;

    @Autowired
    private RepoProductos repoProductos;

    @Autowired
    private RepoUsuarios repoUsuarios;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Bean
    public CommandLineRunner init() {


 /*
 public Usuario(Integer id, String nombre, String apellido, String email, String direccion, String password, Boolean deleted, List<Producto> productos, List<Carrito> carritos) {
     }
    */

    			return (args) -> {
    				if (args.length > 0) {
    					System.out.println(args[0]);
    				}

    				// cargas de las distintas categorias
    				Categoria electrodomesticos =  repoCategorias.save(new Categoria(1, null, "Electrodomesticos"));
                    Categoria indumentarias =  repoCategorias.save(new Categoria(2, null, "Indumentarias"));
                    Categoria celulares =  repoCategorias.save(new Categoria(3, null, "Celulares"));
                    Categoria deportes =  repoCategorias.save(new Categoria(4, null, "Deportes"));

                    // cargas de los usuarios
                    Usuario roberto = repoUsuarios.save(new Usuario(1, "Roberto", "Gomez", "robertito@gmail.com", "calles falsas 123", "1234", false, null, null));
                    Usuario carlos = repoUsuarios.save(new Usuario(2, "Carlos", "Perez", "carlitos@gmail.com", "calles falsas 12345", "1234", false, null, null));

                    // cargas de los distintos productos
                    Producto zapatillas =  repoProductos.save(new Producto(1, "Zapatillas", "Muy buenas zapatillas", "https://assets.adidas.com/images/w_600,f_auto,q_auto/f88bdbb8f061489a9e8fadfe011d45a2_9366/Zapatillas_Forum_Low_Blanco_GV7613_01_standard.jpg",1000 , 10, carlos, null,deportes));
                    Producto jean =  repoProductos.save(new Producto(2, "Jean", "Muy buen pantalon", "https://equus.vtexassets.com/arquivos/ids/248888-500-auto?v=638048333395430000&width=500&height=auto&aspect=true",3000 , 10, carlos, null,indumentarias));
                    Producto jogging = repoProductos.save(new Producto(3, "Jogging", "Muy buen pantalon", "https://taverniti.vteximg.com.br/arquivos/ids/243487-1000-1000/15450_602X1.jpg?v=637935020994700000",3000 , 10, carlos, null,indumentarias));
                    Producto ojotas = repoProductos.save(new Producto(4, "Ojotas", "Muy buenas ojotas", "http://d3ugyf2ht6aenh.cloudfront.net/stores/001/720/731/products/ojotas-dc-bolsa-5c3f989c0546d6606316231849905526-640-0.jpg",6000 , 10, roberto, null,indumentarias));
                    Producto horno = repoProductos.save(new Producto(5, "Horno", "Muy buen horno", "https://www.rribaceta.com.ar/1177-large_default/horno-electrico-hg9010e-atma.jpg",6000 , 10, roberto, null,electrodomesticos));
                    Producto estufa = repoProductos.save(new Producto(6, "Estufa", "Muy buena estufa", "https://pardohogar.vtexassets.com/arquivos/ids/163019/volcan04.jpg?v=637236888307900000",6000 , 10, roberto, null,electrodomesticos));
                    Producto heladera = repoProductos.save(new Producto(7, "Heladera", "Muy buena heladera", "https://ockam-cloud-dr.imgix.net/imagenes-s/productos/heladera-patrick-qp458bkrss0-sbs-516l-inox-13398.jpg?auto=format",6000 , 10, roberto, null,electrodomesticos));
                    Producto celular = repoProductos.save(new Producto(8, "Celular", "Muy buen celular", "https://jumboargentina.vtexassets.com/arquivos/ids/701966/Celular-Samsung-Galaxy-A23-Lte-Celeste-1-888437.jpg?v=637889386471900000",6000 , 10, roberto, null,celulares));
                    Producto pelota= repoProductos.save(new Producto(9, "Pelota", "Muy buena pelota", "https://monterosport.com.ar/wp-content/uploads/2016/10/pelota-de-fubol-cuero-nacional.jpg",6000 , 10, roberto, null,deportes));

    			};

    		};

}