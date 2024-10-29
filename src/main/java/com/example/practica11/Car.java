package com.example.practica11;

import javax.swing.*;
import java.awt.*;

public class Car {
    ImageIcon icon;
    public JLabel label = new JLabel();
    String imagePath;

    public Car(String imagePath, JPanel panel) {
        this.imagePath = imagePath;
        this.icon = new ImageIcon(new ImageIcon(getClass().getResource(imagePath)).getImage()
                .getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        this.label.setIcon(icon);
        this.label.setText(imagePath);

        panel.add(this.label);
    }

    public Car(String imagePath) {
        this.imagePath = imagePath;
        this.icon = new ImageIcon(new ImageIcon(getClass().getResource(imagePath)).getImage()
                .getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        this.label.setIcon(icon);
        this.label.setText(imagePath);
    }
}
