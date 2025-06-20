//A simple GUI calculator application
//import required libraries (swing, awt, etc.)

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleCalculator extends JFrame{
    
    private JTextField num1Field, num2Field;
    private JLabel resultLabel;

    public SimpleCalculator(){
        //set up the window

        setTitle("Simple Calculator");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        //create the components
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        JButton addButton = new JButton("Add");
        resultLabel = new JLabel("Result: ");

        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 + num2;
                    num1Field.setText("");
                    num2Field.setText("");
                    resultLabel.setText("Result: " + result);
                }catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Numbers only!");
                }
            }
        });

        //add components to the frame
        add(new JLabel("Number 1:"));
        add(num1Field);
        add(new JLabel("Number 2:"));
        add(num2Field);
        add(addButton);
        add(resultLabel);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator().setVisible(true);
        });
    }
}