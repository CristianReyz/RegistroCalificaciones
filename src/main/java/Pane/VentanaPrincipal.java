package Pane;

import Pane.Alumnos.*;
import Pane.Evaluaciones.ConsultarEvaluacion;
import Pane.Evaluaciones.CrearEvaluacion;
import Pane.Evaluaciones.ModificarEvaluacion;
import Pane.Grupos.*;
import Pane.Materias.ConsultarMateria;
import Pane.Materias.CrearMateria;
import Pane.Materias.ModificarMateria;
import Pane.Profesores.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

// aquí solo se manejan redirecciones, se declaran y se configuran los paneles y botones globales

public class VentanaPrincipal extends JFrame {

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();

    //botones superiores
    JButton botonAlumnos = new JButton("Alumnos");
    JButton botonProfesores = new JButton("Profesores");
    JButton botonGrupos = new JButton("Grupos");
    JButton botonMaterias = new JButton("Materias");
    JButton botonEvaluaciones = new JButton("Evaluaciones");
    JButton botonCerrarSesion = new JButton("Cerrar Sesion");

    //botones inferiores

    //redireccion a paneles de modificación
    JButton botonModificarUsuario = new JButton("Modificar Miembro");
    JButton botonModificarGrupo = new JButton("Modificar Grupo");
    JButton botonModificarMateria = new JButton("Modificar Materia");
    JButton botonModificarEvaluacion = new JButton("Modificar Evaluacion");

    //redirección a paneles de crear
    JButton botonCrearNuevoIntegrante = new JButton("Inscribir");
    JButton botonCrearNuevoGrupo = new JButton("Crear Grupo");
    JButton botonCrearNuevaMateria = new JButton("Crear Materia");
    JButton botonCrearNuevaEvaluacion = new JButton("Registrar Evaluacion");


    //etiquetas para que no se vean espacios en blanco haha
    JLabel vacio = new JLabel(" ");
    JLabel vacio2 = new JLabel(" ");
    JLabel vacio3 = new JLabel(" ");
    JLabel vacio4 = new JLabel(" ");

    //se declaran los paneles aquí para que sean globales y puedan ser manipulados fuera del constructor
    ConsultarAlumno consultarAlumnoPanel;
    ConsultarProfesor consultarProfesorPanel;
    CrearUsuario crearUsuarioPanel;
    ModificarAlumno modificarAlumnoPanel;
    ModificarProfesor modificarProfesorPanel;
    CrearGrupo crearGrupoPanel;
    ConsultarGrupo consultarGrupoPanel;
    ModificarGrupo modificarGrupoPanel;
    ConsultarMateria consultarMateriaPanel;
    CrearMateria crearMateriaPanel;
    ModificarMateria modificarMateriaPanel;
    ConsultarEvaluacion consultarEvaluacionPanel;
    CrearEvaluacion crearEvaluacionPanel;
    ModificarEvaluacion modificarEvaluacionPanel;

    public VentanaPrincipal(Connection conexion) {

        //aqui se inicializan los paneles para que la conexión que se recibe desde la ventana de inicio sea la correcta
        consultarAlumnoPanel = new ConsultarAlumno(conexion);
        consultarProfesorPanel = new ConsultarProfesor(conexion);
        crearUsuarioPanel = new CrearUsuario(conexion);
        modificarAlumnoPanel = new ModificarAlumno(conexion);
        modificarProfesorPanel = new ModificarProfesor(conexion);
        crearGrupoPanel = new CrearGrupo(conexion);
        consultarGrupoPanel = new ConsultarGrupo(conexion);
        modificarGrupoPanel = new ModificarGrupo(conexion);
        consultarMateriaPanel = new ConsultarMateria(conexion);
        crearMateriaPanel = new CrearMateria(conexion);
        modificarMateriaPanel = new ModificarMateria(conexion);
        consultarEvaluacionPanel = new ConsultarEvaluacion(conexion);
        crearEvaluacionPanel = new CrearEvaluacion(conexion);
        modificarEvaluacionPanel = new ModificarEvaluacion(conexion);

        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Control Escolar");
        this.setLayout(layout);

        configuracionPaneles();

        configuracionBotonesSuperiores();

        configuracionBotonesInferiores();

        configuracionEtiquetas();

        eventos();
    }

