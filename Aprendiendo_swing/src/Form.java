import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {
    public JPanel mainPanel;
    private JButton btnCalcular;
    private JTextField txtAltura;
    private JTextField txtPeso;


    public  Form() {
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double altura = Double.parseDouble(txtAltura.getText());
                Double peso = Double.parseDouble(txtPeso.getText());
                Double imc = (peso/Math.pow(altura,2));
                JOptionPane.showMessageDialog(null, "Su IMC es: " + imc);
            }
        });
    }
}
