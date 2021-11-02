package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import paquete_reto3.spring11.modelo.Disfraz;

public interface Serv_Disfraz {

    public List<Disfraz> listarDisfraces(); // creamos metodo listarDisfraces usamos la clase disfraz creada en modelo que representa la tabla esn bd 
    public Optional<Disfraz> listarDisfrazId(Integer id);  // para llamr a un disfraz por su id
    
    public String guardarDisfraces(Disfraz disfrazx); // instancimos directamente en parametro la clase Disfraz como disfrazx
    
    public String modificarDisfraz(Disfraz disfrazx);

    public boolean eliminarDisfraces(Integer id); //pasandole solo la id
    public String eliminarDisfraces(Disfraz disfrazx); //pasandole todos los registros de la tabla
//he creado el metodo eliminarDisfraz con dos posibilidades de argumentar con todos los regustros o con solo id
}
