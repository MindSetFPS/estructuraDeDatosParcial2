package com.example.practica1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddProductActionListener implements ActionListener {
    Almacen almacen;
    Random rand;
    
    public AddProductActionListener(Almacen almacen){
        this.almacen = almacen;
        this.rand = new Random();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Producto latestProduct = new Producto(
            "producto" + almacen.getProductsListSize(),
            rand.nextDouble(),
            rand.nextInt(10)
        );

        almacen.agregarProducto(latestProduct);
        // latestProduct.render(panel, gbc);
        
        almacen.renderProducts();
        
        System.out.println(almacen.getProductsListSize());
        System.out.println(latestProduct.getNombre());
    }
}