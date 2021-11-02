package paquete_reto3.spring11.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import paquete_reto3.spring11.modelo.Cliente;

@Repository
//creo una interfaz que extiende la clase CrudRepository que es una clase propia de springboot
public interface RepoCliente extends CrudRepository<Cliente, Integer> { 

}
