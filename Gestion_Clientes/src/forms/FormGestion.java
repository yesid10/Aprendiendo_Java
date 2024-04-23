package forms;

import dao.ClienteDao;
import models.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormGestion {
    public JPanel mainPanel;
    private JTextField txtNombre;
    private JButton btnGuardar;
    private JList listClientes;
    private JButton btnEliminar;
    private JTextField txtApellido;
    private JTextField txtEmail;
    private JTextField txtTel;
    private JButton conect;

    List<Cliente> array = new ArrayList<Cliente>();
    public FormGestion() {
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtNombre.getText();

                Cliente cliente1 = new Cliente();
                cliente1.setNombre(txtNombre.getText());
                cliente1.setApellido(txtApellido.getText());
                cliente1.setEmail(txtEmail.getText());
                cliente1.setTelefono(txtTel.getText());


                array.add(cliente1);
                actualizarLista();
                JOptionPane.showMessageDialog(null, "El cliente " + name + " se guardo correctamente.");
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listClientes.getSelectedIndex();
                String nameSlected = "";
                for(int i=0; i< array.size(); i++){
                    nameSlected = String.valueOf(array.get(index));
                }
                array.remove(index);
                actualizarLista();
                JOptionPane.showMessageDialog(null,"El models.Cliente " + nameSlected + " fue eliminado correctamente.");
                limpiarCajasDeTexto();
            }
            private void limpiarCajasDeTexto(){
                txtApellido.setText("");
                txtNombre.setText("");
                txtEmail.setText("");
                txtTel.setText("");
            }
        });
        conect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDao dao = new ClienteDao();
                dao.Conectar();
            }
        });
    }

    private void actualizarLista(){
        DefaultListModel datos= new DefaultListModel();
        for(int i=0; i<array.size(); i++){
            Cliente cliente = array.get(i);
            datos.addElement(cliente.getNombreCompleto());
        }
        listClientes.setModel(datos);
    }
}
