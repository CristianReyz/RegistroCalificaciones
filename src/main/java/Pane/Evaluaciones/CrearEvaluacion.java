package Pane.Evaluaciones;

import Evaluaciones.EvaluacionesService;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class CrearEvaluacion extends JPanel{

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();

    JTextField textEvaluacion = new JTextField();
    JTextField textCalificacion = new JTextField();
    JTextField textEstado = new JTextField();
    JTextField textCiclo = new JTextField();
    JTextField textIdMateria = new JTextField();
    JTextField textIdAlumno = new JTextField();

    private Connection conexion;
    public CrearEvaluacion(Connection conexion){
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

        JLabel etiquetaTitulo = new JLabel("Registrar Evaluacion");
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaTitulo, config);

        JLabel etiquetaEvaluacion = new JLabel("NO Evaluacion");
        etiquetaEvaluacion.setForeground(Color.BLACK);
        etiquetaEvaluacion.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaEvaluacion, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(textEvaluacion, config);

        JLabel etiquetaCalificacion = new JLabel("Calificacion");
        etiquetaCalificacion.setForeground(Color.BLACK);
        etiquetaCalificacion.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(etiquetaCalificacion, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(textCalificacion, config);


        JLabel etiquetaEstado = new JLabel("Estado");
        etiquetaEstado.setForeground(Color.BLACK);
        etiquetaEstado.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(etiquetaEstado, config);


        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(textEstado, config);

        JLabel etiquetaCiclo = new JLabel("Ciclo");
        etiquetaCiclo.setForeground(Color.BLACK);
        etiquetaCiclo.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 4;
        this.add(etiquetaCiclo, config);


        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 4;
        this.add(textCiclo, config);

        JLabel etiquetaIdMateria = new JLabel("ID Materia");
        etiquetaIdMateria.setForeground(Color.BLACK);
        etiquetaIdMateria.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 7;
        this.add(etiquetaIdMateria, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 7;
        this.add(textIdMateria, config);

        JLabel etiquetaIdAlumno = new JLabel("ID Alumno");
        etiquetaIdAlumno.setForeground(Color.BLACK);
        etiquetaIdAlumno.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 8;
        this.add(etiquetaIdAlumno, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 8;
        this.add(textIdAlumno, config);

        JButton botonCrear = new JButton("Confirmar y crear");
        botonCrear.setBackground(Color.DARK_GRAY);
        botonCrear.setForeground(Color.BLACK);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 9;
        botonCrear.addActionListener(e -> {
            try {
                crearEvaluacion(conexion);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        this.add(botonCrear, config);

    }

    private void crearEvaluacion(Connection conexion) throws SQLException {
        String evaluacion = textEvaluacion.getText();
        String calificacion = textCalificacion.getText();
        String estado = textEstado.getText();
        String ciclo = textCiclo.getText();
        int idMateria = Integer.parseInt(textIdMateria.getText());
        int idAlumno = Integer.parseInt(textIdAlumno.getText());
        EvaluacionesService service = new EvaluacionesService();
        service.Create(conexion,evaluacion,calificacion,estado,ciclo,idMateria,idAlumno);

    }
}
