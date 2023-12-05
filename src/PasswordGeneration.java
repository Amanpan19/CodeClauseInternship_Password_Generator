import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGeneration {

    private JTextField lengthField;


    public PasswordGeneration(){
        JFrame jFrame = new JFrame("Password Generator");
        JPanel jPanel = new JPanel();
        lengthField = new JTextField(10);
        JTextField passwordGenerated = new JTextField(10);
        JButton jButton = new JButton();


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400,200);
        jFrame.setVisible(true);


        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        jPanel.setBorder(new EmptyBorder(10,10,10,10));


        lengthField.setSize(100,10);

        jButton.setText("Generate Password");
        jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButton.setSize(250,40);
        jButton.setBorder(new EmptyBorder(10,10,10,10));
        jButton.setBackground(Color.orange);
        jButton.setForeground(Color.white);


        jPanel.add(new Label("Enter the length of password"));
        jPanel.add(lengthField);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = Integer.parseInt(lengthField.getText());
                String pass = passwordGen(length);

                passwordGenerated.setText(pass);
                passwordGenerated.setSize(200,30);
            }
        });
        jPanel.add(jButton);
        jPanel.add(new Label("Your Password :"));
        jPanel.add(passwordGenerated);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(jPanel,BorderLayout.CENTER);

    }
    public static String passwordGen(int length){
        StringBuilder pass= new StringBuilder();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!%@#$&_-+()";

        Random rand = new Random();
        while (pass.length()<length){
            int index = (int) (rand.nextFloat()*chars.length());
//            System.out.println(index);
            pass.append(chars.charAt(index));
        }
        return pass.toString();
    }

    public static void main(String[] args) {
        new PasswordGeneration();
    }
}

