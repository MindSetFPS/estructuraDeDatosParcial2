package com.example.practica1;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.util.LinkedList;
import java.awt.GridBagConstraints;

public class Almacen {
    private LinkedList<Producto> productos;
    private int totalRetirados;
    private JPanel panel;
    private GridBagConstraints gbc;

    public Almacen(JPanel panel, GridBagConstraints gbc) {
        this.productos = new LinkedList<>();
        this.totalRetirados = 0;
        this.panel = panel;
        this.gbc = gbc;
    }

    public int getProductsListSize() {
        return productos.size();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void removeProduct(String id) {
        int index = 0;
        for (Producto p : productos) {
            if (p.nombre == id) {
                System.err.println("borrando producto " + index);
                productos.remove(index);
                break;
            }
            index++;
            panel.revalidate();
            panel.repaint();
        }
    }

    public void renderProducts() {
        panel.removeAll();
        for (Producto product : this.productos) {

            JButton ButtonDelete = new JButton("borrar");
            ButtonDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeProduct(product.nombre);
                    panel.revalidate();
                    panel.repaint();
                    totalRetirados = totalRetirados + 1;
                    System.out.println(totalRetirados);
                }
            });

            gbc.gridy++;
            product.render(panel, ButtonDelete, gbc);
        }
        panel.revalidate();
        panel.repaint();
    }

    public Producto retirarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equals(nombre)) {
                if (p.getCantidad() > 0) {
                    p.setCantidad(p.getCantidad() - 1);
                    this.totalRetirados++;
                    return p;
                } else {
                    System.out.println("No hay suficientes " + nombre + " en stock.");
                    return null;
                }
            }
        }
        System.out.println("No se encontró el producto solicitado.");
        return null;
    }

    public int getTotalRetirados() {
        return totalRetirados;
    }

    @Override
    public String toString() {
        StringBuilder productosString = new StringBuilder();
        for (Producto p : this.productos) {
            productosString.append(p).append("\n");
        }
        return "Almacen:\n" + productosString.toString() + "\nTotal retirados: " + totalRetirados;
    }
}
