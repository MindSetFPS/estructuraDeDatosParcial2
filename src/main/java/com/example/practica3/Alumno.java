package com.example.practica3;

public class Alumno {
    private String nombre;
    private int calificacion;

    public Alumno(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }
}