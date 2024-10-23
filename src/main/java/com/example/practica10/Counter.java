package com.example.practica10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JFrame {

    private int totalSeconds = 0;
    private boolean running = false;
    private JLabel timeLabel;
    private JButton startButton;
    private Timer timer;

    public Counter() {
        super("Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);

        // create panels
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel(new FlowLayout());

        // add start button
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    running = true;
                    startButton.setText("Stop");
                    updateCounter();
                } else {
                    running = false;
                    timer.stop();
                    timeLabel.setText("00:00");
                    startButton.setText("Start");
                }
            }
        });

        // add label for display
        timeLabel = new JLabel("00:00", SwingConstants.CENTER);

        topPanel.add(startButton);
        bottomPanel.add(new JLabel("Time"));
        bottomPanel.add(timeLabel);

        // set up window layout
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateCounter() {
        totalSeconds = 0;
        this.timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                totalSeconds++;
                String formattedTime = String.format("%02d:%02d", 
                        (totalSeconds / 60) % 60, totalSeconds % 60);
                timeLabel.setText(formattedTime);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Counter();
            }
        });
    }
}
