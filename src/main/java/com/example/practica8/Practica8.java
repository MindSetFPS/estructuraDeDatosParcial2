package com.example.practica8;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.example.Stack;
import com.example.LinkedList;

// Cola - Que: First in First out
// Pila - Stack : First in Last out
// Realiza una aplicación que mediante pilas sume números enteros muy grandes,
// leer los números como string, ingresarlos cada uno de ellos a una pila y
// realizar la suma.

public class Practica8 {

    public Stack firstStack = new Stack();
    public Stack secondStack = new Stack();
    public Stack resultStack = new Stack();

    public JPanel panel;

    public Practica8(JPanel panel) {
        this.panel = panel;
        this.init();
    }

    public void init() {
        // 1. Input both numbers
        JTextField firstNumber = new JTextField();
        JTextField secondNumber = new JTextField();

        firstNumber.setPreferredSize(new Dimension(100, 28));
        secondNumber.setPreferredSize(new Dimension(100, 28));

        // 2. Convert each number no a list
        JButton button = new JButton("sumar");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                for (char c : firstNumber.getText().toCharArray()) {
                    firstStack.push(Character.getNumericValue(c));
                }

                for (char c : secondNumber.getText().toCharArray()) {
                    secondStack.push(Character.getNumericValue(c));
                }

                sumNumbers(firstStack.pop(), secondStack.pop());

                System.out.print("el resultado es: ");
                while (resultStack.size != 0) {
                    System.out.print(resultStack.pop());
                }
            }
        });
        // 3. Sum numbers
        // 4. Add result to result stack
        panel.add(firstNumber);
        panel.add(secondNumber);
        panel.add(button);
    }

    public void sumNumbers(int firstNumber, int secondNumber) {
        if((firstStack.isEmpty() && secondStack.isEmpty())) {
            if (firstNumber <= 0 && secondNumber <= 0) return;
        }
        System.out.println("sumando: " + firstNumber + "+" + secondNumber);
        int sum = firstNumber + secondNumber;

        if (sum > 9) {
            System.out.println(sum + "es mayor que 9");
            System.out.println("sobran " + (sum - 10));
            resultStack.push(sum - 10);
            System.out.print("pasando ");
            System.out.println(firstStack.peek() + 1 + secondStack.peek());
            sumNumbers(firstStack.pop() + 1, secondStack.pop());
            // return 0;
        } else {
            System.out.println(sum);
            resultStack.push(sum);
            // return sum;
        }

        System.out.println("first stack has: " + firstStack.peek());
        System.out.println("second stack has: " + secondStack.peek());
        sumNumbers(firstStack.pop(), secondStack.pop());
        /*
         * if(firstNumber == 0 || secondNumber == 0){
         * System.out.println("hay un zero");
         * } else {
         * System.out.println("no hay zeros");
         * }
         */

        // resultStack.push(firstNumber + secondNumber);
    }

}
