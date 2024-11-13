package com.corhuila.proytectoEstudiantes.controllers;

import com.corhuila.proytectoEstudiantes.models.entity.Estudiante;
import com.corhuila.proytectoEstudiantes.models.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"}) // Permite solicitudes CORS desde el frontend en localhost:4200
@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api") // Define la ruta base para las solicitudes REST (todos los endpoints comienzan con "/api")
public class EstudianteRestController {

    @Autowired // Inyecta la dependencia del servicio IEstudianteService
    private IEstudianteService estudianteService;

    // Método para obtener la lista de todos los estudiantes
    @GetMapping("/estudiantes")  // Define el endpoint para obtener todos los estudiantes
    public List<Estudiante> index(){
        return estudianteService.findAll();// Llama al servicio para obtener todos los estudiantes
    }

    // Método para obtener un estudiante específico por su ID
    @GetMapping("/estudiantes/{id}") // Define el endpoint para obtener un estudiante por su ID
    public Estudiante show(@PathVariable Long id){
        return estudianteService.findById(id);// Llama al servicio para obtener el estudiante por su ID
    }

    // Método para crear un nuevo estudiante
    @PostMapping("/estudiantes") // Define el endpoint para crear un nuevo estudiante
    @ResponseStatus(HttpStatus.CREATED) // Establece el código de respuesta HTTP 201 (creado)
    public Estudiante create (@RequestBody Estudiante estudiante){
        return estudianteService.save(estudiante);// Llama al servicio para guardar el nuevo estudiante
    }

    // Método para actualizar un estudiante existente
    @PutMapping("/estudiantes/{id}") // Define el endpoint para actualizar un estudiante por su ID
    @ResponseStatus(HttpStatus.CREATED) // Establece el código de respuesta HTTP 201 (creado) al actualizar
    public  Estudiante update (@RequestBody Estudiante estudiante, @PathVariable Long id){
        Estudiante estudianteActual = estudianteService.findById(id);// Obtiene el estudiante actual con el ID proporcionado

        // Actualiza los datos del estudiante con los nuevos valores
        estudianteActual.setNombre(estudiante.getNombre());
        estudianteActual.setEdad(estudiante.getEdad());
        estudianteActual.setCarrera(estudiante.getCarrera());
        estudianteActual.setUniversidad(estudiante.getUniversidad());
        estudianteActual.setPromedio(estudiante.getPromedio());

        return estudianteService.save(estudianteActual);// Guarda los cambios del estudiante actualizado
    }
    // Método para eliminar un estudiante por su ID
    @DeleteMapping("/estudiantes/{id}") // Define el endpoint para eliminar un estudiante por su ID
    @ResponseStatus(HttpStatus.NO_CONTENT)// Establece el código de respuesta HTTP 204 (sin contenido) al eliminar
    public void delete (@PathVariable Long id){
        estudianteService.delete(id);// Llama al servicio para eliminar el estudiante por su ID
    }
}
