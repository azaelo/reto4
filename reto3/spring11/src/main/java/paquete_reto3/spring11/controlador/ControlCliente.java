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

import paquete_reto3.spring11.modelo.Cliente;
import paquete_reto3.spring11.servicio.Serv_Cliente;

//OPERACIONES CRUD  - LISTAR
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class ControlCliente {
   // Visualizacion la entidad
   @Autowired
   Serv_Cliente servClienteObj; // utilizamos la interfaz creada en servicios pero usamos una instancia

   @GetMapping("/all")
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar registros de la entidad
   public List<Cliente> verClientes() {
      return servClienteObj.listarClientes();
   } // aqui instancia de clase(entidad) y servicio listar

   @GetMapping("/{id}") // mostrar registro por id
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar por id
   public Optional<Cliente> verUnCliente(@PathVariable("id") Integer id) {
      return servClienteObj.listarClienteId(id);
   }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED) //Respuesta 201 Created
   public String agregar(@RequestBody Cliente clientex) { // ***OJO SI LE PONGO @RequestBody no funciona desde html */
      return servClienteObj.guardarCliente(clientex);
   }

   @PutMapping("/update") /// modificar/{id}"
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   public String modificar(@RequestBody Cliente clientex) {
      return servClienteObj.modificarCliente(clientex);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT) //Respuesta 204 No_Content
   public boolean eliminar(@PathVariable("id") Integer id) { 
      return servClienteObj.eliminarCliente(id);
   }

}
