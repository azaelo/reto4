package paquete_reto3.spring11.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import paquete_reto3.spring11.modelo.Reserva;
import paquete_reto3.spring11.repositorio.RepoReserva;

@Service
public class ImpleServReserva implements Serv_Reserva { //implementamos el servicio
  
    @Autowired
    RepoReserva repoReservaObjeto; // instanciamos repositorio que nos deja usar los metodos crud

    @Transactional (readOnly = true)
    @Override
    public List<Reserva> listarReservas() {
        return  (List<Reserva>) repoReservaObjeto.findAll();
    }

    @Transactional (readOnly = true)
    @Override
    public Optional<Reserva> listarReservaId(Integer id) {
        return   repoReservaObjeto.findById(id);
    }

    @Transactional
    @Override
    public  String guardarReserva(Reserva reservax) {
        repoReservaObjeto.save(reservax);
        return null;               
    }

    @Transactional
    @Override
    public String modificarReserva(Reserva reservax) {
        repoReservaObjeto.save(reservax);
        return null;
    }

    @Transactional
    @Override
    public boolean eliminarReserva(Integer id) {
        boolean varIndica = true;
        if (repoReservaObjeto.findById(id).isPresent()){ //si halla el id
            repoReservaObjeto.deleteById(id);
        } else {
            varIndica= false;
        }
        
        return varIndica;        
    }

    @Transactional
    @Override
    public String eliminarReserva(Reserva reservax) {
            // opcion 1 
            //operacionesPlaneta.deleteById(planeta.getCodigo());        
            // opcion 2
            repoReservaObjeto.delete(reservax);
            return null;
    }
    //********************************************************************************************************* */
    @Override
    public List<Reserva> listaClientMasReserv() { //servicio
        return repoReservaObjeto.clientesMasReservas(); //objeto . crud de repositorio//aqui le pasamos el crud jpql
    }
    
    @Override
    public List<Reserva> obtClientMasReserv(String estado) {
        return repoReservaObjeto.clientReserCompleted(estado);
    }
    
}
