package com.example.practica11;
import java.time.format.DateTimeFormatter;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import com.example.Stack;

import java.time.Duration;
import java.time.LocalDateTime;

public class Practica11 {
    Stack<Car> carsStack = new Stack<>();
    JPanel carPanel = new JPanel(new GridLayout(1, 3, 5, 0));

    LocalDateTime beginTime = LocalDateTime.now();;
    LocalDateTime finishTime;
    Duration playingTime;
    int scorel = 0;

    Car blackCar = new Car("black");
    Car blueCar = new Car("blue");
    Car brownCar = new Car("brown");
    Car grayCar = new Car("gray");
    Car greenCar = new Car("green");
    Car orangeCar = new Car("orange");
    Car purpleCar = new Car("purple");
    Car redCar = new Car("red");
    Car whiteCar = new Car("white");

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

    public Practica11(JPanel panel) {
        this.panel = panel;
        panel.add(carPanel);
        this.addCar();
        this.createGrid();
    }

    public Timer timer;
    int seconds = 0;
    int limit = 20;
    int steps = 1;

    public void addCar() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (carsStack.size == 5 - 1) {
                    timer.cancel();


                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime horaSalida = LocalDateTime.now();
                    beginTime.format(formatoHora);
                    Duration diference = Duration.between(beginTime, horaSalida);
                    String durationString = diference.toString().replace("PT", " ").replace("H", " horas, ").replace("M", " minutos, ").replace("S", " segundos.");
                    JOptionPane.showMessageDialog(
                            carPanel,
                            durationString + "\n puntaje: " + scorel,
                            "Usuario atendido.",
                            JOptionPane.OK_OPTION);


                }
                Car topCar = new Car(carPanel);
                carsStack.push(topCar);
                seconds++;
                System.out.println(seconds);
                panel.revalidate();
                panel.repaint();
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 1000);
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
                    System.out.println(cars[currI][currJ].color + "==" + carsStack.peek().color);
                    if (carsStack.peek().color == cars[currI][currJ].color) {
                        System.out.println("correcto");
                        scorel++;
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
