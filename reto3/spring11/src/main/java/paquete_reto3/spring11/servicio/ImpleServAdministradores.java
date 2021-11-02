package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import paquete_reto3.spring11.modelo.Administradores;
import paquete_reto3.spring11.repositorio.RepoAdministradores;

@Service
public class ImpleServAdministradores implements Serv_Administradores { //implementamos el servicio
  
    @Autowired
    RepoAdministradores repoAdministradoresObjeto; // instanciamos repositorio que nos deja usar los metodos crud

    @Transactional (readOnly = true)
    @Override
    public List<Administradores> listarAdministradores() {
        return  (List<Administradores>) repoAdministradoresObjeto.findAll();
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Administradores> listarAdministradoresId(Integer id) {
        return   repoAdministradoresObjeto.findById(id);
    }

    @Transactional
    @Override
    public  String guardarAdministradores(Administradores administradorx) {
        repoAdministradoresObjeto.save(administradorx);
        return null;               
    }

    @Transactional
    @Override
    public String modificarAdministradores(Administradores administradorx) {
        repoAdministradoresObjeto.save(administradorx);
        return null;
    }

    @Transactional
    @Override
    public boolean eliminarAdministradores(Integer id) {
        boolean varIndica = true;
        if (repoAdministradoresObjeto.findById(id).isPresent()){ //si halla el id
            repoAdministradoresObjeto.deleteById(id);
        } else {
            varIndica= false;
        }
        
        return varIndica;        
    }

    @Transactional
    @Override
    public String eliminarAdministradores(Administradores administradorx) {
            // opcion 1 
            //operacionesPlaneta.deleteById(planeta.getCodigo());        
            // opcion 2
            repoAdministradoresObjeto.delete(administradorx);
            return null;
    }
    
    
    
}
