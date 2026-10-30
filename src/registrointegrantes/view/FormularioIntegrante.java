/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrointegrantes.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Construye la interfaz gráfica del sistema de registro(el formulario de integrantes solicitado)
 * de integrantes utilizando Java Swing.
 *
 * Se encarga de presentar los componentes visuales,
 * obtener los datos ingresados y mostrar los registros.
 *
 * @author Ana Villalobos
 * @version 1.0
 */
public class FormularioIntegrante extends JFrame {

    /**
    * Colores de la interfaz de usuario.
    * Se usa 'static' para ahorrar memoria (existe una sola copia en toda mi app)
    * y 'final' para que no se puedan cambiar por error en alguna parte de la vista.
    */
    private static final Color AZUL = new Color(25, 85, 160);
    private static final Color AZUL_CLARO = new Color(225, 239, 255);
    private static final Color BLANCO = Color.WHITE;

    // Cajas de texto para guardar la informacion suministrada por el usuario
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtRepositorio;

    // Componentes para seleccionar el tipo de estudiante.
    private JRadioButton rbNuevo;
    private JRadioButton rbAntiguo;
    private ButtonGroup grupoTipo;

    //Desplegable de proyectos educativos.
    private JComboBox<String> cbProyecto;

    // Botones de acciones.
    private JButton btnRegistrar;
    private JButton btnConsultar;
    private JButton btnLimpiar;

    // Tabla y modelo para visualizar los registros del formulario
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    
    public FormularioIntegrante() {
        setTitle("Sistema de Registro de Integrantes");
        setSize(850, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Centra la ventana con respecto a la pantalla donde se ejecute por el null
        setLocationRelativeTo(null);
        //Bloquea el tamaño de la ventana para que el usuario no pueda estirarla ni maximizarla
        setResizable(false);

        // Panel principal de la ventana.
        JPanel principal = new JPanel(new BorderLayout(15, 15));
        principal.setBackground(AZUL_CLARO);
        principal.setBorder( BorderFactory.createEmptyBorder(20, 25, 20, 25) );//Una margen

        // Construcción de los componentes principales.
        crearEncabezado(principal);
        crearContenido(principal);
        add(principal);
    }

    /**
     * Construye el encabezado azul de la aplicación.
     * @param principal panel principal donde se agrega el encabezado.
     */
    private void crearEncabezado(JPanel principal) {
        JLabel titulo = new JLabel("REGISTRO DE INTEGRANTES");
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 23));
        titulo.setForeground(BLANCO);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(AZUL);
        encabezado.setBorder( BorderFactory.createEmptyBorder(20, 10, 20, 10));

