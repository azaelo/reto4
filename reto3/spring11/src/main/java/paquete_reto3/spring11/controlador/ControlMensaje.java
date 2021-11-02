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

import paquete_reto3.spring11.modelo.Mensaje;
import paquete_reto3.spring11.servicio.Serv_Mensaje;

//OPERACIONES CRUD  - LISTAR
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class ControlMensaje {
   // Visualizacion la entidad
   @Autowired
   Serv_Mensaje servMensajeObj; // utilizamos la interfaz creada en servicios pero usamos una instancia

   @GetMapping("/all")
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar registros de la entidad
   public List<Mensaje> verMensajes() {
      return servMensajeObj.listarMensajes();
   } // aqui instancia de clase(entidad) y servicio listar

   @GetMapping("/{id}") // mostrar registro por id
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar por id
   public Optional<Mensaje> verUnMensaje(@PathVariable("id") Integer id) {
      return servMensajeObj.listarMensajeId(id);
   }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED) //Respuesta 201 Created
   public String agregar(@RequestBody Mensaje mensajex) { // ***OJO SI LE PONGO @RequestBody no funciona desde html */
      return servMensajeObj.guardarMensaje(mensajex);
   }

   @PutMapping("/update") /// modificar/{id}"
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   public String modificar(@RequestBody Mensaje mensajex) {
      return servMensajeObj.modificarMensaje(mensajex);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT) //Respuesta 204 No_Content
   public boolean eliminar(@PathVariable("id") Integer id) { 
      return servMensajeObj.eliminarMensaje(id);
   }

}
