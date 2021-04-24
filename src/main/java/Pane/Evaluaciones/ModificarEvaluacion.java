package Pane.Evaluaciones;

import Alumnos.AlumnoService;
import Evaluaciones.Evaluaciones;
import Evaluaciones.EvaluacionesService;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class ModificarEvaluacion extends JPanel{

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();

    JTextField textEvaluacion = new JTextField();
    JTextField textCalificacion = new JTextField();
    JTextField textEstado = new JTextField();
    JTextField textCiclo = new JTextField();
    JTextField textidMateria = new JTextField();
    JTextField textidAlumno = new JTextField();

    JButton verificar = new JButton("Verificar");
    JTextField textIDAlumnoPorModificar = new JTextField();

    JLabel etiquetaEvaluacionActual;
    JLabel etiquetaCalificacionActual;
    JLabel etiquetaEstadoActual;
    JLabel etiquetaCicloActual;
    JLabel etiquetaidMateriaActual;
    JLabel etiquetaIDAlumnoActual;

    private final Connection conexion;
    private Evaluaciones evaluacion;

    public ModificarEvaluacion(Connection conexion){
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

        JLabel etiquetaTitulo = new JLabel("Ingresa id de Evaluacion");
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
                this.evaluacion = ModificarPorID(conexion);
                etiquetaEvaluacionActual.setText(this.evaluacion.getEvaluacion());
                etiquetaCalificacionActual.setText(this.evaluacion.getCalificacion());
                etiquetaEstadoActual.setText(this.evaluacion.getEstado());
                etiquetaCicloActual.setText(this.evaluacion.getCiclo());
                etiquetaidMateriaActual.setText(String.valueOf(this.evaluacion.getIdMateria()));
                etiquetaIDAlumnoActual.setText(String.valueOf(this.evaluacion.getIdAlumno()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JLabel etiquetaEvaluacion = new JLabel("Evaluacion");
        etiquetaEvaluacion.setForeground(Color.BLACK);
        etiquetaEvaluacion.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaEvaluacion, config);

        etiquetaEvaluacionActual = new JLabel();
        etiquetaEvaluacionActual.setForeground(Color.black);
        etiquetaEvaluacionActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaEvaluacionActual, config);

        config.gridx = 3;
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

        etiquetaCalificacionActual = new JLabel();
        etiquetaCalificacionActual.setForeground(Color.black);
        etiquetaCalificacionActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(etiquetaCalificacionActual, config);

        config.gridx = 3;
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

        etiquetaEstadoActual = new JLabel();
        etiquetaEstadoActual.setForeground(Color.black);
        etiquetaEstadoActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(etiquetaEstadoActual, config);

        config.gridx = 3;
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

        etiquetaCicloActual = new JLabel();
        etiquetaCicloActual.setForeground(Color.black);
        etiquetaCicloActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 4;
        this.add(etiquetaCicloActual, config);

        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 4;
        this.add(textCiclo, config);

        JLabel etiquetaidMateria = new JLabel("ID Materia");
        etiquetaidMateria.setForeground(Color.BLACK);
        etiquetaidMateria.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 5;
        this.add(etiquetaidMateria, config);

        etiquetaidMateriaActual = new JLabel();
        etiquetaidMateriaActual.setForeground(Color.black);
        etiquetaidMateriaActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 5;
        this.add(etiquetaidMateriaActual, config);


        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 5;
        this.add(textidMateria, config);

        JLabel etiquetaIDAlumno = new JLabel("ID Alumno");
        etiquetaIDAlumno.setForeground(Color.BLACK);
        etiquetaIDAlumno.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(etiquetaIDAlumno, config);

        etiquetaIDAlumnoActual = new JLabel();
        etiquetaIDAlumnoActual.setForeground(Color.black);
        etiquetaIDAlumnoActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(etiquetaIDAlumnoActual, config);

        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 6;
        this.add(textidAlumno, config);

        JButton actualizar = new JButton("ACTUALIZAR");
        actualizar.setBackground(Color.DARK_GRAY);
        actualizar.setForeground(Color.BLACK);
        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 7;
        this.add(actualizar,config);

        actualizar.addActionListener(v->{
            String evaluacionActualizada = textEvaluacion.getText();
            String calificacionActualizada = textCalificacion.getText();
            String estadoActualizado = textEstado.getText();
            String cicloActualizado = textidMateria.getText();
            int idMateriaActualizada = Integer.parseInt(textidMateria.getText());
            int idAlumnoActualizado = Integer.parseInt(textidAlumno.getText());
            EvaluacionesService service = new EvaluacionesService();
            try {
                service.update(conexion,evaluacionActualizada,calificacionActualizada,
                        estadoActualizado,cicloActualizado,idMateriaActualizada,idAlumnoActualizado,this.evaluacion);
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
                EvaluacionesService service = new EvaluacionesService();
                service.delete(conexion,this.evaluacion);
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        });
    }

    public Evaluaciones ModificarPorID(Connection conexion) throws SQLException {
        String parametro = textIDAlumnoPorModificar.getText();
        EvaluacionesService service = new EvaluacionesService();
        return service.prepararUpdate(conexion,parametro);
    }
}
