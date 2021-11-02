package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import paquete_reto3.spring11.modelo.Mensaje;
import paquete_reto3.spring11.repositorio.RepoMensaje;

@Service
public class ImpleServMensaje implements Serv_Mensaje { //implementamos el servicio
  
    @Autowired
    RepoMensaje repoMensajeObjeto; // instanciamos repositorio que nos deja usar los metodos crud

    @Transactional (readOnly = true)
    @Override
    public List<Mensaje> listarMensajes() {
        return  (List<Mensaje>) repoMensajeObjeto.findAll();
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Mensaje> listarMensajeId(Integer id) {
        return   repoMensajeObjeto.findById(id);
    }

    @Transactional
    @Override
    public  String guardarMensaje(Mensaje mensajex) {
        repoMensajeObjeto.save(mensajex);
        return null;               
    }

    @Transactional
    @Override
    public String modificarMensaje(Mensaje mensajex) {
        repoMensajeObjeto.save(mensajex);
        return null;
    }

    @Transactional
    @Override
    public boolean eliminarMensaje(Integer id) {
        boolean varIndica = true;
        if (repoMensajeObjeto.findById(id).isPresent()){ //si halla el id
            repoMensajeObjeto.deleteById(id);
        } else {
            varIndica= false;
        }
        
        return varIndica;        
    }

    @Transactional
    @Override
    public String eliminarMensaje(Mensaje mensajex) {
            // opcion 1 
            //operacionesPlaneta.deleteById(planeta.getCodigo());        
            // opcion 2
            repoMensajeObjeto.delete(mensajex);
            return null;
    }
    
    
    
}
