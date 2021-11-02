package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import paquete_reto3.spring11.modelo.Disfraz;
import paquete_reto3.spring11.repositorio.RepoDisfraz;

@Service
public class ImpleServDisfraz implements Serv_Disfraz { //implementamos el servicio
  
    @Autowired
    RepoDisfraz repodisfrazObjeto; // instanciamos repositorio que nos deja usar los metodos crud

    @Transactional (readOnly = true)
    @Override
    public List<Disfraz> listarDisfraces() {
        return  (List<Disfraz>) repodisfrazObjeto.findAll();
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Disfraz> listarDisfrazId(Integer id) {
        return   repodisfrazObjeto.findById(id);
    }

    @Transactional
    @Override
    public  String guardarDisfraces(Disfraz disfrazx) {
        repodisfrazObjeto.save(disfrazx);
        return null;               
    }

    @Transactional
    @Override
    public String modificarDisfraz(Disfraz disfrazx) {
        repodisfrazObjeto.save(disfrazx);
        return null;
    }

    @Transactional
    @Override
    public boolean eliminarDisfraces(Integer id) {
        boolean varIndica = true;
        if (repodisfrazObjeto.findById(id).isPresent()){ //si halla el id
            repodisfrazObjeto.deleteById(id);
        } else {
            varIndica= false;
        }
        
        return varIndica;        
    }

    @Transactional
    @Override
    public String eliminarDisfraces(Disfraz disfrazx) {
            // opcion 1 
            //operacionesPlaneta.deleteById(planeta.getCodigo());        
            // opcion 2
            repodisfrazObjeto.delete(disfrazx);
            return null;
    }
    
    
    
}
