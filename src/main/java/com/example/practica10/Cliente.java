package com.example.practica10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cliente {
    private int numeroTurno;
    private String nombre;
    private String tipoMovimiento;
    private LocalDateTime horaLlegada;

    // Constructor vacío para inicializar atributos con valores por defecto
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(int numeroTurno, String nombre, String tipoMovimiento, String horaLlegada) {
        this.numeroTurno = numeroTurno;
        this.nombre = nombre;
        this.tipoMovimiento = tipoMovimiento;

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.horaLlegada = LocalDateTime.parse(horaLlegada, formatoHora);
    }

    // Getters y setters
    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Cliente{" +
                "numeroTurno=" + numeroTurno +
                ", nombre='" + nombre + '\'' +
                ", tipoMovimiento='" + tipoMovimiento + '\'' +
                ", horaLlegada=" + horaLlegada.format(formatoHora) +
                '}';
    }
}
