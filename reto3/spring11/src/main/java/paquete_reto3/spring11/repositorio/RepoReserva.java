package paquete_reto3.spring11.repositorio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import paquete_reto3.spring11.modelo.Reserva;

@Repository
//creo una interfaz que extiende la clase CrudRepository que es una clase propia de springboot
public interface RepoReserva extends CrudRepository<Reserva, Integer> { 
    //vamos a crear otors crud mas complejos con jpql que se hacen de forma nativa usando los valores de las entidades
    //seleccionamos reservax osea todos los registros de latabla reserva instanciada como reservax
    @Query("select reservax from Reserva reservax") //anotacion sql a ejecutar sobre el metodo siguientelinea
    public List <Reserva> clientesMasReservas(); //creamos metodo para sustraer la lista

    
    //lista de clientes con la cantidad de reservas completadas en orden descendente 
    // @Query("SELECT e FROM Reserva e    WHERE  e.status=:x ORDER BY e.idReservation")
    @Query("SELECT e FROM Reserva e  WHERE  e.status=:x ORDER BY e.startDate DESC")
   public List <Reserva> clientReserCompleted(@Param("x") String  estado); //x es el dato a filtrar cuyo valor seria estado que fue pasado,por url


}
