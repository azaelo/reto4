package paquete_reto3.spring11.controlador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus; //respuestas de la solicitudes http
import java.util.List;
import java.util.Optional;

import paquete_reto3.spring11.modelo.Reserva;
import paquete_reto3.spring11.servicio.Serv_Reserva;

//OPERACIONES CRUD  - LISTAR
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class ControlReserva {
   // Visualizacion la entidad
   @Autowired
   Serv_Reserva servReservaObj; // utilizamos la interfaz creada en servicios pero usamos una instancia

   @GetMapping("/all")
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar registros de la entidad
   public List<Reserva> verReservas() {
      return servReservaObj.listarReservas();
   } // aqui instancia de clase(entidad) y servicio listar

   @GetMapping("/{id}") // mostrar registro por id
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar por id
   public Optional<Reserva> verUnaReserva(@PathVariable("id") Integer id) {
      return servReservaObj.listarReservaId(id);
   }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED) //Respuesta 201 Created
   public String agregar(@RequestBody Reserva reservax) { // ***OJO SI LE PONGO @RequestBody no funciona desde html */
      return servReservaObj.guardarReserva(reservax);
   }

   @PutMapping("/update") /// modificar/{id}"
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   public String modificar(@RequestBody Reserva reservax) {
      return servReservaObj.modificarReserva(reservax);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT) //Respuesta 204 No_Content
   public boolean eliminar(@PathVariable("id") Integer id) { 
      return servReservaObj.eliminarReserva(id);
   }

   //con jpql
   @GetMapping("/report")
   public List<Reserva> verClienMasReser() {
      return servReservaObj.listaClientMasReserv();
   }

   @GetMapping("/report-clients/{estado}")
   public List<Reserva> obtenerClientStatusCompleted(@PathVariable("estado") String estado) {
      return servReservaObj.obtClientMasReserv(estado); //objeto.servicio
   }

}
