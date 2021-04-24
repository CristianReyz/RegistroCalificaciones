package Pane;

import Alumnos.AlumnoService;
import Profesores.ProfesoresService;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class CrearUsuario extends JPanel{

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();

    JTextField textNombre = new JTextField();
    JTextField textPrimerApellido = new JTextField();
    JTextField textSegundoApellido = new JTextField();
    JTextField textCurp = new JTextField();
    JTextField textIdGrupo = new JTextField();
    JComboBox comboGenero = new JComboBox();
    JComboBox comboTipo = new JComboBox();

    private Connection conexion;
    public CrearUsuario(Connection conexion){
        this.setLayout(layout);
        this.setBackground(Color.DARK_GRAY);
        this.conexion = conexion;

        config.weightx = 1;
        config.weighty = 1;
        config.fill = GridBagConstraints.HORIZONTAL;

        JLabel etiquetaVacia = new JLabel(" ");
        config.gridx = 0;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaVacia, config);

        JLabel etiquetaVacia2 = new JLabel(" ");
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaVacia2, config);

        JLabel etiquetaVacia3 = new JLabel(" ");
        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(etiquetaVacia3, config);

        JLabel etiquetaVacia4 = new JLabel(" ");
        config.gridx = 4;
        config.gridwidth = 1;
        config.gridy = 4;
        this.add(etiquetaVacia4, config);

        JLabel etiquetaTitulo = new JLabel("Inscribir miembro");
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaTitulo, config);

        JLabel etiquetaNombre = new JLabel("Nombre");
        etiquetaNombre.setForeground(Color.BLACK);
        etiquetaNombre.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaNombre, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(textNombre, config);

        JLabel etiquetaRFC = new JLabel("Primer Apellido");
        etiquetaRFC.setForeground(Color.BLACK);
        etiquetaRFC.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(etiquetaRFC, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(textPrimerApellido, config);


        JLabel etiquetaCorreo = new JLabel("Segundo Apellido");
        etiquetaCorreo.setForeground(Color.BLACK);
        etiquetaCorreo.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(etiquetaCorreo, config);


        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(textSegundoApellido, config);

        JLabel etiquetaCurp = new JLabel("CURP");
        etiquetaCurp.setForeground(Color.BLACK);
        etiquetaCurp.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 4;
        this.add(etiquetaCurp, config);


        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 4;
        this.add(textCurp, config);

        JLabel etiquetaGenero = new JLabel("Genero");
        etiquetaGenero.setForeground(Color.BLACK);
        etiquetaGenero.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 5;
        this.add(etiquetaGenero, config);


        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMENINO", "MASCULINO" }));
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 5;
        this.add(comboGenero, config);

        JLabel etiquetaTipo = new JLabel("Tipo");
        etiquetaTipo.setForeground(Color.BLACK);
        etiquetaTipo.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(etiquetaTipo, config);

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALUMNO", "PROFESOR" }));
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(comboTipo, config);

        JLabel etiquetaIdGrupo = new JLabel("ID Grupo");
        etiquetaIdGrupo.setForeground(Color.BLACK);
        etiquetaIdGrupo.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 7;
        this.add(etiquetaIdGrupo, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 7;
        this.add(textIdGrupo, config);

        JButton botonCrear = new JButton("Confirmar y crear");
        botonCrear.setBackground(Color.DARK_GRAY);
        botonCrear.setForeground(Color.BLACK);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 8;
        botonCrear.addActionListener(e -> {
            try {
                crearUsuario(conexion);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        this.add(botonCrear, config);

    }

    private void crearUsuario(Connection conexion) throws SQLException {
        String nombre = textNombre.getText();
        String primerApellido = textPrimerApellido.getText();
        String segundoApellido = textSegundoApellido.getText();
        String curp = textCurp.getText();
        String genero = (String) comboGenero.getSelectedItem();
        String tipoSeleccionado = (String) comboTipo.getSelectedItem();
        int idGrupo = Integer.parseInt(textIdGrupo.getText());
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
