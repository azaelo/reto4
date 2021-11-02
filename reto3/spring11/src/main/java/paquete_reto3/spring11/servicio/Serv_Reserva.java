package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import paquete_reto3.spring11.modelo.Reserva;

public interface Serv_Reserva {

    public List<Reserva> listarReservas(); // creamos metodo listarDisfraces usamos la clase disfraz creada en modelo que representa la tabla esn bd 
    public Optional<Reserva> listarReservaId(Integer id);  // para llamr a un disfraz por su id
    
    public String guardarReserva(Reserva reservax); // instancimos directamente en parametro la clase Disfraz como disfrazx
    
    public String modificarReserva(Reserva reservax);

    public boolean eliminarReserva(Integer id); //pasandole solo la id
    public String eliminarReserva(Reserva reservax); //pasandole todos los registros de la tabla
//he creado el metodo eliminarDisfraz con dos posibilidades de argumentar con todos los regustros o con solo id
    //METODO con JPQL
    public List <Reserva> listaClientMasReserv();
    public List <Reserva> obtClientMasReserv(String estado); //paso toda la lista de reserva
}
