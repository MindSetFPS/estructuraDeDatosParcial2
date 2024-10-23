package com.example;

import javax.swing.*;;

public class Stack<T> {

    public int size = 0;
    public Node<T> top; // Reference to the top node of the stack

    /**
     * Constructor for an empty Stack.
     */
    public Stack() {
        top = null;
    }

    /**
     * Pushes a new element onto the top of the stack.
     *
     * @param data The data to be pushed onto the stack.
     */
    public void push(T data) {
        this.size++;
        Node<T> newNode = new Node<>(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The data of the element at the top of the stack, or -1 if the stack
     *         is empty.
     */
    public T pop() {
        this.size--;
        if (top == null) {
            return null; // Stack is empty
        } else {
            T data = top.data;
            top = top.next;
            return data;
        }
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The data of the element at the top of the stack, or -1 if the stack
     *         is empty.
     */
    public T peek() {
        if (top == null) {
            return null; // Stack is empty
        } else {
            return top.data;
        }
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return this.size;
    }

    public Node<T> getTop() {
        return this.top;
    }

    public void printNodes(JLabel text) {
        text.setText("");
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        } else {
            System.out.println("Stack Contents: ");
            text.setText("");
            Node<T> current = top;

            while (current != null) {
                if (current.next == null) {

                    System.out.print(current.data);
                    text.setText(text.getText() + current.data);
                } else {
                    System.out.print(current.data + " -> ");
                    text.setText(text.getText() + current.data + " -> ");
                }

                current = current.next;
            }
            System.out.println();
        }
    }
}