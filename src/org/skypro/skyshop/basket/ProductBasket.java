package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = products.remove(name);
        return removed != null ? removed : new ArrayList<>();
    }

    public void removeProduct(Product product) {
        String name = product.getName();
        List<Product> list = products.get(name);
        if (list != null) {
            list.remove(product);
            if (list.isEmpty()) {
                products.remove(name);
            }
        }
    }

    public List<Product> getProductsByName(String name) {
        return products.getOrDefault(name, new ArrayList<>());
    }

    public void printBasket() {
        double total = 0;
        int specialCount = 0;

        for (List<Product> list : products.values()) {
            for (Product product : list) {
                System.out.println(product.toString());
                total += product.getPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }
}