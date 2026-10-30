/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrointegrantes.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import registrointegrantes.model.Integrante;
import registrointegrantes.view.FormularioIntegrante;

/**
 * Controlador encargado de gestionar el registro de integrantes.
 *
 * @author Ana Villalobos
 * @version 1.0
 */
public class IntegranteController {

    // Lista donde se almacenan los integrantes registrados.
    private ArrayList<Integrante> listaIntegrantes;
    // Referencia a la vista.
    private FormularioIntegrante vista;

    public IntegranteController(FormularioIntegrante vista) {
        this.vista = vista;
        this.listaIntegrantes = new ArrayList<>();

        // Asociar eventos de los botones.
        vista.agregarEventoRegistrar(e -> registrarIntegrante());
        vista.agregarEventoConsultar(e -> consultarIntegrantes());
        vista.agregarEventoLimpiar(e -> vista.limpiarCampos());
    }

    public void registrarIntegrante() {
        String nombres = vista.getNombres();
        String apellidos = vista.getApellidos();
        String repositorio = vista.getRepositorio();
        String tipoEstudiante = vista.getTipoEstudiante();
        String proyectoEducativo = vista.getProyectoEducativo();

        // Validar campos obligatorios.
        if (nombres.isEmpty() || apellidos.isEmpty() || repositorio.isEmpty() || tipoEstudiante == null || proyectoEducativo == null || proyectoEducativo.equals("Seleccione un proyecto")) {
            vista.mostrarMensaje("Por favor, complete todos los campos.");
            return;
        }

        // Validar URL del repositorio.
        if (!validarURL(repositorio)) {
            vista.mostrarMensaje("Ingrese una URL valida de GitHub.");
            return;
        }
        // Crear y almacenar el integrante.
        Integrante integrante = new Integrante( nombres, apellidos, repositorio, tipoEstudiante, proyectoEducativo);

        listaIntegrantes.add(integrante);
        vista.mostrarMensaje("Integrante registrado correctamente!");
        vista.limpiarCampos();
    }

    /**
     * Comprueba que la dirección corresponda a un repositorio de GitHub.
     * @param url dirección ingresada.
     * @return true si la URL tiene el formato esperado.
     */
    private boolean validarURL(String url) {
        try {
             // Limpia los espacios en blanco y convierte el texto en un objeto URL/URI 
            URI uri = new URI(url.trim());
            String ruta = uri.getPath();
            /* 1. Que empiece con http o https
            2. Que la web sea exactamente github.com
            3. Que la ruta tenga el formato "usuario/proyecto"
            */
            return ("https".equalsIgnoreCase(uri.getScheme())|| "http".equalsIgnoreCase(uri.getScheme()))   && "github.com".equalsIgnoreCase(uri.getHost())  && ruta != null  && ruta.matches("/[^/]+/[^/]+/?");
       
        } catch (URISyntaxException e) {
            return false;
        }
    }


    public void consultarIntegrantes() {
        if (listaIntegrantes.isEmpty()) {
            vista.mostrarMensaje("No hay integrantes registrados.");
            return;
        }
        //Hace una cuadricula con tantas filas como integrantes haya en la lista y con 5 columnas
        Object[][] datos = new Object[listaIntegrantes.size()][5];

        for (int i = 0; i < listaIntegrantes.size(); i++) {

            Integrante integrante = listaIntegrantes.get(i);
            datos[i][0] = integrante.getNombres();
            datos[i][1] = integrante.getApellidos();
            datos[i][2] = integrante.getRepositorio();
            datos[i][3] = integrante.getTipoEstudiante();
            datos[i][4] = integrante.getProyectoEducativo();
        }
        vista.actualizarTabla(datos);
    }

    /**
     * Inicia la aplicación mostrando la ventana.
     */
    public void iniciar() {
        vista.iniciar();
    }
}

