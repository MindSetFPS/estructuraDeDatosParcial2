package com.example.practica12;

import java.awt.Dimension;
import java.util.Deque;
import java.util.LinkedList;
import javax.swing.*;

public class Practica12 {
    JPanel panel;
    Deque<Car> carQue = new LinkedList<>();
    
    public Practica12(JPanel panel, JFrame frame){
       this.panel = panel; 
       JMenuBar menuBar = new JMenuBar();
       JMenu menu = new JMenu("Menu");
       JMenuItem input = new JMenuItem("Entrada de autos");
       input.addActionListener(arg0 ->{
           JPanel dialogPanel = new JPanel();
           JDialog dialog = new JDialog(frame);
           dialog.setSize(500, 300);
           JLabel placa = new JLabel("Placa");
           JTextField placaTextField = new JTextField("");

           JLabel owner = new JLabel("Dueño");
           JTextField ownerTextField = new JTextField("");

           JButton save = new JButton("Guardar");
           save.addActionListener(arg -> {
            System.out.println("guardando");
            Car car = new Car(placaTextField.getText(), ownerTextField.getText());
            carQue.add(car);
            System.out.println(carQue.size());
           });
           
           placaTextField.setPreferredSize(new Dimension(100, 20));
           ownerTextField.setPreferredSize(new Dimension(100, 20));
           
           dialogPanel.add(placa);
           dialogPanel.add(placaTextField);
           
           dialogPanel.add(owner);
           dialogPanel.add(ownerTextField);
           dialogPanel.add(save);
           dialog.add(dialogPanel);
           dialog.setVisible(true);
       });

       JMenuItem output = new JMenuItem("Salida de autos");
       
       output.addActionListener(argx -> {
           JPanel dialogPanel = new JPanel();
           JDialog dialog = new JDialog(frame);
           
           carQue.forEach(arg0 -> {
            JLabel newLbel = new JLabel(arg0.toString());
            dialogPanel.add(newLbel);
           });
           
           dialog.setSize(700, 300);
 
           dialog.add(dialogPanel);
           dialog.setVisible(true);
       
       });
       
        menu.add(input);
        menu.add(output);
        menuBar.add(menu);

       this.panel.add(menuBar);
    }
}
