package com.example.practica1;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Producto {
    public String nombre;
    private double precio;
    private int cantidad;
    private Almacen almacen;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public int setCantidad(int newAmount){
        cantidad = newAmount;
        return cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public void render(JPanel panel, JButton deleteButton , GridBagConstraints gbc){
        JLabel label = new JLabel(nombre);
        // gbc.gridy = gbc.gridy + 1;
        gbc.gridx = 0;
        panel.add(label, gbc);
        gbc.gridx++;
        panel.add(deleteButton, gbc);
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + ", Precio: $" + String.format("%.2f", precio) + ", Cantidad: " + cantidad;
    }
}
