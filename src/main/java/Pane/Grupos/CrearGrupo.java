package Pane.Grupos;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import javax.swing.*;

public class CrearGrupo extends JPanel{

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();

    public JTextField textGrado = new JTextField();
    public JTextField textGrupo = new JTextField();
    public JTextField textTurno = new JTextField();
    public JTextField textCiclo = new JTextField();

    private Connection conexion;
    public CrearGrupo(Connection conexion){
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

        JLabel etiquetaTitulo = new JLabel("Crear Grupo");
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaTitulo, config);

        JLabel etiquetaGrado = new JLabel("Grado");
        etiquetaGrado.setForeground(Color.BLACK);
        etiquetaGrado.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaGrado, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(textGrado, config);

        JLabel etiquetaGrupo = new JLabel("Grupo");
        etiquetaGrupo.setForeground(Color.BLACK);
        etiquetaGrupo.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(etiquetaGrupo, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(textGrupo, config);


        JLabel etiquetaTurno = new JLabel("Turno");
        etiquetaTurno.setForeground(Color.BLACK);
        etiquetaTurno.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(etiquetaTurno, config);


        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(textTurno, config);

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


    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
