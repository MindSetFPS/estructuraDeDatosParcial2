package com.example.practica11;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import com.example.Stack;

public class Practica11 {
    Stack<Car> carsStack = new Stack<>();
    JPanel carPanel = new JPanel(new GridLayout(1, 3, 5, 0));
    
    Car blackCar = new Car("black.png");
    Car blueCar = new Car("blue.png");
    Car brownCar = new Car("brown.png");
    Car grayCar = new Car("gray.png");
    Car greenCar = new Car("green.png");
    Car orangeCar = new Car("orange.png");
    Car purpleCar = new Car("purple.png");
    Car redCar = new Car("red.png");
    Car whiteCar = new Car("white.png");

    Car[][] cars = {
            { blackCar, blueCar, brownCar },
            { grayCar, greenCar, orangeCar },
            { purpleCar, redCar, whiteCar }
    };
    Color[][] colors = {
            { Color.BLACK, Color.blue, Color.getHSBColor(33, 100, 23) },
            { Color.gray, Color.GREEN, Color.ORANGE },
            { Color.MAGENTA, Color.RED, Color.WHITE }
    };
    JPanel panel;
    int miliseconds = 11000;

    public Practica11(JPanel panel) {
        this.panel = panel;
        panel.add(carPanel);
        this.addCar();
        this.createGrid();
    }

    public void addCar() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hoa");
                if (carsStack.size < 6) {
                    Car topCar = new Car("blue.png", carPanel);
                    carsStack.push(topCar);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 0, miliseconds);

    }

    public void createGrid() {
        JPanel colorSelection = new JPanel();

        // Create a button for each cell of the 3x3 grid
        JButton[][] buttons = new JButton[3][3];

        // GridLayout arranges components in a matrix arrangement.
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        colorSelection.setLayout(layout);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                buttons[i][j] = new JButton("Button " + i + ',' + j);
                buttons[i][j].setBackground(colors[i][j]);
                int currI = i;
                int currJ = j;
                buttons[i][j].addActionListener(arg0 -> {
                    System.out.println(cars[currI][currJ].imagePath);
                    if(carsStack.peek().imagePath  == cars[currI][currJ].imagePath ){
                        System.out.println("correcto");
                        carPanel.remove(this.carsStack.getTop().data.label);
                        carsStack.pop();
                        panel.validate();
                        panel.repaint();
                    }
                });
                gbc.gridx = j;
                gbc.gridy = i;
                colorSelection.add(buttons[i][j], gbc);
                gbc.insets = new Insets(5, 5, 5, 5); // Add insets for spacing
            }
        }
        panel.add(colorSelection);
    }
}
