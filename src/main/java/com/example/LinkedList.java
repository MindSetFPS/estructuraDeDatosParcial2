package com.example;
import java.util.*;

public class LinkedList<T> implements Iterable<T> {
    public Node<T> head;
    public int size;
    
    public LinkedList(){
        this.head = null;
        this.size = 0;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new LinkedListIterator<>(this);
    }
    
    public static class LinkedListIterator<T> implements Iterator<T> {
        private Node<T> current;
        private boolean canRemove = false;
        
        public LinkedListIterator(LinkedList<T> linkedList) {
            this.current = linkedList.head;
        }
        
        @Override
        public boolean hasNext(){
            return current != null;
        }
        
        @Override
        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
        
        @Override
        public void remove(){
            if(!canRemove){
                throw new IllegalStateException("Cannot remove from an iterator");
            }
            Node<T> previous = getPrevious(current);
            previous.next = current.next;
            canRemove = false;
        }
        
        private Node<T> getPrevious(Node<T> node) {
            // Node<T> current = head;
            while (current != null && current.next != node){
                current = current.next;
            }
            if(current == null){
                throw new RuntimeException("Node not found in list");
            }
            return current;
        }
    }
    
    public void add (T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null){
                current = current.next; // Makes the iteration move ahead
            }
            current.next = newNode;
        }
        size++;
    }
    
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }
}
