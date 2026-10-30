# REGISTRO-INTEGRANTES
<div align="center">

<img src="Imagenes/Logisticajpg.jpg" width="80%" style="max-width: 800px;" alt="JALogistica Header"/>

# Aplicación de Registro de Integrantes
Formulario en Java Swing con arquitectura MVC

**Programación Avanzada** · Universidad Distrital Francisco José de Caldas · Octubre 2026

</div>

<div align="center">
  <img src="https://img.shields.io/badge/Plataforma-Java-orange?style=flat-square" alt="Java"/>
  <img src="https://img.shields.io/badge/Arquitectura-MVC-2196F3?style=flat-square" alt="MVC"/>
  <img src="https://img.shields.io/badge/Interfaz-Consola-4CAF50?style=flat-square" alt="Java Swing"/>
</div>

---

## 👥 Desarrollador

| Nombre | Código |
| :--- | :---: |
| Ana Sofía Villalobos Pérez | 20242020063 |

---

## 📌 Enunciado

> **Un docente de programación avanzada de otro país requiere un sistema de información para registrar a las personas que participan en sus proyectos educativos. Usted debe desarrollar una aplicación de escritorio en Java que permita capturar la información de cada integrante, validar los datos, almacenar los registros en memoria y consultar los integrantes registrados.
La solución debe aplicar la arquitectura MVC, separando la representación de los datos, la interfaz gráfica y la lógica que coordina las acciones del usuario.**

---

## 🏗️ Objetivo

Desarrollar una aplicación de escritorio que permita registrar y consultar integrantes de un proyecto educativo mediante una interfaz gráfica, facilitando la gestión de su información personal, repositorio de GitHub, tipo de estudiante y proyecto educativo.

---
### Model

Contiene las clases que representan la de los integrantes del sistema:
**Integrante**
El Modelo se encarga de representar los datos y las características de cada integrante:
- `Nombres`
- `Apellidos`
- `Repositorio de GitHub`
- `Tipo de estudiante`
- `Proyecto educativo`

### View

La clase FormularioIntegrante es responsable de la interacción con el usuario mediante una interfaz gráfica desarrollada con Java Swing.

Permite:

- Mostrar el formulario de registro.
- Solicitar nombres y apellidos.
- Ingresar la URL del repositorio de GitHub.
- Seleccionar el tipo de estudiante (Nuevo o Antiguo) y el proyecto educativo.
- Mostrar los integrantes registrados mediante una tabla.
- Mostrar mensajes de información y validación.
- Limpiar los campos del formulario.

La Vista **no accede directamente al Modelo**. Proporciona métodos para obtener los datos ingresados y gestionar los eventos de los componentes gráficos.

### Controller

La clase IntegranteController recibe las acciones del usuario y coordina la interacción entre la Vista y el Modelo.

Se encarga de:

- Gestionar el registro de integrantes.
- Validar que los campos estén completos.
- Verificar que la URL del repositorio de GitHub tenga un formato válido.
- Almacenar los registros en un ArrayList.
- Consultar los integrantes registrados.
- Actualizar la tabla de la Vista.
- Gestionar los eventos de los botones Registrar, Consultar y Limpiar.

El Controlador utiliza la Vista y el Modelo, manteniendo separadas sus responsabilidades.

### Main

**Main**

Es la clase principal de la aplicación y se encarga de iniciar su ejecución.

Sus responsabilidades son:

- Crear una instancia de FormularioIntegrante.
- Instanciar IntegranteController y asociarlo con la Vista.
- Iniciar la aplicación mediante el método iniciar() del Controlador.

La clase Main funciona como punto de entrada del programa y no contiene la lógica del registro de integrantes.

---

## ⚙️ Tecnología y Requisitos

| Ítem | Detalle |
| :---: | :--- |
| **Lenguaje** | Java ( JDK 25) |
| **Paradigma** | Programación Orientada a Objetos (POO) |
| **Arquitectura** | Modelo-Vista-Controlador (MVC) |
| **Interfaz** | Java Swing |
| **Eventos** | `ActionListener` |
| **Colecciones** | `ArrayList` |
| **IDE** | Apache NetBeans (IDE 28) |

- Tener instalado el JDK 25 de Java.
- Contar con Apache NetBeans IDE 28 o un entorno compatible con proyectos Java Ant.
- Tener los archivos del proyecto descargados en el computador.

---

## ⚙️ Funcionalidades del Sistema

