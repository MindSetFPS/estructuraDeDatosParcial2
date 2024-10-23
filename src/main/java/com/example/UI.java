package com.example;

import javax.swing.*;

import com.example.practica10.Practica10;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI {
    JFrame window;
    JTabbedPane tabs;

    public UI() {
        this.init();
        this.practica10();
    }

    public void init() {
        window = new JFrame();
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabs = new JTabbedPane();
        window.add(tabs);
        window.setSize(800, 600);
        window.setVisible(true);
    }
    
    public void practica10(){
        JPanel panel = new JPanel();
        Practica10 practica10 = new Practica10(panel);
        
        tabs.addTab("Pratica 10", panel);
    }
}