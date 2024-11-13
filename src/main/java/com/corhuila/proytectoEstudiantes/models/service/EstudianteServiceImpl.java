package com.corhuila.proytectoEstudiantes.models.service;

import com.corhuila.proytectoEstudiantes.models.dao.IEstudianteDao;
import com.corhuila.proytectoEstudiantes.models.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// La anotación @Service indica que esta clase es un servicio de Spring que contiene la lógica de negocio.
@Service
public class EstudianteServiceImpl implements IEstudianteService{

    // Inyección de dependencia del DAO (Data Access Object),
    // que es la interfaz para acceder a la base de datos de los estudiantes.
    @Autowired
    private IEstudianteDao estudianteDao;

    // El método findAll() recupera todos los estudiantes desde la base de datos.
    // La anotación @Transactional(readOnly = true) indica que este método solo realiza una lectura (sin cambios).
    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        // Retorna todos los estudiantes obtenidos mediante el DAO
        return (List<Estudiante>) estudianteDao.findAll();
    }

    // El método findById() busca un estudiante por su ID.
    // Si no se encuentra, retorna null (en lugar de lanzar una excepción).
    @Override
    @Transactional(readOnly = true)
    // Retorna el estudiante si existe, de lo contrario retorna null.
    public Estudiante findById(Long id){
        return estudianteDao.findById(id).orElse(null);
    }

    // El método save() guarda o actualiza un estudiante en la base de datos.
    // La anotación @Transactional indica que se realiza una transacción de escritura.
    @Override
    @Transactional
    // Guarda el estudiante a través del DAO y lo retorna.
    public Estudiante save(Estudiante estudiante) {
        return estudianteDao.save(estudiante);
    }

    // El método delete() elimina un estudiante de la base de datos por su ID.
    @Override
    @Transactional
    // Elimina el estudiante usando el DAO mediante el ID proporcionado.
    public void delete(Long id) {
        estudianteDao.deleteById(id);
    }
}
