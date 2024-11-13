package com.corhuila.proytectoEstudiantes.models.dao;

import com.corhuila.proytectoEstudiantes.models.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;

// Interfaz que extiende de CrudRepository para proporcionar operaciones CRUD básicas
// para la entidad Estudiante en la base de datos.
public interface IEstudianteDao extends CrudRepository<Estudiante, Long> {
}
