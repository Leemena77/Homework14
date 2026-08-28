package org.skypro.skyshop.product;
public abstract class Product {
    private final String name;
    private final int price;
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public abstract String getDescription();
}