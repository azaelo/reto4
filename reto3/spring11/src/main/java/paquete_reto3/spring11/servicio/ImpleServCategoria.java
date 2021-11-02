package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import paquete_reto3.spring11.modelo.Categoria;
import paquete_reto3.spring11.repositorio.RepoCategoria;

@Service
public class ImpleServCategoria implements Serv_Categoria { //implementamos el servicio
  
    @Autowired
    RepoCategoria repoCategoriaObjeto; // instanciamos repositorio que nos deja usar los metodos crud

    @Transactional (readOnly = true)
    @Override
    public List<Categoria> listarCategorias() {
        return  (List<Categoria>) repoCategoriaObjeto.findAll();
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Categoria> listarCategoriaId(Integer id) {
        return   repoCategoriaObjeto.findById(id);
    }

    @Transactional
    @Override
    public  String guardarCategoria(Categoria categoriax) {
        repoCategoriaObjeto.save(categoriax);
        return null;               
    }

    @Transactional
    @Override
    public String modificarCategoria(Categoria categoriax) {
        repoCategoriaObjeto.save(categoriax);
        return null;
    }

    @Transactional
    @Override
    public boolean eliminarCategoria(Integer id) {
        boolean varIndica = true;
        if (repoCategoriaObjeto.findById(id).isPresent()){ //si halla el id
            repoCategoriaObjeto.deleteById(id);
        } else {
            varIndica= false;
        }
        
        return varIndica;        
    }

    @Transactional
    @Override
    public String eliminarCategoria(Categoria categoriax) {
            // opcion 1 
            //operacionesPlaneta.deleteById(planeta.getCodigo());        
            // opcion 2
            repoCategoriaObjeto.delete(categoriax);
            return null;
    }
    
    
    
}
