package com.example.practica5;

import com.example.LinkedList;
import javax.swing.*;

public class Letter {
    public LinkedList<String> wordList  ;   
    public char character;
    public JLabel label;
    
    public Letter(char letter, JLabel label){
        this.wordList = new LinkedList<>();       
        this.character = letter;
        this.label = label;
    }

    public void addWord(String newWorld){
        wordList.add(newWorld);
        String text = character + ": " + "";
        for(String word : wordList){
            text = text + ", " + word;
        }
        label.setText(text);
    }
}