    private void configuracionPaneles(){
        //config de paneles
        config.gridx=0;
        config.gridy=1;
        config.gridwidth=6;
        config.gridheight=3;
        config.weightx=1.0;
        config.weighty=1.0;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        this.add(consultarAlumnoPanel,config);
        this.add(consultarProfesorPanel,config);
        this.add(crearUsuarioPanel,config);
        this.add(modificarAlumnoPanel,config);
        this.add(modificarProfesorPanel,config);
        this.add(crearGrupoPanel,config);
        this.add(consultarGrupoPanel,config);
        this.add(modificarGrupoPanel,config);
        this.add(consultarMateriaPanel,config);
        this.add(crearMateriaPanel,config);
        this.add(modificarMateriaPanel,config);
        this.add(consultarEvaluacionPanel,config);
        this.add(crearEvaluacionPanel,config);
        this.add(modificarEvaluacionPanel,config);

        consultarProfesorPanel.setVisible(false);
        crearUsuarioPanel.setVisible(false);
        modificarAlumnoPanel.setVisible(false);
        modificarProfesorPanel.setVisible(false);
        crearGrupoPanel.setVisible(false);
        consultarGrupoPanel.setVisible(false);
        modificarGrupoPanel.setVisible(false);
        consultarMateriaPanel.setVisible(false);
        crearMateriaPanel.setVisible(false);
        modificarMateriaPanel.setVisible(false);
        consultarEvaluacionPanel.setVisible(false);
        crearEvaluacionPanel.setVisible(false);
        modificarEvaluacionPanel.setVisible(false);

    }

    private void configuracionBotonesSuperiores() {
        config.gridx=0;
        config.gridy=0;
        config.gridwidth=1;
        config.gridheight=1;
        config.ipadx=100;
        config.ipady=10;
        config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        botonAlumnos.setBackground(Color.DARK_GRAY);
        botonAlumnos.setForeground(Color.BLACK);
        this.add(botonAlumnos, config);

        config.gridx=1;
        config.gridy=0;
        config.gridwidth=1;
        config.gridheight=1;
        config.ipadx=100;
        config.ipady=10;
        config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        botonProfesores.setBackground(Color.DARK_GRAY);
        botonProfesores.setForeground(Color.BLACK);
        this.add(botonProfesores, config);

        config.gridx=2;
        config.gridy=0;
        config.gridwidth=1;
        config.gridheight=1;
        config.ipadx=100;
        config.ipady=10;
        config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        botonGrupos.setBackground(Color.DARK_GRAY);
        botonGrupos.setForeground(Color.BLACK);
        this.add(botonGrupos, config);

        config.gridx=3;
        config.gridy=0;
        config.gridwidth=1;
        config.gridheight=1;
        config.ipadx=100;
        config.ipady=10;
        config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        botonMaterias.setBackground(Color.DARK_GRAY);
        botonMaterias.setForeground(Color.BLACK);
        this.add(botonMaterias, config);

        config.gridx=4;
        config.gridy=0;
        config.gridwidth=1;
        config.gridheight=1;
        config.ipadx=100;
        config.ipady=10;
        config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        botonEvaluaciones.setBackground(Color.DARK_GRAY);
        botonEvaluaciones.setForeground(Color.BLACK);
        this.add(botonEvaluaciones, config);

        config.gridx=5;
        config.gridy=0;
        config.gridwidth=1;
        config.gridheight=1;
        config.ipadx=100;
        config.ipady=10;
        config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER;
        config.fill= GridBagConstraints.BOTH;
        botonCerrarSesion.setBackground(Color.DARK_GRAY);
        botonCerrarSesion.setForeground(Color.BLACK);
        this.add(botonCerrarSesion, config);
    }

