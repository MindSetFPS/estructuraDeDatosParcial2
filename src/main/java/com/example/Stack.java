package com.example;

public class Stack {

    public int size = 0;

    // Node class representing each element in the stack
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top; // Reference to the top node of the stack

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
    public void push(int data) {
        this.size++;
        Node newNode = new Node(data);
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
     * @return The data of the element at the top of the stack, or -1 if the stack is empty.
     */
    public int pop() {
        this.size--;
        if (top == null) {
            return 0; // Stack is empty
        } else {
            int data = top.data;
            top = top.next;
            return data;
        }
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The data of the element at the top of the stack, or -1 if the stack is empty.
     */
    public int peek() {
        if (top == null) {
            return -1; // Stack is empty
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
    
    public int getSize(){
        return this.size;
    }
}