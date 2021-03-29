package Pane;

import Alumnos.AlumnoService;
import Grupos.GrupoService;
import Pane.Alumnos.ConsultarAlumno;
import Pane.Alumnos.ModificarAlumno;
import Pane.Grupos.ConsultarGrupo;
import Pane.Grupos.CrearGrupo;
import Pane.Grupos.ModificarGrupo;
import Pane.Profesores.ConsultarProfesor;
import Pane.Profesores.ModificarProfesor;
import Profesores.ProfesoresService;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

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
    JButton botonModificarUsuario = new JButton("Modificar Miembro");
    JButton botonModificarGrupo = new JButton("Modificar Grupo");
    JButton botonCrearNuevoIntegrante = new JButton("Inscribir");
    JButton botonCrearUsuarioLogico = new JButton("Confirmar");
    JButton botonCrearGrupoLogico = new JButton("Confirmar");
    JButton botonCrearNuevoGrupo = new JButton("Crear Grupo");

    JLabel vacio = new JLabel(" ");
    JLabel vacio2 = new JLabel(" ");
    JLabel vacio3 = new JLabel(" ");
    JLabel vacio4 = new JLabel(" ");

    private final Connection conexion;

    ConsultarAlumno consultarAlumnoPanel;
    ConsultarProfesor consultarProfesorPanel;
    CrearUsuario crearUsuarioPanel;
    ModificarAlumno modificarAlumnoPanel;
    ModificarProfesor modificarProfesorPanel;
    CrearGrupo crearGrupoPanel;
    ConsultarGrupo consultarGrupoPanel;
    ModificarGrupo modificarGrupoPanel;

    public VentanaPrincipal(Connection conexion) {

        consultarAlumnoPanel = new ConsultarAlumno(conexion);
        consultarProfesorPanel = new ConsultarProfesor(conexion);
        crearUsuarioPanel = new CrearUsuario(conexion);
        modificarAlumnoPanel = new ModificarAlumno(conexion);
        modificarProfesorPanel = new ModificarProfesor(conexion);
        crearGrupoPanel = new CrearGrupo(conexion);
        consultarGrupoPanel = new ConsultarGrupo(conexion);
        modificarGrupoPanel = new ModificarGrupo(conexion);

        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Control Escolar");
        this.setLayout(layout);
        this.conexion = conexion;

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

        consultarProfesorPanel.setVisible(false);
        crearUsuarioPanel.setVisible(false);
        modificarAlumnoPanel.setVisible(false);
        modificarProfesorPanel.setVisible(false);
        crearGrupoPanel.setVisible(false);
        consultarGrupoPanel.setVisible(false);
        modificarGrupoPanel.setVisible(false);

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

        config.gridx=0; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrearNuevoIntegrante.setBackground(Color.DARK_GRAY); botonCrearNuevoIntegrante.setForeground(Color.BLACK);
        this.add(botonCrearNuevoIntegrante, config);

        config.gridx=0; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrearNuevoGrupo.setBackground(Color.DARK_GRAY); botonCrearNuevoGrupo.setForeground(Color.BLACK);
        this.add(botonCrearNuevoGrupo, config);

        config.gridx=1; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrearUsuarioLogico.setBackground(Color.DARK_GRAY); botonCrearUsuarioLogico.setForeground(Color.BLACK);
        this.add(botonCrearUsuarioLogico, config);

        config.gridx=1; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrearGrupoLogico.setBackground(Color.DARK_GRAY); botonCrearGrupoLogico.setForeground(Color.BLACK);
        this.add(botonCrearGrupoLogico, config);


        botonCrearUsuarioLogico.setVisible(false);
        botonCrearNuevoGrupo.setVisible(false);
        botonCrearGrupoLogico.setVisible(false);
        botonModificarGrupo.setVisible(false);
    }

    private void eventos(){
        //eventos de botones superiores (solo banderas)
        botonCerrarSesion.addActionListener(e -> this.dispose());
        botonProfesores.addActionListener(e -> cargarInterfazInicialProfesores());
        botonAlumnos.addActionListener(e -> cargarInterfazInicialAlumnos());
        botonGrupos.addActionListener(v-> cargarInterfazInicialGrupos());


        botonCrearNuevoIntegrante.addActionListener(e-> cargarPanelCrearNuevoIntegrante());
        botonCrearUsuarioLogico.addActionListener(e-> {
            try {
                botonCrearUsuarioLogico();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        botonModificarUsuario.addActionListener(v-> cargarPanelModificarUsuario());
        botonCrearNuevoGrupo.addActionListener(v-> cargarPanelCrearNuevoGrupo());
        botonCrearGrupoLogico.addActionListener(v-> {
            try {
                crearGrupoLogico();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        botonModificarGrupo.addActionListener(v-> cargarPanelModificarGrupo());
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

            botonModificarUsuario.setVisible(true);
            botonCrearNuevoIntegrante.setVisible(true);
            botonCrearUsuarioLogico.setVisible(false);
            botonCrearGrupoLogico.setVisible(false);
            botonModificarGrupo.setVisible(false);
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

            botonModificarUsuario.setVisible(true);
            botonCrearNuevoIntegrante.setVisible(true);
            botonCrearUsuarioLogico.setVisible(false);
            botonCrearGrupoLogico.setVisible(false);
            botonModificarGrupo.setVisible(false);
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

            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            vacio.setVisible(true);
            botonCrearUsuarioLogico.setVisible(true);
            botonCrearGrupoLogico.setVisible(false);
            botonModificarGrupo.setVisible(false);
        }
    }

    private void botonCrearUsuarioLogico() throws SQLException {
        String nombre = crearUsuarioPanel.textNombre.getText();
        String primerApellido = crearUsuarioPanel.textPrimerApellido.getText();
        String segundoApellido = crearUsuarioPanel.textSegundoApellido.getText();
        String curp = crearUsuarioPanel.textCurp.getText();
        String genero = (String) crearUsuarioPanel.comboGenero.getSelectedItem();
        String tipoSeleccionado = (String) crearUsuarioPanel.comboTipo.getSelectedItem();
        int idGrupo = Integer.parseInt(crearUsuarioPanel.textIdGrupo.getText());
        assert tipoSeleccionado != null;
        if(tipoSeleccionado.equals("ALUMNO")){
            AlumnoService service = new AlumnoService();
            service.Create(conexion,nombre,primerApellido,segundoApellido,curp,genero,tipoSeleccionado,idGrupo);
        }else if(tipoSeleccionado.equals("PROFESOR")){
            ProfesoresService service = new ProfesoresService();
            service.Create(conexion,nombre,primerApellido,segundoApellido,curp,genero,tipoSeleccionado,idGrupo);
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
            modificarProfesorPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            vacio.setVisible(true);
            vacio2.setVisible(true);
            botonCrearUsuarioLogico.setVisible(false);
            botonCrearGrupoLogico.setVisible(false);
            //en caso contrario probar con profesores ya que igualmente es de tipo usuario
        }else if(!modificarProfesorPanel.isVisible()&&consultarProfesorPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            crearGrupoPanel.setVisible(false);
            modificarGrupoPanel.setVisible(false);
            consultarGrupoPanel.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            modificarProfesorPanel.setVisible(true);
            vacio.setVisible(true);
            vacio2.setVisible(true);
            botonCrearUsuarioLogico.setVisible(false);
            botonCrearGrupoLogico.setVisible(false);
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

            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            vacio.setVisible(true);
            botonCrearUsuarioLogico.setVisible(false);
            botonCrearGrupoLogico.setVisible(true);
            botonCrearNuevoGrupo.setVisible(false);
            botonModificarGrupo.setVisible(false);
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

            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            botonModificarGrupo.setVisible(true);
            vacio.setVisible(true);
            botonCrearUsuarioLogico.setVisible(false);
            botonCrearGrupoLogico.setVisible(false);
            botonCrearNuevoGrupo.setVisible(true);
        }
    }

    private void crearGrupoLogico() throws SQLException {
        String grado = crearGrupoPanel.textGrado.getText();
        String grupo = crearGrupoPanel.textGrupo.getText();
        String turno = crearGrupoPanel.textTurno.getText();
        String ciclo = crearGrupoPanel.textCiclo.getText();
        GrupoService service = new GrupoService();
        service.Create(conexion,grado,grupo,turno,ciclo);
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

            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarUsuario.setVisible(false);
            botonModificarGrupo.setVisible(false);
            vacio.setVisible(true);
            botonCrearUsuarioLogico.setVisible(false);
            botonCrearGrupoLogico.setVisible(false);
            botonCrearNuevoGrupo.setVisible(false);
        }
    }
}
