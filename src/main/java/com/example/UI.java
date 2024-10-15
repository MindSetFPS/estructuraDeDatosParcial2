package com.example;

import javax.swing.*;

import com.example.practica1.AddProductActionListener;
import com.example.practica1.Almacen;
import com.example.practica2.RandomNumberListGenerator;
import com.example.practica2.SplitOddAndEven;
import com.example.practica3.Alumno;
import com.example.practica4.Product;
import com.example.practica4.ProductManager;
import com.example.practica5.Practica5;
import com.example.practica6.Practica6;

import java.util.List;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI {
    JFrame window;
    JTabbedPane tabs;

    public UI() {
        this.init();
        // this.practica1();
        // this.practica2();
        // this.practica3();
        // this.practica4();
        // this.practica5();
        // this.practica6();
        // this.practica7();
        this.Practica8();
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

    public void practica1() {

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

                aprobarTextArea.setText("");
                reprobarTextArea.setText("");
                for (Alumno alumno : alumnos) {
                    if (alumno.getCalificacion() > 7) {
                        aprobarTextArea
                                .append(alumno.getNombre() + " - Calificación: " + alumno.getCalificacion() + "\n");
                        aprobados.add(alumno);
                    } else {
                        reprobarTextArea
                                .append(alumno.getNombre() + " - Calificación: " + alumno.getCalificacion() + "\n");
                        reprobados.add(alumno);
                    }
                }
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
                    }
                }
            }
        });

        datosPanel.add(addButton);

        tabs.addTab("Practica 3", datosPanel);
    }

    public void practica4() {

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

    public void practica5() {
        JPanel panel = new JPanel(new GridBagLayout());
        Practica5 practica5 = new Practica5(panel);
        tabs.addTab("Practica 5", panel);
    }

    public void practica6() {

        Practica6 practica6 = new Practica6();

LinkedList<Character> letters = new LinkedList<>();
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel reversedText = new JLabel("");

        JTextField word = new JTextField();
        word.setPreferredSize(new Dimension(100, 28));

        JButton button = new JButton("Reverse");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

String text = word.getText(); // extract text from input field
                text = text.toLowerCase();
                for (char c : text.toCharArray()) {
                    System.out.println(c);
                    letters.add(c);
                }

                String reversedLetters = "";

                for (int i = letters.size - 1; i >= 0; i--) {
                    System.out.println(i);
                    reversedLetters = reversedLetters + letters.get(i);
                }
                reversedText.setText(reversedLetters);
            }
        });
        panel.add(word);
        panel.add(button);
        panel.add(reversedText);

        tabs.addTab("Practica6", panel);
    }

    public void practica7(){
        JPanel panel = new JPanel();
        LinkedList<Character> letters = new LinkedList<>();
        JLabel reversedText = new JLabel("");

        JTextField word = new JTextField();
        word.setPreferredSize(new Dimension(100, 28));

        JButton button = new JButton("Reverse");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String text = word.getText(); // extract text from input field
                text = text.replace(" ", "");
                text = text.toLowerCase();
                for(char c : text.toCharArray()){
                    letters.add(c);
                }
                
                String reversedLetters =  "";

                for(int i = letters.size -1; i >= 0; i--){
                    System.out.println(i);
                    reversedLetters = reversedLetters + letters.get(i);
                }
                
                System.out.println(reversedLetters + "===" + text);
                if(reversedLetters.equals(text)){
                    System.out.println("ES PALINDROMO");
                }
                reversedText.setText(reversedLetters);
            }
        });
        panel.add(word);
        panel.add(button);
        panel.add(reversedText);

        tabs.addTab("Practica7", panel);
    }
    public void Practica8(){

        // Realiza  una  aplicación  que  mediante  pilas  sume  números  enteros  muy  grandes,  puedes 
        // leer los números como string, ingresarlos cada uno de ellos a una pila y realizar la suma.
        
        JPanel panel = new JPanel();
        tabs.addTab("Practica8", panel);

    }
}