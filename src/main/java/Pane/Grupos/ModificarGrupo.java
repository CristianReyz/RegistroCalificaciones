package Pane.Grupos;

import Grupos.Grupos;
import Grupos.GrupoService;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class ModificarGrupo extends JPanel{

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 20);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints config = new GridBagConstraints();

    JTextField textGrado = new JTextField();
    JTextField textGrupo = new JTextField();
    JTextField textTurno = new JTextField();
    JTextField textIDGupo = new JTextField();
    JTextField textCiclo = new JTextField();
    JComboBox<String> comboGenero = new JComboBox<>();

    JButton verificar = new JButton("Verificar");
    JTextField textIDGrupoPorModificar = new JTextField();

    JLabel etiquetaGradoActual;
    JLabel etiquetaGrupoActual;
    JLabel etiquetaTurnoActual;
    JLabel etiquetaCicloActual;
    JLabel etiquetaGeneroActual;
    JLabel etiquetaIDGrupoActual;

    private final Connection conexion;
    private Grupos grupos;

    public ModificarGrupo(Connection conexion){
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

        JLabel etiquetaTitulo = new JLabel("Ingresa id del grupo");
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
                this.grupos = ModificarPorID(conexion);
                etiquetaGradoActual.setText(this.grupos.getGrado());
                etiquetaGrupoActual.setText(this.grupos.getGrupo());
                etiquetaTurnoActual.setText(this.grupos.getTurno());
                etiquetaCicloActual.setText(this.grupos.getCiclo());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JLabel etiquetaGrado = new JLabel("Grado");
        etiquetaGrado.setForeground(Color.BLACK);
        etiquetaGrado.setFont(fuente);
        config.gridx = 1;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaGrado, config);

        etiquetaGradoActual = new JLabel();
        etiquetaGradoActual.setForeground(Color.black);
        etiquetaGradoActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 1;
        this.add(etiquetaGradoActual, config);

        config.gridx = 3;
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

        etiquetaGrupoActual = new JLabel();
        etiquetaGrupoActual.setForeground(Color.black);
        etiquetaGrupoActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 2;
        this.add(etiquetaGrupoActual, config);

        config.gridx = 3;
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

        etiquetaTurnoActual = new JLabel();
        etiquetaTurnoActual.setForeground(Color.black);
        etiquetaTurnoActual.setFont(fuente);
        config.gridx = 2;
        config.gridwidth = 1;
        config.gridy = 3;
        this.add(etiquetaTurnoActual, config);

        config.gridx = 3;
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


        JButton actualizar = new JButton("ACTUALIZAR");
        actualizar.setBackground(Color.DARK_GRAY);
        actualizar.setForeground(Color.BLACK);
        config.gridx = 3;
        config.gridwidth = 1;
        config.gridy = 7;
        this.add(actualizar,config);

        actualizar.addActionListener(v->{
            String gradoActualizado = textGrado.getText();
            String grupoActualizado = textGrupo.getText();
            String segundoApellidoActualizado = textTurno.getText();
            String curpActualizado = textCiclo.getText();
            GrupoService service = new GrupoService();
            try {
                service.update(conexion,gradoActualizado,grupoActualizado,segundoApellidoActualizado,
                        curpActualizado,this.grupos);
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
                GrupoService service = new GrupoService();
                service.delete(conexion,this.grupos);
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        });
    }

    public Grupos ModificarPorID(Connection conexion) throws SQLException {
        String parametro = textIDGrupoPorModificar.getText();
        GrupoService service = new GrupoService();
        return service.prepararUpdate(conexion,parametro);
    }
}
