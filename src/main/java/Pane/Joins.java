package Pane;

import Joins.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Joins extends JPanel {

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);
    Font fuente2 = new Font("Comic Sans MS", Font.ITALIC, 15);
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();
    JComboBox<String> comboReportes = new JComboBox<>();
    JComboBox<String> comboParametro = new JComboBox<>();


    public Joins(Connection conexion){
        this.setLayout(layout);
        this.setBackground(Color.DARK_GRAY);
        componentes(conexion);
    }

    public void componentes(Connection conexion){
        config.weightx = 1;
        config.weighty = 1;
        config.fill = GridBagConstraints.HORIZONTAL;

        JLabel etiquetaVacia = new JLabel(" ");
        config.gridx = 0;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaVacia, config);

        JLabel etiquetaVacia2 = new JLabel(" ");
        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaVacia2, config);

        JLabel etiquetaVacia3 = new JLabel(" ");
        config.gridx = 6;
        config.gridwidth = 1;
        config.gridy = 9;
        this.add(etiquetaVacia3, config);

        JLabel etiquetaVacia4 = new JLabel(" ");
        config.gridx = 4;
        config.gridwidth = 1;
        config.gridy = 4;
        this.add(etiquetaVacia4, config);

        JLabel etiquetaTitulo = new JLabel("joins");
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaTitulo, config);

        JLabel etiquetaParametro = new JLabel("Elige:");
        etiquetaParametro.setForeground(Color.BLACK);
        etiquetaParametro.setFont(fuente2);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaParametro, config);

        //REPORTE 1.- Nombre del alumno(s) con el mayor promedio final por cada grupo en cada grado(CICLO ESCOLAR EN CAJA)
        //REPORTE 6.- Listado de grupos con el nombre del profesor, el grado y el total de alumnos (CICLO ESCOLAR EN CAJA)
        //11. Grado y grupo con el total de mujeres y total de hombres, elegir de una cada de texto el ciclo escolar.
        //15. nombre de profesores con menor promedio escolar por grupo elegir ciclo escolar
        comboReportes.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA","REPORTE 1","REPORTE 6",
                "REPORTE 11","REPORTE 15"}));
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(comboReportes, config);


        JTable tablaAlumnos = new JTable(JoinsDAO.modelo);
        config.gridx = 0;
        config.gridwidth = 7;
        config.gridheight = 2;
        config.gridy = 2;
        this.add(tablaAlumnos, config);
        JScrollPane scroll = new JScrollPane(tablaAlumnos);
        config.gridx = 0;
        config.gridwidth = 7;
        config.gridheight = 2;
        config.gridy = 2;
        this.add(scroll, config);

        JLabel vaciaa = new JLabel(" ");
        vaciaa.setForeground(Color.BLACK);
        vaciaa.setFont(fuente2);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(vaciaa, config);

        comboParametro.setModel(new DefaultComboBoxModel<>(new String[]{
            "2018-2019","2019-2020","2020-2021"}));
        config.gridx = 4;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(comboParametro, config);

        JLabel vacio = new JLabel(" ");
        vacio.setForeground(Color.BLACK);
        vacio.setFont(fuente2);
        config.gridx = 5;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(vacio, config);



        comboParametro.setVisible(false);

        comboReportes.addActionListener(v -> {
            try {
                mostrarParametros(conexion);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        comboParametro.addActionListener(v-> {
            try {
                consultar(conexion);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private void mostrarParametros(Connection conexion) throws SQLException {
        String parametroSeleccionado = (String) comboReportes.getSelectedItem();
        assert parametroSeleccionado != null;
        if(!parametroSeleccionado.equals("SELECCIONA")){
            comboParametro.setVisible(true);
            JoinsService service = new JoinsService();
            switch (parametroSeleccionado) {
               // ciclos
                case "REPORTE 1":
                    service.reporte1(conexion,parametroSeleccionado);
                    break;
                case "REPORTE 6":
                    service.reporte6(conexion,parametroSeleccionado);
                    break;
                case "REPORTE 11":

                    service.reporte11(conexion,parametroSeleccionado);
                    break;
                case "REPORTE 15":
                    service.reporte15(conexion,parametroSeleccionado);
                    break;
            }
        }else{
            comboParametro.setVisible(false);
        }
    }
    private void consultar(Connection conexion) throws SQLException {
        String tipoConsulta = (String) comboReportes.getSelectedItem();
        String parametro = (String) comboParametro.getSelectedItem();
        //aqui manda a llamar a service
    }
}
