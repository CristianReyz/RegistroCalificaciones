package Pane;

import Alumnos.AlumnoService;
import Pane.Alumnos.ConsultarAlumno;
import Pane.Alumnos.ModificarAlumno;
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

    JButton botonAlumnos = new JButton("Alumnos");
    JButton botonProfesores = new JButton("Profesores");
    JButton botonGrupos = new JButton("Grupos");
    JButton botonCerrarSesion = new JButton("Cerrar Sesion");

    JButton botonModificarConfirmar = new JButton("Modificar");
    JButton botonCrearNuevoIntegrante = new JButton("Inscribir");
    JButton botonCrear = new JButton("Confirmar");

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

    public VentanaPrincipal(Connection conexion) {
        consultarAlumnoPanel = new ConsultarAlumno(conexion);
        consultarProfesorPanel = new ConsultarProfesor(conexion);
        crearUsuarioPanel = new CrearUsuario(conexion);
        modificarAlumnoPanel = new ModificarAlumno(conexion);
        modificarProfesorPanel = new ModificarProfesor(conexion);


        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Control Escolar");
        this.setLayout(layout);

        this.conexion = conexion;

        //config de paneles
        config.gridx=0; config.gridy=1; config.gridwidth=4; config.gridheight=3; config.weightx=1.0; config.weighty=1.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        this.add(consultarAlumnoPanel,config);
        this.add(consultarProfesorPanel,config);
        this.add(crearUsuarioPanel,config);
        this.add(modificarAlumnoPanel,config);
        this.add(modificarProfesorPanel,config);


        config.gridx=0; config.gridy=0; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonAlumnos.setBackground(Color.DARK_GRAY); botonAlumnos.setForeground(Color.BLACK);
        this.add(botonAlumnos, config);

        config.gridx=1; config.gridy=0; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonProfesores.setBackground(Color.DARK_GRAY); botonProfesores.setForeground(Color.BLACK);
        this.add(botonProfesores, config);

        config.gridx=2; config.gridy=0; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonGrupos.setBackground(Color.DARK_GRAY); botonGrupos.setForeground(Color.BLACK);
        this.add(botonGrupos, config);

        config.gridx=3; config.gridy=0; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCerrarSesion.setBackground(Color.DARK_GRAY); botonCerrarSesion.setForeground(Color.BLACK);
        this.add(botonCerrarSesion, config);

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

        config.gridx=1; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonModificarConfirmar.setBackground(Color.DARK_GRAY); botonModificarConfirmar.setForeground(Color.BLACK);
        this.add(botonModificarConfirmar, config);

        config.gridx=0; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrearNuevoIntegrante.setBackground(Color.DARK_GRAY); botonCrearNuevoIntegrante.setForeground(Color.BLACK);
        this.add(botonCrearNuevoIntegrante, config);

        config.gridx=1; config.gridy=4; config.gridwidth=1; config.gridheight=1; config.ipadx=100; config.ipady=10; config.weighty=0.0;
        config.anchor=GridBagConstraints.CENTER; config.fill= GridBagConstraints.BOTH;
        botonCrear.setBackground(Color.DARK_GRAY); botonCrear.setForeground(Color.BLACK);
        this.add(botonCrear, config);

        vacio.setVisible(false);
        vacio2.setVisible(false);
        consultarProfesorPanel.setVisible(false);
        botonCrear.setVisible(false);
        crearUsuarioPanel.setVisible(false);
        modificarAlumnoPanel.setVisible(false);
        modificarProfesorPanel.setVisible(false);
        eventos();
    }

    private void eventos(){
        botonCerrarSesion.addActionListener(e -> this.dispose());

        botonProfesores.addActionListener(e ->interfazProfesores());
        botonAlumnos.addActionListener(e -> interfazAlumnos());
        botonCrearNuevoIntegrante.addActionListener(e->setBotonCrearNuevoIntegrante());
        botonCrear.addActionListener(e-> {
            try {
                setBotonCrear();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        botonModificarConfirmar.addActionListener(v-> {
            try {
                setBotonModificar();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private void interfazProfesores(){
        if(!consultarProfesorPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(true);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);

            botonModificarConfirmar.setVisible(true);
            botonCrearNuevoIntegrante.setVisible(true);
            botonCrear.setVisible(false);
        }
    }

    private void interfazAlumnos(){
        if(!consultarAlumnoPanel.isVisible()){
            consultarAlumnoPanel.setVisible(true);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);

            botonModificarConfirmar.setVisible(true);
            botonCrearNuevoIntegrante.setVisible(true);
            botonCrear.setVisible(false);
        }
    }

    private void setBotonCrearNuevoIntegrante(){
        if(!crearUsuarioPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(true);
            modificarAlumnoPanel.setVisible(false);
            modificarProfesorPanel.setVisible(false);

            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarConfirmar.setVisible(false);
            vacio.setVisible(true);
            botonCrear.setVisible(true);
        }
    }



    private void setBotonModificar() throws SQLException {
        if(!modificarAlumnoPanel.isVisible()&&consultarAlumnoPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(true);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarConfirmar.setVisible(false);
            modificarProfesorPanel.setVisible(false);
            vacio.setVisible(true);
            vacio2.setVisible(true);
            botonCrear.setVisible(false);
        }else if(!modificarProfesorPanel.isVisible()&&consultarProfesorPanel.isVisible()){
            consultarAlumnoPanel.setVisible(false);
            consultarProfesorPanel.setVisible(false);
            crearUsuarioPanel.setVisible(false);
            modificarAlumnoPanel.setVisible(false);
            botonCrearNuevoIntegrante.setVisible(false);
            botonModificarConfirmar.setVisible(false);
            modificarProfesorPanel.setVisible(true);
            vacio.setVisible(true);
            vacio2.setVisible(true);
            botonCrear.setVisible(false);
        }
    }





    private void setBotonCrear() throws SQLException {
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
}
