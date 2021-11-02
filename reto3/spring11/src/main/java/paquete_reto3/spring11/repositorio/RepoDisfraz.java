package paquete_reto3.spring11.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import paquete_reto3.spring11.modelo.Disfraz;

@Repository
//creo una interfaz que extiende la clase CrudRepository que es una clase propia de springboot
public interface RepoDisfraz extends CrudRepository<Disfraz, Integer> { 
//ahora mi clase creada aqui RepoDisfraz tendra metodos que son propios de CrudRepository y
//solicitara una clase del modelo que tenga valores de la bd como ene est caso Disfraz y un entero poruqe revisando
//la clase nativa CrudRepositori necesita valores todo o de un id para gestionar sus crud.
}
