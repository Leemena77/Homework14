package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Collection;
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

    public int getTotalPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(product -> (int) product.getPrice())
                .sum();
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }
    public void printBasket() {
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(product.toString()));

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }
}