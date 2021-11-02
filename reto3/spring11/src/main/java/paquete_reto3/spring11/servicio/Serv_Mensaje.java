package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import paquete_reto3.spring11.modelo.Mensaje;

public interface Serv_Mensaje {

    public List<Mensaje> listarMensajes(); // creamos metodo listarDisfraces usamos la clase disfraz creada en modelo que representa la tabla esn bd 
    public Optional<Mensaje> listarMensajeId(Integer id);  // para llamr a un disfraz por su id
    
    public String guardarMensaje(Mensaje mensajex); // instancimos directamente en parametro la clase Disfraz como disfrazx
    
    public String modificarMensaje(Mensaje mensajex);

    public boolean eliminarMensaje(Integer id); //pasandole solo la id
    public String eliminarMensaje(Mensaje mensajex); //pasandole todos los registros de la tabla
//he creado el metodo eliminarDisfraz con dos posibilidades de argumentar con todos los regustros o con solo id
}
