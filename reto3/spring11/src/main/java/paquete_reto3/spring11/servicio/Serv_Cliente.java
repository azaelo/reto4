package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import paquete_reto3.spring11.modelo.Cliente;

public interface Serv_Cliente {

    public List<Cliente> listarClientes(); // creamos metodo listarDisfraces usamos la clase disfraz creada en modelo que representa la tabla esn bd 
    public Optional<Cliente> listarClienteId(Integer id);  // para llamr a un disfraz por su id
    
    public String guardarCliente(Cliente clientex); // instancimos directamente en parametro la clase Disfraz como disfrazx
    
    public String modificarCliente(Cliente clientex);

    public boolean eliminarCliente(Integer id); //pasandole solo la id
    public String eliminarCliente(Cliente clientex); //pasandole todos los registros de la tabla
//he creado el metodo eliminarDisfraz con dos posibilidades de argumentar con todos los regustros o con solo id
}
