package Pane;

import Administradores.AdministradorService;


import Resources.Conexion;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class VentanaInicio extends JFrame {

    public final static Connection conexion = Conexion.conecToDB();

    InicioSesion inicio = new InicioSesion();

    JButton botonIniciarSesion = new JButton("Iniciar Sesion");

    JLabel vacio = new JLabel(" ");
    JLabel vacio3 = new JLabel(" ");

    public VentanaInicio() throws SQLException {
        this.setSize(700, 500);  // asignamos el ancho y alto a la venta JFrame
        this.setLocationRelativeTo(null);  // centramos la ventana en pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Registro de Calificaciones");
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);


        GridBagConstraints config = new GridBagConstraints();
        config.gridx = 0;
        config.gridy = 1;
        config.gridwidth = 4;
        config.gridheight = 3;
        config.weightx = 1.0;
        config.weighty = 1.0;
        config.anchor = GridBagConstraints.CENTER;
        config.fill = GridBagConstraints.BOTH;
        this.add(inicio, config);

        config.gridx = 1;
        config.gridy = 4;
        config.gridwidth = 1;
        config.gridheight = 1;
        config.ipadx = 100;
        config.ipady = 10;
        config.weighty = 0.0;
        config.anchor = GridBagConstraints.CENTER;
        config.fill = GridBagConstraints.BOTH;
        botonIniciarSesion.setBackground(Color.DARK_GRAY);
        botonIniciarSesion.setForeground(Color.BLACK);
        this.add(botonIniciarSesion, config);


        config.gridx = 0;
        config.gridy = 4;
        config.gridwidth = 1;
        config.gridheight = 2;
        config.ipadx = 100;
        config.ipady = 10;
        config.weighty = 0.0;
        config.anchor = GridBagConstraints.CENTER;
        config.fill = GridBagConstraints.BOTH;
        vacio.setBackground(Color.DARK_GRAY);
        vacio.setOpaque(true);
        vacio.setForeground(Color.BLACK);
        this.add(vacio, config);


        config.gridx = 2;
        config.gridy = 4;
        config.gridwidth = 1;
        config.gridheight = 2;
        config.ipadx = 100;
        config.ipady = 10;
        config.weighty = 0.0;
        config.anchor = GridBagConstraints.CENTER;
        config.fill = GridBagConstraints.BOTH;
        vacio3.setBackground(Color.DARK_GRAY);
        vacio3.setOpaque(true);
        vacio3.setForeground(Color.BLACK);
        this.add(vacio3, config);


        inicio.setVisible(true);

        botonIniciarSesion.setVisible(true);

        vacio.setVisible(true);
        vacio3.setVisible(false);

        botonIniciarSesion.addActionListener(e -> {
            try {
                iniciarSesion();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }


    private void iniciarSesion() throws SQLException {
        String nombre = inicio.textNombre.getText();
        String password = inicio.textPassword.getText();
        AdministradorService.inicioSesion(conexion,nombre,password);
        inicio.textNombre.setText(null);
        inicio.textPassword.setText(null);
    }
}
