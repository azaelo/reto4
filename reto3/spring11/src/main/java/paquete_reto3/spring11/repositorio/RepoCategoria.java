package paquete_reto3.spring11.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import paquete_reto3.spring11.modelo.Categoria;

@Repository
//creo una interfaz que extiende la clase CrudRepository que es una clase propia de springboot
public interface RepoCategoria extends CrudRepository<Categoria, Integer> { 

}