| Funcionalidad | Descripción |
| :--- | :--- |
| 👤 Registrar integrante | Permite registrar un integrante con sus datos personales y académicos |
| 📝 Ingresar nombres | Permite ingresar los nombres del integrante |
| 📝 Ingresar apellidos | Permite ingresar los apellidos del integrante |
| 🔗 Registrar repositorio | Permite ingresar la URL del repositorio de GitHub |
| 🎓 Seleccionar tipo de estudiante | Permite indicar si el estudiante es Nuevo o Antiguo |
| 📚 Seleccionar proyecto educativo | Permite elegir el proyecto educativo correspondiente |
| 📋 Consultar integrantes | Muestra los integrantes registrados mediante una tabla |
| 🧹 Limpiar formulario | Permite borrar la información ingresada en los campos |
| ✅ Validar información | Verifica que los campos obligatorios estén completos |
| 🔍 Validar URL | Comprueba que la dirección ingresada corresponda a un repositorio de GitHub con formato válido |

---

## 📏 Validaciones

El sistema incorpora validaciones para evitar datos incorrectos o incompletos.

| Dato | Validación |
| :--- | :--- |
| Nombres | El campo es obligatorio |
| Apellidos | El campo es obligatorio |
| Repositorio GitHub | El campo es obligatorio y debe contener una URL válida de GitHub |
| Tipo de estudiante | Debe seleccionar Nuevo o Antiguo |
| Proyecto educativo | Debe seleccionar un proyecto de la lista |

Si alguno de los campos obligatorios está vacío o la URL del repositorio no cumple con el formato establecido, el sistema informa al usuario mediante un mensaje de validación.

---

## 🗺️ Flujo General del Sistema
```text
                  INICIO
                     │
                     ▼
          ┌─────────────────────┐
          │   Main.java         │
          │ Inicializar sistema │
          └──────────┬──────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │ FormularioIntegrante│
          │   Mostrar interfaz  │
          └──────────┬──────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │  Menú de acciones   │
          │ Registrar / Consultar│
          │       / Limpiar     │
          └──────────┬──────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │ Registrar integrante│
          └──────────┬──────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │ Obtener información │
          │    del formulario   │
          └──────────┬──────────┘
                     │
                     ▼
          ┌─────────────────────┐
          │ Validar información │
          └──────────┬──────────┘
                     │
              ┌──────┴──────┐
              ▼             ▼
          ¿Válidos?       ¿Incorrectos?
              │             │
              ▼             ▼
       Crear objeto    Mostrar mensaje
        Integrante     de validación
              │             │
              ▼             │
       Guardar en       Volver al
        ArrayList       formulario
              │
              ▼
       Mostrar confirmación
              │
              ▼
             FIN
```
---

## 📁 Estructura del Proyecto

```text
RegistroIntegrantes/
├── nbproject/
├── src/
│   └── registrointegrantes/
│       ├── model/
│       │   └── Integrante.java
│       ├── view/
│       │   └── FormularioIntegrante.java
│       ├── controller/
│       │   └── IntegranteController.java
│       └── Main.java
│
├── README.md
├── build.xml
└── manifest.mf
```

---

## 🚀 Pasos de ejecución
Puedes descargar la carpeta Zip separada o en su defecto el repositorio completo

1. Descargar o clonar el repositorio **RegistroIntegrantes**.
2. Descomprimir el archivo ZIP, si se descargó en ese formato.
3. Abrir Apache NetBeans IDE.
4. Seleccionar la opción **File → Open Project**.
5. Buscar y seleccionar la carpeta principal `RegistroIntegrantes`.
6. Verificar que los paquetes `model`, `view` y `controller` estén correctamente organizados dentro de `registrointegrantes`.
7. Comprobar que el proyecto tenga configurado el JDK compatible.
8. Abrir la clase `Main.java`.
9. Ejecutar el método `main()`.
10. El programa iniciará el `IntegranteController`, que gestionará la interacción entre la Vista y el Modelo.
11. Utilizar el formulario para registrar integrantes, consultar los registros y limpiar los campos.

---

## 📋 Capturas de pantalla y Pruebas

Muestra la aplicación recién iniciada, con los campos vacíos.

<div align="center">

### Figura 1. Formulario principal Vacio
<img src="Diagramas UML - PAC MAN/Diagrama de Clases - PAC MAN.png" >
</div>

Muestra el formulario con todos los campos diligenciados y un mensaje de confirmación del registro.

<div align="center">

### Figura 2. Registro de un integrante
<img src="Diagramas UML - PAC MAN/Diagrama de Clases - PAC MAN.png" >
</div>

Muestra la tabla con uno o varios integrantes registrados. Esta captura demuestra que la información se almacena y se consulta correctamente

<div align="center">

### Figura 3. Consulta de integrantes
<img src="Diagramas UML - PAC MAN/Diagrama de Clases - PAC MAN.png" >
</div>

Muestra un ejemplo de mensaje cuando intentas registrar información incompleta o una URL inválida de GitHub.

<div align="center">

### Figura 4. Validaciones 
<img src="Diagramas UML - PAC MAN/Diagrama de Clases - PAC MAN.png" >
</div>

---
**Universidad Distrital Francisco José De Caldas** Programación Avanzada · Octubre 2026
