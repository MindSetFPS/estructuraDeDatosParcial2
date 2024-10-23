package com.example.practica9;

import com.example.Stack;
import com.example.StackNode;
import javax.swing.*;

public class Replacer{
    public void Replacer(){
    }
    
    public void replace( Stack stack, int oldNumber, int newNumber){
        StackNode currentNode = stack.top;
        while (currentNode != null) {
            if (currentNode.data == oldNumber) {
                currentNode.data = newNumber;
            }

            if (currentNode.next != null) {
                currentNode = currentNode.next;
            } else {
                break;
            }
        }

    }

}