package org.skypro.skyshop.product;
public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(String name, String description, double price) {
        super(name, Integer.parseInt(description));
        this.price = price;
    }

    @Override
    public int getPrice() {
        return (int) price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}