    private void configuracionEtiquetas(){
        config.gridx=0; config.gridy=4; config.gridwidth=1; config.gridheight=2; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        vacio.setBackground(Color.DARK_GRAY); vacio.setOpaque(true); vacio.setForeground(Color.BLACK);
        this.add(vacio, config);


        config.gridx=1; config.gridy=4; config.gridwidth=1; config.gridheight=2; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        vacio2.setBackground(Color.DARK_GRAY); vacio2.setOpaque(true); vacio2.setForeground(Color.BLACK);
        this.add(vacio2, config);


        config.gridx=2; config.gridy=4; config.gridwidth=1; config.gridheight=2; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        vacio3.setBackground(Color.DARK_GRAY); vacio3.setOpaque(true); vacio3.setForeground(Color.BLACK);
        this.add(vacio3, config);


        config.gridx=3; config.gridy=4; config.gridwidth=1; config.gridheight=2; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        vacio4.setBackground(Color.DARK_GRAY); vacio4.setOpaque(true); vacio4.setForeground(Color.BLACK);
        this.add(vacio4, config);

        vacio.setVisible(false);
        vacio2.setVisible(false);

    }

    private void configuracionBotonesInferiores(){
        config.gridx=1; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonModificarUsuario.setBackground(Color.DARK_GRAY); botonModificarUsuario.setForeground(Color.BLACK);
        this.add(botonModificarUsuario, config);

        config.gridx=1; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonModificarGrupo.setBackground(Color.DARK_GRAY); botonModificarGrupo.setForeground(Color.BLACK);
        this.add(botonModificarGrupo, config);

        config.gridx=1; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonModificarMateria.setBackground(Color.DARK_GRAY); botonModificarMateria.setForeground(Color.BLACK);
        this.add(botonModificarMateria, config);

        config.gridx=1; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonModificarEvaluacion.setBackground(Color.DARK_GRAY); botonModificarEvaluacion.setForeground(Color.BLACK);
        this.add(botonModificarEvaluacion, config);


        config.gridx=0; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrearNuevoIntegrante.setBackground(Color.DARK_GRAY); botonCrearNuevoIntegrante.setForeground(Color.BLACK);
        this.add(botonCrearNuevoIntegrante, config);

        config.gridx=0; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrearNuevoGrupo.setBackground(Color.DARK_GRAY); botonCrearNuevoGrupo.setForeground(Color.BLACK);
        this.add(botonCrearNuevoGrupo, config);

        config.gridx=0; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrearNuevaMateria.setBackground(Color.DARK_GRAY); botonCrearNuevaMateria.setForeground(Color.BLACK);
        this.add(botonCrearNuevaMateria, config);

        config.gridx=0; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrearNuevaEvaluacion.setBackground(Color.DARK_GRAY); botonCrearNuevaEvaluacion.setForeground(Color.BLACK);
        this.add(botonCrearNuevaEvaluacion, config);

        botonCrearNuevoGrupo.setVisible(false);
        botonModificarGrupo.setVisible(false);
        botonCrearNuevaMateria.setVisible(false);
        botonModificarMateria.setVisible(false);
        botonCrearNuevaEvaluacion.setVisible(false);
        botonModificarEvaluacion.setVisible(false);
    }

    private void eventos(){
        //eventos de botones superiores
        botonCerrarSesion.addActionListener(v -> this.dispose());
        botonProfesores.addActionListener(v -> cargarInterfazInicialProfesores());
        botonAlumnos.addActionListener(v -> cargarInterfazInicialAlumnos());
        botonGrupos.addActionListener(v-> cargarInterfazInicialGrupos());
        botonMaterias.addActionListener(v-> cargarInterfazInicialMaterias());
        botonEvaluaciones.addActionListener(v-> cargarInterfazInicialEvaluaciones());

        //eventos de botones inferiores
        botonCrearNuevoIntegrante.addActionListener(v-> cargarPanelCrearNuevoIntegrante());
        botonModificarUsuario.addActionListener(v-> cargarPanelModificarUsuario());
        botonCrearNuevoGrupo.addActionListener(v-> cargarPanelCrearNuevoGrupo());
        botonModificarGrupo.addActionListener(v-> cargarPanelModificarGrupo());
        botonCrearNuevaMateria.addActionListener(v->cargarPanelCrearNuevaMateria());
        botonModificarMateria.addActionListener(v->cargarPanelModificarMateria());
        botonCrearNuevaEvaluacion.addActionListener(v->cargarPanelCrearNuevaEvaluacion());
        botonModificarEvaluacion.addActionListener(v->cargarPanelModificarEvaluacion());
    }

