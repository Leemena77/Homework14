package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name + ": " + price;
    }

    @Override
    public String getSearchTerm() {
        return name; // Возвращаем имя товара
    }

    @Override
    public String getContentType() {
        return "PRODUCT"; // Тип контента
    }
}