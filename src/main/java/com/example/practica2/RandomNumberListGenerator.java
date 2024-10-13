package com.example.practica2;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class RandomNumberListGenerator {
        public int size; 
        public int maximo;

        public RandomNumberListGenerator(int size, int maximo){
            this.size = size;
            this.maximo = maximo;
        }

        public LinkedList<Integer> generate(){

            Random random = new Random();
            LinkedList<Integer> listaNumeros = new LinkedList<>();
            
            for (int i = 0; i < size; i++) {
                listaNumeros.add(random.nextInt(maximo));
            }
            
            return listaNumeros;
        }
}
