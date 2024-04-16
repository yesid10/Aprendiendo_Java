import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormGestion {
    public JPanel mainPanel;
    private JTextField txtName;
    private JButton btnGuardar;
    private JList listClientes;
    private JButton btnEliminar;

    List<String> array = new ArrayList<String>();
    public FormGestion() {
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                array.add(name);
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
                    nameSlected = array.get(index);
                }
                array.remove(index);
                actualizarLista();
                JOptionPane.showMessageDialog(null,"El Cliente " + nameSlected + " fue eliminado correctamente.");
            }
        });
    }

    private void actualizarLista(){
        DefaultListModel datos= new DefaultListModel();
        for(int i=0; i<array.size(); i++){
            String name = array.get(i);
            datos.addElement(name);
        }
        listClientes.setModel(datos);
    }
}
