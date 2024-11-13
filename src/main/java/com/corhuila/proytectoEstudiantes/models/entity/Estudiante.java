package com.corhuila.proytectoEstudiantes.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;

// La anotación @Entity indica que esta clase es una entidad JPA que se mapeará a una tabla en la base de datos.
@Entity
@Table(name="estudiantes")// La tabla en la base de datos donde se almacenarán los datos de los estudiantes.
public class Estudiante implements Serializable {

    // La anotación @Id marca el campo como la clave primaria de la entidad.
    // @GeneratedValue indica que el valor de id se generará automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // La anotación @Column especifica propiedades de la columna en la tabla de la base de datos,
    // en este caso, limitando la longitud de la columna 'nombre' a 100 caracteres.
    @Column(length = 100)
    private String nombre;
    private int edad;
    private String carrera;
    private String universidad;
    private double promedio;

    // Serializable es utilizado para la serialización de la entidad, con un serialVersionUID para asegurar la compatibilidad
    // entre versiones diferentes de la clase.
    private static final long serialVersionUID=1L;

    // Getters y setters para acceder y modificar los campos de la clase.
    public long getId(){return id;}

    public void setId(long id){this.id = id;}

    public String getNombre(){return nombre;}

    public void setNombre(String nombre){this.nombre = nombre;}

    public int getEdad(){return edad;}

    public void setEdad(Integer edad){this.edad = edad;}

    public String getCarrera(){return carrera;}

    public void setCarrera(String carrera){this.carrera = carrera;}

    public String getUniversidad(){return universidad;}

    public void setUniversidad(String universidad){this.universidad = universidad;}

    public double getPromedio(){return promedio;}

    public void setPromedio(Double promedio){this.promedio = promedio;}

}

