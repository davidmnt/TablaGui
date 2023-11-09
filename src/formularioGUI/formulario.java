package formularioGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formulario {
    private JButton enviarButton;
    private JLabel Pass;
    private JPanel panelPrin;
    private JTextField textNombre;
    private JTextField id;
    private JTextField textMail;
    private JLabel user;
    private JLabel mail;
    private JLabel comprobacion;
    private JPasswordField textPass;
    private JLabel dni;
    private JPanel panelTabla;
    private JTextField textDni;
    private JTable tablaUsuarios;
    private JButton botonEnviar;
    private JButton BotonEliminar;
    private JButton botonNuevo;
    private JButton modificarButton;
    private JTextField textApellido;
    private JScrollPane JS;
    private JLabel titulo;
    static int idDatos = 0;

    public formulario() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("apellidos");
        modelo.addColumn("dni");
        modelo.addColumn("email");
        modelo.addColumn("contraseña");

        tablaUsuarios.setModel(modelo);



        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textNombre.getText();
                String apell = textApellido.getText();
                String nif = textDni.getText();
                String mail = textMail.getText();
                String pass = String.valueOf(textPass.getPassword());

                if(!name.isEmpty() && !apell.isEmpty() && !mail.isEmpty() && nif.isEmpty() && !pass.isEmpty()){

                    String[] obj = {String.valueOf(idDatos),name, apell,"",mail,"True"};
                    modelo.addRow(obj);
                    idDatos++;
                    textNombre.setText("");
                    textApellido.setText("");
                    textDni.setText("");
                    textMail.setText("");
                    textPass.setText("");

                } else if(!name.isEmpty() && !apell.isEmpty() && !mail.isEmpty() && !nif.isEmpty() && pass.isEmpty()){
                    String[] obj = {String.valueOf(idDatos),name, apell,nif,mail,"False"};
                    modelo.addRow(obj);
                    idDatos++;
                    textNombre.setText("");
                    textApellido.setText("");
                    textDni.setText("");
                    textMail.setText("");
                    textPass.setText("");

                }else if(!name.isEmpty() && !apell.isEmpty() && !mail.isEmpty() && !nif.isEmpty() && !pass.isEmpty()){
                    String[] obj = {String.valueOf(idDatos),name, apell,nif,mail,"True"};
                    modelo.addRow(obj);
                    idDatos++;
                    textNombre.setText("");
                    textApellido.setText("");
                    textDni.setText("");
                    textMail.setText("");
                    textPass.setText("");

                }else if(!name.isEmpty() && !apell.isEmpty() && !mail.isEmpty() && nif.isEmpty() && pass.isEmpty()) {
                    String[] obj = {String.valueOf(idDatos), name, apell, " ", mail, "False"};
                    modelo.addRow(obj);
                    idDatos++;
                    textNombre.setText("");
                    textApellido.setText("");
                    textDni.setText("");
                    textMail.setText("");
                    textPass.setText("");
                }else {
                    JOptionPane.showMessageDialog( null,"Error al introducir variables en la tabla, por favor introduce datos");
                }

            }
        });

        botonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNombre.setText("");
                textApellido.setText("");
                textDni.setText("");
                textMail.setText("");
                textPass.setText("");
            }
        });

        BotonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idBorrar = tablaUsuarios.getSelectedRow();

                try {
                    modelo.removeRow(idBorrar);
                }catch (ArrayIndexOutOfBoundsException exce) {
                    JOptionPane.showMessageDialog( null,"Seleciona una persona para eliminar");
                }


            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int idMod = tablaUsuarios.getSelectedRow();
                try {

                    String nombreCambiar = textNombre.getText();
                    String apellidoCambiar = textApellido.getText();
                    String dniCambiar = textDni.getText();
                    String mailCambiar = textMail.getText();
                    String passCambiar = textPass.toString();


                    String nombreIntroducido = (String) tablaUsuarios.getValueAt(idMod,1);
                    String apellidoIntroducido = (String) tablaUsuarios.getValueAt(idMod,2);
                    String dniIntroducido = (String) tablaUsuarios.getValueAt(idMod,3);
                    String mailIntroducido = (String) tablaUsuarios.getValueAt(idMod,4);
                    String passIntroducido = (String) tablaUsuarios.getValueAt(idMod,5);


                    for(int i=0;i<tablaUsuarios.getRowCount();i++) {
                        if(!nombreCambiar.isEmpty()) {
                            if (!nombreCambiar.equals(nombreIntroducido)) {
                                tablaUsuarios.setValueAt(nombreCambiar, idMod, 1);
                            }
                        }
                        if(!apellidoCambiar.isEmpty()) {
                            if (!apellidoCambiar.equals(apellidoIntroducido)) {
                                tablaUsuarios.setValueAt(apellidoCambiar, idMod, 2);
                            }
                        }
                        if(!dniCambiar.isEmpty()) {

                            if (!dniCambiar.equals(dniIntroducido)) {
                                tablaUsuarios.setValueAt(dniCambiar, idMod, 3);
                            }
                        }if(!mailCambiar.isEmpty()) {


                            if (!mailCambiar.equals(mailIntroducido)) {
                                tablaUsuarios.setValueAt(mailCambiar, idMod, 4);
                            }
                        }
                        if(!passCambiar.isEmpty()) {

                            if (!passIntroducido.equals("False")) {
                                tablaUsuarios.setValueAt("True", idMod, 5);
                            }
                        }

                    }

                }catch (ArrayIndexOutOfBoundsException exce) {
                    JOptionPane.showMessageDialog( null,"Seleciona una persona para eliminar");
                }

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().panelPrin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,550,550);
        frame.setVisible(true);

    }


}

