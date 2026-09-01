package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private static final int MAX_CAPACITY = 5;
    private final Product[] products;
    private int size;

    public ProductBasket() {
        this.products = new Product[MAX_CAPACITY];
        this.size = 0;
    }

    public void addProduct(Product product) {
        if (size < MAX_CAPACITY) {
            products[size] = product;
            size++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                total += products[i].getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        for (int i = 0; i < size; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getName() + ": " + products[i].getPrice());
            }
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < size; i++) {
            if (products[i] != null && products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
    }

    public int getSize() {
        return size;
    }
}