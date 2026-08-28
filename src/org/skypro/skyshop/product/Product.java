package org.skypro.skyshop.product;
public abstract class Product {
    private String name;
    private String description;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract double getPrice();

    // Метод для определения специального товара
    public boolean isSpecial() {
        return false;
    }

    @Override
    public abstract String toString();
}