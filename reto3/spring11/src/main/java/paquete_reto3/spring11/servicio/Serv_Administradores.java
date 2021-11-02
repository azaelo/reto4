package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import paquete_reto3.spring11.modelo.Administradores;

public interface Serv_Administradores {

    public List<Administradores> listarAdministradores(); // creamos metodo listarDisfraces usamos la clase disfraz creada en modelo que representa la tabla esn bd 
    public Optional<Administradores> listarAdministradoresId(Integer id);  // para llamr a un disfraz por su id
    
    public String guardarAdministradores(Administradores administradorx); // instancimos directamente en parametro la clase Disfraz como disfrazx
    
    public String modificarAdministradores(Administradores administradorx);

    public boolean eliminarAdministradores(Integer id); //pasandole solo la id
    public String eliminarAdministradores(Administradores administradorx); //pasandole todos los registros de la tabla
//he creado el metodo eliminarDisfraz con dos posibilidades de argumentar con todos los regustros o con solo id
}
