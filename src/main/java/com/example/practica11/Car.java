package com.example.practica11;

import javax.swing.*;
import java.awt.*;

public class Car {
    ImageIcon icon;
    public JLabel label = new JLabel();
    String imagePath;
    String[] cars = {"black" ,"blue","brown", "gray","green","orange","red","white"};
    String color = generateColor();
    
    public String generateColor(){
        return cars[(int)(Math.random()*cars.length)];
    }

    public Car(JPanel panel) {
        this.icon = new ImageIcon(new ImageIcon(getClass().getResource("no-color.png")).getImage()
                .getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        this.label.setIcon(icon);
        this.label.setText(color);

        panel.add(this.label);
    }

    public Car(String color) {
        this.color = color;
        this.icon = new ImageIcon(new ImageIcon(getClass().getResource("no-color.png")).getImage()
                .getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        // this.label.setIcon(icon);
        // this.label.setText(imagePath);
    }
}
