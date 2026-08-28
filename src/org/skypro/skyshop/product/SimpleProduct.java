package org.skypro.skyshop.product;
public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(String name, String description) {
        super(name, Integer.parseInt(description));
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
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