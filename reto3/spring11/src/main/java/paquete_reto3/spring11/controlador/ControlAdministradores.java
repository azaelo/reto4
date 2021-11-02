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

import paquete_reto3.spring11.modelo.Administradores;
import paquete_reto3.spring11.servicio.Serv_Administradores;

//OPERACIONES CRUD  - LISTAR
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class ControlAdministradores {
   // Visualizacion la entidad
   @Autowired
   Serv_Administradores servAdministradoresObj; // utilizamos la interfaz creada en servicios pero usamos una instancia

   @GetMapping("/all")
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar registros de la entidad
   public List<Administradores> verAdministradores() {
      return servAdministradoresObj.listarAdministradores();
   } // aqui instancia de clase(entidad) y servicio listar

   @GetMapping("/{id}") // mostrar registro por id
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   // creamos metodo listar por id
   public Optional<Administradores> verUnAdministrador(@PathVariable("id") Integer id) {
      return servAdministradoresObj.listarAdministradoresId(id);
   }

   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED) //Respuesta 201 Created
   public String agregar(@RequestBody Administradores administradorx) { // ***OJO SI LE PONGO @RequestBody no funciona desde html */
      return servAdministradoresObj.guardarAdministradores(administradorx);
   }

   @PutMapping("/update") /// modificar/{id}"
   @ResponseStatus(HttpStatus.OK) //Respuesta 200 Ok
   public String modificar(@RequestBody Administradores administradorx) {
      return servAdministradoresObj.modificarAdministradores(administradorx);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT) //Respuesta 204 No_Content
   public boolean eliminar(@PathVariable("id") Integer id) { 
      return servAdministradoresObj.eliminarAdministradores(id);
   }

}
