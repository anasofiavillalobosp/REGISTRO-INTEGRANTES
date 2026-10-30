/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrointegrantes.model;

/**
 *Representa a una persona que participa en un proyecto educativo.
 * Almacena sus datos personales y académicos para poder luego registralo en el formulario.
 *
 * @author Ana Villalobos
 * @version 1.0
 */
public class Integrante {
    
    private String nombres;
    private String apellidos;
    private String repositorio;
    private String tipoEstudiante;
    private String proyectoEducativo;

    /**
     * Construye un integrante con toda su información.
     * @param nombres nombres del integrante.
     * @param apellidos apellidos del integrante.
     * @param repositorio URL del repositorio GitHub.
     * @param tipoEstudiante tipo de estudiante: Nuevo o Antiguo.
     * @param proyectoEducativo programa académico seleccionado.
     */
    public Integrante(String nombres, String apellidos, String repositorio, String tipoEstudiante, String proyectoEducativo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.repositorio = repositorio;
        this.tipoEstudiante = tipoEstudiante;
        this.proyectoEducativo = proyectoEducativo;
    }

//Aqui tenemos los getters and setters para poder obtener y modificar los datos guardados
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }

    public String getTipoEstudiante() {
        return tipoEstudiante;
    }

    public void setTipoEstudiante(String tipoEstudiante) {
        this.tipoEstudiante = tipoEstudiante;
    }

    public String getProyectoEducativo() {
        return proyectoEducativo;
    }

    public void setProyectoEducativo(String proyectoEducativo) {
        this.proyectoEducativo = proyectoEducativo;
    }

    /**
     * @return nombres y apellidos del integrante con una cadena de texto.
     */
    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
}
    

