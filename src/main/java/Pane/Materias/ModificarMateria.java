package Pane.Materias;

import Materias.*;
import Grupos.GrupoService;
import Materias.Materias;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class ModificarMateria extends JPanel{

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();

    JTextField textNombre = new JTextField();
    JTextField textArea = new JTextField();

    JButton verificar = new JButton("Verificar");
    JTextField textIDGrupoPorModificar = new JTextField();

    JLabel etiquetaNombreActual;
    JLabel etiquetaAreaActual;
    private final Connection conexion;
    private Materias materia;

    public ModificarMateria(Connection conexion){
        this.setLayout(layout);
        this.setBackground(Color.DARK_GRAY);
        this.conexion = conexion;
        cargarComponentes();
    }


    private void cargarComponentes(){
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

        JLabel etiquetaTitulo = new JLabel("Ingresa id de la materia");
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaTitulo, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(textIDGrupoPorModificar,config);

        verificar.setBackground(Color.DARK_GRAY);
        verificar.setForeground(Color.BLACK);
        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(verificar,config);

        verificar.addActionListener(v->{
            try {
                this.materia = ModificarPorID(conexion);
                etiquetaNombreActual.setText(this.materia.getNombre());
                etiquetaAreaActual.setText(this.materia.getArea());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JLabel etiquetaNombre = new JLabel("Nombre");
        etiquetaNombre.setForeground(Color.BLACK);
        etiquetaNombre.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaNombre, config);

        etiquetaNombreActual = new JLabel();
        etiquetaNombreActual.setForeground(Color.black);
        etiquetaNombreActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaNombreActual, config);

        config.gridx = 3;
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

        etiquetaAreaActual = new JLabel();
        etiquetaAreaActual.setForeground(Color.black);
        etiquetaAreaActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(etiquetaAreaActual, config);

        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(textArea, config);


        JButton actualizar = new JButton("ACTUALIZAR");
        actualizar.setBackground(Color.DARK_GRAY);
        actualizar.setForeground(Color.BLACK);
        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 7;
        this.add(actualizar,config);

        actualizar.addActionListener(v->{
            String nombreActualizado = textNombre.getText();
            String areaActualizada = textArea.getText();
            MateriasService service = new MateriasService();
            try {
                service.update(conexion,nombreActualizado,areaActualizada,this.materia);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JButton eliminar = new JButton("ELIMINAR");
        eliminar.setBackground(Color.DARK_GRAY);
        eliminar.setForeground(Color.BLACK);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 7;
        this.add(eliminar,config);
        eliminar.addActionListener(v->{
            try{
                MateriasService service = new MateriasService();
                service.delete(conexion,this.materia);
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        });
    }

    public Materias ModificarPorID(Connection conexion) throws SQLException {
        String parametro = textIDGrupoPorModificar.getText();
        MateriasService service = new MateriasService();
        return service.prepararUpdate(conexion,parametro);
    }
}
