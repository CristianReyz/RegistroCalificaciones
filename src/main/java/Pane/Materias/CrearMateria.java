package Pane.Materias;

import Materias.MateriasService;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class CrearMateria extends JPanel{

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();

    JTextField textNombre = new JTextField();
    JTextField textArea = new JTextField();

    private Connection conexion;

    public CrearMateria(Connection conexion){
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

        JLabel etiquetaTitulo = new JLabel("Crear Materia");
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

        JLabel etiquetaArea = new JLabel("Area");
        etiquetaArea.setForeground(Color.BLACK);
        etiquetaArea.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(etiquetaArea, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(textArea, config);

        JButton botonCrear = new JButton("Confirmar y crear");
        botonCrear.setBackground(Color.DARK_GRAY);
        botonCrear.setForeground(Color.BLACK);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 8;
        botonCrear.addActionListener(e -> {
            try {
                crearMateria(conexion);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        this.add(botonCrear, config);

    }

    private void crearMateria(Connection conexion) throws SQLException {
        String nombre = textNombre.getText();
        String area = textArea.getText();
        MateriasService service = new MateriasService();
        service.Create(conexion,nombre,area);
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
