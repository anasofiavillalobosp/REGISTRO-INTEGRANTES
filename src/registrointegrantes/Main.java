/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrointegrantes;

import javax.swing.SwingUtilities;
import registrointegrantes.controller.IntegranteController;
import registrointegrantes.view.FormularioIntegrante;

/**
 * Clase principal de la aplicación Registro de Integrantes.
 * Se encarga de iniciar la ejecución del programa.
 *
 * @author Ana Villalobos
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que inicia la aplicación.
     * Utiliza SwingUtilities.invokeLater() para garantizar
     * que la interfaz gráfica se ejecute y abra la ventana de forma segura sin congelar la pantalla.
     * @param args argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            FormularioIntegrante vista = new FormularioIntegrante();
            IntegranteController controlador =new IntegranteController(vista);

            controlador.iniciar();
        });
    }
}
