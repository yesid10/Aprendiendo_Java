package forms;

import com.mysql.cj.util.StringUtils;
import dao.ClienteDao;
import models.Cliente;

import javax.swing.*;
import java.awt.event.*;
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
    private JButton btnEditar;
    private JLabel lblid;
    private JButton btnNuevo;
    private JButton conect;

    private List<Cliente> lista = new ArrayList();

    private final void limpiarCajasDeTexto(){
        txtApellido.setText("");
        txtNombre.setText("");
        txtEmail.setText("");
        txtTel.setText("");
        lblid.setText("");
    }

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

                if(!StringUtils.isEmptyOrWhitespaceOnly(lblid.getText())){
                    cliente1.setId(lblid.getText());
                }

                ClienteDao dao = new ClienteDao();
                dao.guardar(cliente1);


                actualizarLista();


                JOptionPane.showMessageDialog(null, "El cliente " + name + " se guardo correctamente.");
                limpiarCajasDeTexto();
            }



        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listClientes.getSelectedIndex();
                Cliente cliente = lista.get(index);

                ClienteDao dao = new ClienteDao();

                dao.eliminar(cliente.getId());

                actualizarLista();
                JOptionPane.showMessageDialog(null,"El Cliente " + cliente.getNombreCompleto() + " fue eliminado correctamente.");
                limpiarCajasDeTexto();
            }

        });


        actualizarLista();

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = listClientes.getSelectedIndex();
                Cliente cliente = lista.get(index);

                txtNombre.setText(cliente.getNombre());
                txtApellido.setText(cliente.getApellido());
                txtTel.setText(cliente.getTelefono());
                txtEmail.setText(cliente.getEmail());
                lblid.setText(cliente.getId());
            }
        });
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCajasDeTexto();
            }
        });
    }

    public void actualizarLista(){
        ClienteDao dao = new ClienteDao();
        lista = dao.listar();

        DefaultListModel datos= new DefaultListModel();

        for(int i=0; i<lista.size(); i++){
            Cliente cliente = lista.get(i);
            datos.addElement(cliente.getNombreCompleto());
        }
        listClientes.setModel(datos);
    }
}
