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

import paquete_reto3.spring11.modelo.Disfraz;
import paquete_reto3.spring11.servicio.Serv_Disfraz;

//OPERACIONES CRUD  - LISTAR
@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class ControlDisfraz {
   // Visualizacion la entidad
   @Autowired
   Serv_Disfraz servDisfrazObj; // utilizamos la interfaz creada en servicios pero usamos una instancia

   @GetMapping("/all")
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar registros de la entidad
   public List<Disfraz> verDisfraces() {
      return servDisfrazObj.listarDisfraces();
   } // aqui instancia de clase(entidad) y servicio listar

   @GetMapping("/{id}") // mostrar registro por id
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar por id
   public Optional<Disfraz> verUnDisfraz(@PathVariable("id") Integer id) {
      return servDisfrazObj.listarDisfrazId(id);
   }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED) //Respuesta 201 Created
   public String agregar(@RequestBody Disfraz disfrazx) { // ***OJO SI LE PONGO @RequestBody no funciona desde html */
      return servDisfrazObj.guardarDisfraces(disfrazx);
   }

   @PutMapping("/update") /// modificar/{id}"
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   public String modificar(@RequestBody Disfraz disfrazx) {
      return servDisfrazObj.modificarDisfraz(disfrazx);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT) //Respuesta 204 No_Content
   public boolean eliminar(@PathVariable("id") Integer id) { 
      return servDisfrazObj.eliminarDisfraces(id);
   }

}
