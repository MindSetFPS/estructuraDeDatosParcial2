package com.example.practica5;

import javax.swing.*;

import com.example.LinkedList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practica5 {
    /* Crea una aplicación para almacenar palabras (solicitadas al usuario),
     * la aplicación debe de separar las palabras
     * y dividirlas en listas clasificadas por la primera
     * letra de la palabra es decir todas las palabras que coincidan en la primera letra,
     * se muestra un ejemplo:
     * Lista1: Fresa, Fresca, Orilla, Oso, Peso, Pez
     * Lista2: Fresa, Fresca
     * Lista3: Orilla, Oso
     * Lista4: Peso, Pez                                                             */
    public JPanel panel;
    public LinkedList<String> globalWordList;
    public LinkedList<Letter> alphabet;
    public String letters = "abcdefghijklmnopqrstuvwxyz";
    public GridBagConstraints gbc = new GridBagConstraints();

    public Practica5(JPanel panel) {
        this.panel = panel;
        this.globalWordList = new LinkedList<>();
        this.alphabet = new LinkedList<>();
        this.setupUI();
        this.setupLists();
    }
    
    public void setupLists(){
        for(char c : letters.toCharArray()){
            JLabel label = new JLabel("");
            Letter letter = new Letter(c, label);
            panel.add(label, gbc);
            gbc.gridy++;
            alphabet.add(letter);
        }
    }
    
    public void setupUI() {
        JLabel label = new JLabel();

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 28));

        JButton button = new JButton("Add word");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                String text = textField.getText(); // extract text from input field
                text = text.toLowerCase();
                String[] splitText = text.split("\\s+"); // split words from input field
                                                         
                for (String word : splitText) {
                    globalWordList.add(word);
                    
                    int letterIndex = letters.indexOf(word.charAt(0));

                    if (letterIndex != -1) {
                        Letter foundLetter = alphabet.get(letterIndex);
                        foundLetter.addWord(word);

                    } else {
                        System.out.println("Character not found in the string.");
                    }

                }
                textField.setText("");
            }
        });

        gbc.gridy = 0;
        gbc.gridx = 0;
        panel.add(textField, gbc);
        gbc.gridx++;
        panel.add(button,gbc);
        panel.add(label);
        gbc.gridy++;
    }

    public void createTextInput() {
    }

    public void classifyWord() {
    }
}