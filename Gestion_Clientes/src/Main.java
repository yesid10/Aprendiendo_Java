import forms.FormGestion;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("mainPanel");
        FormGestion formulario = new FormGestion();

        // Agregar el panel principal al JFrame
        frame.setContentPane(formulario.mainPanel);

        // Configurar el tamano del JFrame
        frame.setLocationRelativeTo(null);
        frame.setSize(550, 450);

        // Configurar la operación por defecto al cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}