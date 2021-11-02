package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import paquete_reto3.spring11.modelo.Cliente;
import paquete_reto3.spring11.repositorio.RepoCliente;

@Service
public class ImpleServCliente implements Serv_Cliente { //implementamos el servicio
  
    @Autowired
    RepoCliente repoClienteObjeto; // instanciamos repositorio que nos deja usar los metodos crud

    @Transactional (readOnly = true)
    @Override
    public List<Cliente> listarClientes() {
        return  (List<Cliente>) repoClienteObjeto.findAll();
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Cliente> listarClienteId(Integer id) {
        return   repoClienteObjeto.findById(id);
    }

    @Transactional
    @Override
    public  String guardarCliente(Cliente clientex) {
        repoClienteObjeto.save(clientex);
        return null;               
    }

    @Transactional
    @Override
    public String modificarCliente(Cliente clientex) {
        repoClienteObjeto.save(clientex);
        return null;
    }

    @Transactional
    @Override
    public boolean eliminarCliente(Integer id) {
        boolean varIndica = true;
        if (repoClienteObjeto.findById(id).isPresent()){ //si halla el id
            repoClienteObjeto.deleteById(id);
        } else {
            varIndica= false;
        }
        
        return varIndica;        
    }

    @Transactional
    @Override
    public String eliminarCliente(Cliente clientex) {
            // opcion 1 
            //operacionesPlaneta.deleteById(planeta.getCodigo());        
            // opcion 2
            repoClienteObjeto.delete(clientex);
            return null;
    }
    
    
    
}
