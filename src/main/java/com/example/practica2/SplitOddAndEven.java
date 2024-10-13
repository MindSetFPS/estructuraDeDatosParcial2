package com.example.practica2;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class SplitOddAndEven {

    public static LinkedList<Integer> getOdds (List<Integer> numeros) {
        LinkedList<Integer> numerosPares = new LinkedList<>();
        List<Integer> numerosImpares = new ArrayList<>();

        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                numerosPares.add(numero);
            } 
        }
        return numerosPares;
    }
    
    public static LinkedList<Integer> getEvens (List<Integer> numeros) {
        LinkedList<Integer> numerosImpares = new LinkedList<>();

        for (Integer numero : numeros) {
            if (numero % 2 != 0) {
                numerosImpares.add(numero);
            } 
        }
        
        return numerosImpares;
    }
}
