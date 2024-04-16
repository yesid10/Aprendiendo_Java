import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        JFrame frame = new JFrame("mainPanel");
        Form formulario = new Form();

        // Agregar el panel principal al JFrame
        frame.setContentPane(formulario.mainPanel);

        // Configurar el tamano del JFrame
        frame.setLocationRelativeTo(null);
        frame.setSize(450, 400);

        // Configurar la operación por defecto al cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}