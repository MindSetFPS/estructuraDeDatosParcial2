package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.example.practica1.AddProductActionListener;
import com.example.practica1.Almacen;
import com.example.practica2.RandomNumberListGenerator;
import com.example.practica2.SplitOddAndEven;
import com.example.practica3.Alumno;
import com.example.practica4.Product;
import com.example.practica4.ProductManager;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;

public class UI {
    JFrame window;
    JTabbedPane tabs;

    public UI() {
        this.init();
        this.practica1();
        this.practica2();
        this.practica3();
        this.practica4();
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

    public void practica1() { /*
                               * Un supermercado nos pide que hagamos una pequeña
                               * aplicación que almacene los productos pasados por el escáner.
                               * 
                               * La aplicación debe almacenar Productos (clase),
                               * cada producto al crearse contiene una cantidad,
                               * un precio (estos dos generados aleatoriamente).
                               * 
                               * El nombre del producto será básico (producto1, producto2, producto3, etc.),
                               * 
                               * permita retirar elementos del mismo almacén de productos
                               * mostrar la cantidad de productos disponibles y retirados
                               * (Para resolver este problema utiliza una lista).
                               */

        JButton ButtonAddProduct = new JButton("Añadir producto");
        JPanel panel = new JPanel();
        JPanel subPanel = new JPanel(new GridBagLayout());
        panel.add(subPanel);
        GridBagConstraints gbc = new GridBagConstraints();
        Almacen almacen = new Almacen(subPanel, gbc);

        ButtonAddProduct.addActionListener(new AddProductActionListener(almacen));
        ButtonAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ola");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(ButtonAddProduct, gbc);
        tabs.addTab("Practica 1", panel);
    }

    public void practica2() {
        RandomNumberListGenerator rand = new RandomNumberListGenerator(5, 1000);
        List<Integer> list = rand.generate();

        String listString = "";

        for (int num : list) {
            listString = listString + Integer.toString(num) + ",";
        }

        JLabel listLabel = new JLabel(listString);

        JButton generatorButton = new JButton("Generar respuestas");
        JPanel panel = new JPanel();

        generatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> even = SplitOddAndEven.getEvens(list);
                List<Integer> odd = SplitOddAndEven.getOdds(list);

                String evenString = "Impares: ";
                String oddString = "Pares: ";

                for (int num : even) {
                    evenString = evenString + Integer.toString(num) + ",";
                }

                JLabel evenLabel = new JLabel(evenString);
                panel.add(evenLabel);

                for (int num : odd) {
                    oddString = oddString + Integer.toString(num) + ",";
                }

                JLabel oddLabel = new JLabel(oddString);
                panel.add(oddLabel);

                panel.validate();
                panel.updateUI();

                System.out.println(list);
                System.out.println(even);
                System.out.println(odd);
            }
        });

        panel.add(generatorButton);
        panel.add(listLabel);
        tabs.addTab("Practica 2", panel);
    }

    public void practica3() {
        List<Alumno> alumnos = new ArrayList<>();
        List<Alumno> aprobados = new ArrayList<>();
        List<Alumno> reprobados = new ArrayList<>();

        JPanel datosPanel = new JPanel();

        JTextField nombreField = new JTextField(10);
        JTextField calificacionField = new JTextField(5);

        // panel.add(datosPanel);
        datosPanel.add(new JLabel("Nombre:"));
        datosPanel.add(nombreField);

        datosPanel.add(new JLabel("Calificación:"));
        datosPanel.add(calificacionField);

        // Text areas para mostrar resultados
        JTextArea aprobarTextArea = new JTextArea(10, 20);
        datosPanel.add(new JScrollPane(aprobarTextArea));
        JTextArea reprobarTextArea = new JTextArea(10, 20);
        datosPanel.add(new JScrollPane(reprobarTextArea));

        // Botón para agregar alumno
        JButton addButton = new JButton("Agregar Alumno");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                int calificacion = Integer.parseInt(calificacionField.getText());
                alumnos.add(new Alumno(nombre, calificacion));
                nombreField.setText("");
                calificacionField.setText("");
                // mostrarAlumnos(aprobarTextArea);
                
                aprobarTextArea.setText("");
                reprobarTextArea.setText("");
                for (Alumno alumno : alumnos) {
                    if(alumno.getCalificacion() > 7){
                        aprobarTextArea.append(alumno.getNombre() + " - Calificación: " + alumno.getCalificacion() + "\n");
                        aprobados.add(alumno);
                    } else {
                        reprobarTextArea.append(alumno.getNombre() + " - Calificación: " + alumno.getCalificacion() + "\n");
                        reprobados.add(alumno);
                    }
                }
                // mostrarReprobados(reprobarTextArea);
            }
        });

        // Botón para calcular reprobados
        JButton calcularButton = new JButton("Calcular Reprobados");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Alumno alumno : alumnos) {
                    if (alumno.getCalificacion() < 7) {
                        reprobarTextArea
                                .append(alumno.getNombre() + " - Calificación: " + alumno.getCalificacion() + "\n");
                        // reprobados.add(alumno);
                    }
                }
            }
        });

        datosPanel.add(addButton);
        // datosPanel.add(calcularButton);

        tabs.addTab("Practica 3", datosPanel);
    }
    
    public void practica4(){
        
        ProductManager productManager = new ProductManager();
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel labelId = new JLabel("Product ID:");
        JTextField textId = new JTextField();
        textId.setPreferredSize(new Dimension(100, 20));

        JLabel labelName = new JLabel("Product Name:");
        JTextField textName = new JTextField();
        textName.setPreferredSize(new Dimension(100, 20));

        JLabel labelPrice = new JLabel("Product Price:");
        JTextField textPrice = new JTextField();
        textPrice.setPreferredSize(new Dimension(100, 20));

        JButton createButton = new JButton("Create Product");
        JLabel resultLabel = new JLabel("result label");
        
        panel.add(labelId, gbc);
        panel.add(textId, gbc);

        gbc.gridy++;
        panel.add(labelName, gbc);
        panel.add(textName, gbc);
        gbc.gridy++;
        panel.add(labelPrice, gbc);
        panel.add(textPrice, gbc);
        gbc.gridy++;
        panel.add(createButton, gbc);
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(resultLabel, gbc);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get values from input fields
                    int id = Integer.parseInt(textId.getText());
                    String name = textName.getText();
                    double price = Double.parseDouble(textPrice.getText());

                    // Create the product
                    Product newProduct = new Product(id, name, price);
                    
                    productManager.addProduct(newProduct);
                    productManager.sortByName();
                    
                    System.out.println(productManager.displayProducts());

                    // Display the created product in the label
                    resultLabel.setText(productManager.displayProducts());
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please check the fields.");
                }
            }
        });
        
        tabs.addTab("Practica 4", panel);
    }

}