        encabezado.add(titulo, BorderLayout.CENTER);
        principal.add(encabezado, BorderLayout.NORTH);
    }

    /**
     * Construye el formulario, los botones y la tabla.
     *
     * @param principal panel principal de la ventana.
     */
    private void crearContenido(JPanel principal) {
        JPanel formulario = crearFormulario();

        // Panel que contiene las acciones del usuario.
        JPanel centro = new JPanel(new BorderLayout(10, 10));// 10 pixeles de distancia
        centro.setBackground(AZUL_CLARO);

        centro.add(formulario, BorderLayout.NORTH);
        centro.add(crearTabla(), BorderLayout.CENTER);

        principal.add(centro, BorderLayout.CENTER);
    }

    /**
     * Crea los campos de entrada y los botones del formulario.
     * @return panel que contiene los componentes del formulario.
     */
    private JPanel crearFormulario() {
        // Panel del formulario
        JPanel formulario = new JPanel(new BorderLayout(10, 10));
        formulario.setBackground(BLANCO);       
        // Espacio interno del formulario
        formulario.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // Inicialización de los campos de texto.
        txtNombres = new JTextField(20);
        txtApellidos = new JTextField(20);
        txtRepositorio = new JTextField(20);

        // Inicialización de las opciones de estudiante.
        rbNuevo = new JRadioButton("Nuevo");
        rbAntiguo = new JRadioButton("Antiguo");
        rbNuevo.setBackground(BLANCO);
        rbAntiguo.setBackground(BLANCO);

        // ButtonGroup garantiza una selección única(nuevo o antiguo).
        grupoTipo = new ButtonGroup();
        grupoTipo.add(rbNuevo);
        grupoTipo.add(rbAntiguo);

        JPanel panelRadio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRadio.setBackground(BLANCO);
        panelRadio.add(rbNuevo);
        panelRadio.add(rbAntiguo);

        // Opciones de proyectos educativos.
        cbProyecto = new JComboBox<>(new String[]{
            "Seleccione un proyecto",
            "Ingeniería de Sistemas",
            "Ingeniería Electrónica",
            "Ingeniería Industrial",
            "Ingeniería Civil"
        });

        // Organización de los campos en el formulario
        JPanel campos = new JPanel(new GridLayout(5, 2, 8, 8));
        campos.setBackground(BLANCO);

        campos.add(new JLabel("Nombres:"));
        campos.add(txtNombres);
        campos.add(new JLabel("Apellidos:"));
        campos.add(txtApellidos);
        campos.add(new JLabel("Repositorio GitHub:"));
        campos.add(txtRepositorio);
        campos.add(new JLabel("Tipo de estudiante:"));
        campos.add(panelRadio);
        campos.add(new JLabel("Proyecto educativo:"));
        campos.add(cbProyecto);


        // Inicialización de los botones.
        btnRegistrar = new JButton("Registrar");
        btnConsultar = new JButton("Consultar");
        btnLimpiar = new JButton("Limpiar");

        configurarBoton(btnRegistrar, AZUL);
        configurarBoton(btnConsultar, new Color(40, 120, 190));
        configurarBoton(btnLimpiar, new Color(100, 110, 125));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotones.setBackground(BLANCO);// creo el panel con unas mediadas y estilo
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnLimpiar);

        // Agregar los dos paneles al formulario.
        formulario.add(campos, BorderLayout.CENTER);
        formulario.add(panelBotones, BorderLayout.SOUTH);

        return formulario;
    }


    /**
     * Configura el aspecto visual de un botón.
     *
     * @param boton botón que se desea configurar.
     * @param color color de fondo del botón.
     */
    private void configurarBoton(JButton boton, Color color) {
        boton.setBackground(color);
        boton.setForeground(BLANCO);
        boton.setFont(new Font("Times New Roman", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(115, 35));
    }

    /**
     * Construye la tabla donde se mostraran los integrantes.
     * (tipo tabla de Excel)
     * @return panel desplazable que contiene la tabla.
     */
    private JScrollPane crearTabla() {
        String[] columnas = { "Nombres", "Apellidos", "Repositorio", "Tipo", "Proyecto"};

        // Evita que el usuario modifique directamente los registros.
        modeloTabla = new DefaultTableModel(columnas, 0) {
            // Al retornar false, el usuario no puede escribir en la tabla
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tabla = new JTable(modeloTabla);
        tabla.setRowHeight(25);

        tabla.getTableHeader().setBackground(AZUL);
        tabla.getTableHeader().setForeground(BLANCO);
        tabla.getTableHeader().setFont( new Font("Times New Roman", Font.BOLD, 12));
        //Coloca la tabla dentro de un panel con barras de desplazamiento
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder( BorderFactory.createTitledBorder("Integrantes registrados") );

        return scroll;
    }

    // MÉTODOS DE ACCESO A LOS DATOS DEL FORMULARIO.

    public String getNombres() {
        return txtNombres.getText().trim();
    }

    public String getApellidos() {
        return txtApellidos.getText().trim();
    }

    public String getRepositorio() {
        return txtRepositorio.getText().trim();
    }

    public String getTipoEstudiante() {
        if (rbNuevo.isSelected()) {
            return "Nuevo";
        }
        if (rbAntiguo.isSelected()) {
            return "Antiguo";
        }
        return "";
    }

    public String getProyectoEducativo() {
        if (cbProyecto.getSelectedIndex() == 0) {
            return "";
        }
        return cbProyecto.getSelectedItem().toString();
    }

    // MÉTODOS PARA LA COMUNICACIÓN CON EL CONTROLADOR.
    public void agregarEventoRegistrar(ActionListener evento) {
        btnRegistrar.addActionListener(evento);//Asocia un evento al botón Registrar.
    }

    public void agregarEventoConsultar(ActionListener evento) {
        btnConsultar.addActionListener(evento);//Asocia un evento al botón Consultar.
    }

    public void agregarEventoLimpiar(ActionListener evento) {
        btnLimpiar.addActionListener(evento);//Asocia un evento al botón Limpiar.
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    //Limpia los campos de texto y las selecciones del formulario.
    public void limpiarCampos() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtRepositorio.setText("");

        grupoTipo.clearSelection();
        cbProyecto.setSelectedIndex(0);
    }

    /**
    * Actualiza la tabla con los datos recibidos del controlador.
    * @param datos información de los integrantes.
    */
    public void actualizarTabla(Object[][] datos) {

        modeloTabla.setRowCount(0);

        for (Object[] fila : datos) {
            modeloTabla.addRow(fila);
        }
    }
    //Hace visible la ventana principal.
    public void iniciar() {
        setVisible(true);
    }
}


