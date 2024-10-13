package com.example.practica4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> productList;

    // Constructor
    public ProductManager() {
        productList = new ArrayList<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Method to remove a product by id
    public void removeProductById(int id) {
        productList.removeIf(product -> product.getId() == id);
    }

    // Method to sort products by price (ascending)
    public void sortByPriceAscending() {
        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice));
    }

    // Method to sort products by price (descending)
    public void sortByPriceDescending() {
        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice).reversed());
    }

    // Method to sort products by name (alphabetical order)
    public void sortByName() {
        Collections.sort(productList, Comparator.comparing(Product::getName));
    }

    // Method to display the product list
    public String displayProducts() {
        String result = "";
        for (Product product : productList) {
            result = result + product;
        }
        
        return result;
    }

    // Get the list of products
    public List<Product> getProductList() {
        return productList;
    }
}
