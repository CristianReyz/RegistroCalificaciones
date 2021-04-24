package Pane.Grupos;

import Alumnos.AlumnoService;
import Grupos.GrupoDAO;
import Grupos.GrupoService;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class ConsultarGrupo extends JPanel{

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);
    Font fuente2 = new Font("Comic Sans MS", Font.ITALIC, 15);
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();
    JComboBox<String> comboTipoConsulta = new JComboBox<>();
    JButton aplicarBoton = new JButton("Aplicar");
    JTextField textParametroAlumno = new JTextField();

    public ConsultarGrupo(Connection conexion){
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

        JLabel etiquetaTitulo = new JLabel("Consultar Grupo");
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaTitulo, config);

        JLabel etiquetaTipoConsulta = new JLabel("Tipo de Consulta");
        etiquetaTipoConsulta.setForeground(Color.BLACK);
        etiquetaTipoConsulta.setFont(fuente2);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaTipoConsulta, config);

        comboTipoConsulta.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA","ID GRUPO","GRADO","GRUPO",
                "TURNO","CICLO"}));
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(comboTipoConsulta, config);


        JTable tablaGrupos = new JTable(GrupoDAO.modelo);
        config.gridx = 0;
        config.gridwidth = 7;
        config.gridheight = 2;
        config.gridy = 2;
        this.add(tablaGrupos, config);
        JScrollPane scroll = new JScrollPane(tablaGrupos);
        config.gridx = 0;
        config.gridwidth = 7;
        config.gridheight = 2;
        config.gridy = 2;
        this.add(scroll, config);

        JLabel etiquetaPreguntaModificar = new JLabel("¿Desea modificar o eliminar algun registro?");
        etiquetaPreguntaModificar.setForeground(Color.BLACK);
        etiquetaPreguntaModificar.setFont(fuente2);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 5;
        this.add(etiquetaPreguntaModificar, config);

        JLabel vaciaa = new JLabel(" ");
        vaciaa.setForeground(Color.BLACK);
        vaciaa.setFont(fuente2);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(vaciaa, config);

        config.gridx = 4;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(textParametroAlumno, config);

        JLabel vacio = new JLabel(" ");
        vacio.setForeground(Color.BLACK);
        vacio.setFont(fuente2);
        config.gridx = 5;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(vacio, config);


        aplicarBoton.setBackground(Color.DARK_GRAY);
        aplicarBoton.setForeground(Color.BLACK);
        config.gridx = 6;
        config.gridwidth = 1;
        config.gridy = 1;
        aplicarBoton.addActionListener(e -> {
            try {
                consultarGrupos(conexion);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        this.add(aplicarBoton, config);

        aplicarBoton.setVisible(false);
        textParametroAlumno.setVisible(false);

        comboTipoConsulta.addActionListener(e -> mostrarText());
    }

    private void mostrarText(){
        String parametroSeleccionado = (String) comboTipoConsulta.getSelectedItem();
        assert parametroSeleccionado != null;
        if(!parametroSeleccionado.equals("SELECCIONA")){
            aplicarBoton.setVisible(true);
            textParametroAlumno.setVisible(true);
        }
    }
    private void consultarGrupos(Connection conexion) throws SQLException {
        String tipoConsulta = (String) comboTipoConsulta.getSelectedItem();
        String parametro = textParametroAlumno.getText();
        GrupoService service = new GrupoService();
        assert tipoConsulta != null;
        service.Read(conexion,tipoConsulta,parametro);
    }


}