    //USUARIOS (alumnos y profesores)
    private void cargarInterfazInicialProfesores(){
        if(!consultarProfesorPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(true);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonModificarUsuario.setVisible(true);
            botonCrearNuevoIntegrante.setVisible(true);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    private void cargarInterfazInicialAlumnos(){
        if(!consultarAlumnoPanel.isVisible()){
            consultarAlumnoPanel.setVisible(true);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonModificarUsuario.setVisible(true);
            botonCrearNuevoIntegrante.setVisible(true);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    private void cargarPanelCrearNuevoIntegrante(){
        if(!crearUsuarioPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(true);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            vacio.setVisible(true);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    private void cargarPanelModificarUsuario() {
        //si el panel de modificar alumno no es visible, && el panel de consulta de alumno es visible entonces:
        if(!modificarAlumnoPanel.isVisible()&&consultarAlumnoPanel.isVisible()){
            //validar con banderas que es visible y que no
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(true);
            crearGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            modificarProfesorPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            vacio.setVisible(true);
            vacio2.setVisible(true);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);

            //en caso contrario probar con profesores ya que igualmente es de tipo usuario
        }else if(!modificarProfesorPanel.isVisible()&&consultarProfesorPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            modificarProfesorPanel.setVisible(true);
            vacio.setVisible(true);
            vacio2.setVisible(true);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);

        }
    }

    //GRUPOS

    private void cargarPanelCrearNuevoGrupo() {
        if(!crearGrupoPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(true);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            vacio.setVisible(true);
            botonCrearNuevoGrupo.setVisible(false);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    private void cargarInterfazInicialGrupos(){
        if(!consultarGrupoPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(true);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            botonModificarGrupo.setVisible(true);
            vacio.setVisible(true);
            botonCrearNuevoGrupo.setVisible(true);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    private void cargarPanelModificarGrupo() {
        if(!modificarGrupoPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(true);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            botonModificarGrupo.setVisible(false);
            vacio.setVisible(true);
            botonCrearNuevoGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    //MATERIAS

    private void cargarInterfazInicialMaterias(){
        if(!consultarMateriaPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(true);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonModificarUsuario.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(true);
            botonModificarMateria.setVisible(true);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    private void cargarPanelCrearNuevaMateria(){
        if(!crearMateriaPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(true);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonModificarUsuario.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    private void cargarPanelModificarMateria(){
        if(!modificarMateriaPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(true);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonModificarUsuario.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    //EVALUACIONES

    private void cargarInterfazInicialEvaluaciones(){
        if(!consultarEvaluacionPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(true);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(false);

            botonModificarUsuario.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(true);
            botonModificarEvaluacion.setVisible(true);
        }
    }

    private void cargarPanelCrearNuevaEvaluacion(){
        if(!crearEvaluacionPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(true);
            modificarEvaluacionPanel.setVisible(false);

            botonModificarUsuario.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }

    private void cargarPanelModificarEvaluacion(){
        if(!modificarEvaluacionPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarMateriaPanel.setVisible(false);
            crearMateriaPanel.setVisible(false);
            modificarMateriaPanel.setVisible(false);
            consultarEvaluacionPanel.setVisible(false);
            crearEvaluacionPanel.setVisible(false);
            modificarEvaluacionPanel.setVisible(true);

            botonModificarUsuario.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarGrupo.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
            botonCrearNuevaMateria.setVisible(false);
            botonModificarMateria.setVisible(false);
            botonCrearNuevaEvaluacion.setVisible(false);
            botonModificarEvaluacion.setVisible(false);
        }
    }


}
