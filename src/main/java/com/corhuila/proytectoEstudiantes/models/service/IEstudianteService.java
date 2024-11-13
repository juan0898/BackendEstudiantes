package com.corhuila.proytectoEstudiantes.models.service;

import com.corhuila.proytectoEstudiantes.models.entity.Estudiante;

import java.util.List;

public interface IEstudianteService {
    public List<Estudiante> findAll();

    public Estudiante findById(Long id);

    public Estudiante save(Estudiante estudiante);

    public void delete(Long id);
}
