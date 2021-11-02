package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import paquete_reto3.spring11.modelo.Categoria;

public interface Serv_Categoria {

    public List<Categoria> listarCategorias(); // creamos metodo listarDisfraces usamos la clase disfraz creada en modelo que representa la tabla esn bd 
    public Optional<Categoria> listarCategoriaId(Integer id);  // para llamr a un disfraz por su id
    
    public String guardarCategoria(Categoria categoriax); // instancimos directamente en parametro la clase Disfraz como disfrazx
    
    public String modificarCategoria(Categoria categoriax);

    public boolean eliminarCategoria(Integer id); //pasandole solo la id
    public String eliminarCategoria(Categoria categoriax); //pasandole todos los registros de la tabla
//he creado el metodo eliminarDisfraz con dos posibilidades de argumentar con todos los regustros o con solo id
}
