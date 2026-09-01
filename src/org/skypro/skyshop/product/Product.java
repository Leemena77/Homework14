package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть null или пустым");
        }
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return name + ": " + getPrice();
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}