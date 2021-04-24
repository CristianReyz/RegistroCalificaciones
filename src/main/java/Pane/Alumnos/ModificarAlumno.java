package Pane.Alumnos;

import Alumnos.AlumnoService;
import Resources.Usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class ModificarAlumno extends JPanel{

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();

    JTextField textNombre = new JTextField();
    JTextField textPrimerApellido = new JTextField();
    JTextField textSegundoApellido = new JTextField();
    JTextField textIDGupo = new JTextField();
    JTextField textCurp = new JTextField();
    JComboBox<String> comboGenero = new JComboBox<>();

    JButton verificar = new JButton("Verificar");
    JTextField textIDAlumnoPorModificar = new JTextField();

    JLabel etiquetaNombreActual;
    JLabel etiquetaPrimerApellidoActual;
    JLabel etiquetaSegundoApellidoActual;
    JLabel etiquetaCurpActual;
    JLabel etiquetaGeneroActual;
    JLabel etiquetaIDGrupoActual;

    private final Connection conexion;
    private Usuario alumno;

    public ModificarAlumno(Connection conexion){
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

        JLabel etiquetaTitulo = new JLabel("Ingresa id del alumno");
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(etiquetaTitulo, config);

        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(textIDAlumnoPorModificar,config);

        verificar.setBackground(Color.DARK_GRAY);
        verificar.setForeground(Color.BLACK);
        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 0;
        this.add(verificar,config);

        verificar.addActionListener(v->{
            try {
                this.alumno = ModificarPorID(conexion);
                etiquetaNombreActual.setText(this.alumno.getNombre());
                etiquetaPrimerApellidoActual.setText(this.alumno.getPrimerApellido());
                etiquetaSegundoApellidoActual.setText(this.alumno.getSegundoApellido());
                etiquetaCurpActual.setText(this.alumno.getCURP());
                etiquetaGeneroActual.setText(this.alumno.getGenero());
                etiquetaIDGrupoActual.setText(String.valueOf(this.alumno.getIdGrupo()));
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




        JLabel etiquetaPrimerApellido = new JLabel("Primer Apellido");
        etiquetaPrimerApellido.setForeground(Color.BLACK);
        etiquetaPrimerApellido.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(etiquetaPrimerApellido, config);

        etiquetaPrimerApellidoActual = new JLabel();
        etiquetaPrimerApellidoActual.setForeground(Color.black);
        etiquetaPrimerApellidoActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(etiquetaPrimerApellidoActual, config);

        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(textPrimerApellido, config);


        JLabel etiquetaSegundoApellido = new JLabel("Segundo Apellido");
        etiquetaSegundoApellido.setForeground(Color.BLACK);
        etiquetaSegundoApellido.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(etiquetaSegundoApellido, config);

        etiquetaSegundoApellidoActual = new JLabel();
        etiquetaSegundoApellidoActual.setForeground(Color.black);
        etiquetaSegundoApellidoActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(etiquetaSegundoApellidoActual, config);

        config.gridx = 3;
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

        etiquetaCurpActual = new JLabel();
        etiquetaCurpActual.setForeground(Color.black);
        etiquetaCurpActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 4;
        this.add(etiquetaCurpActual, config);

        config.gridx = 3;
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

        etiquetaGeneroActual = new JLabel();
        etiquetaGeneroActual.setForeground(Color.black);
        etiquetaGeneroActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 5;
        this.add(etiquetaGeneroActual, config);


        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMENINO", "MASCULINO" }));
        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 5;
        this.add(comboGenero, config);

        JLabel IDGrupo = new JLabel("ID Grupo");
        IDGrupo.setForeground(Color.BLACK);
        IDGrupo.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(IDGrupo, config);

        etiquetaIDGrupoActual = new JLabel();
        etiquetaIDGrupoActual.setForeground(Color.black);
        etiquetaIDGrupoActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(etiquetaIDGrupoActual, config);

        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(textIDGupo, config);

        JButton actualizar = new JButton("ACTUALIZAR");
        actualizar.setBackground(Color.DARK_GRAY);
        actualizar.setForeground(Color.BLACK);
        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 7;
        this.add(actualizar,config);

        actualizar.addActionListener(v->{
            String nombreActualizado = textNombre.getText();
            String primerApellidoActualizado = textPrimerApellido.getText();
            String segundoApellidoActualizado = textSegundoApellido.getText();
            String curpActualizado = textCurp.getText();
            String generoActualizado = (String) comboGenero.getSelectedItem();
            int idGrupoActualizado = Integer.parseInt(textIDGupo.getText());
            AlumnoService service = new AlumnoService();
            try {
                service.update(conexion,nombreActualizado,primerApellidoActualizado,segundoApellidoActualizado,
                        curpActualizado,generoActualizado,idGrupoActualizado,this.alumno);
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
                AlumnoService service = new AlumnoService();
                service.delete(conexion,this.alumno);
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        });
    }

    public Usuario ModificarPorID(Connection conexion) throws SQLException {
        String parametro = textIDAlumnoPorModificar.getText();
        AlumnoService service = new AlumnoService();
        return service.prepararUpdate(conexion,parametro);
    }
}
