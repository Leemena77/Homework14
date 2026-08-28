package org.skypro.skyshop.product;
public class DiscountedProduct extends Product {
    private double basePrice;
    private int discountPercent;

    public DiscountedProduct(String name, String description, double basePrice, int discountPercent) {
        super(name, description);
        this.basePrice = basePrice;
        this.discountPercent = Math.max(0, Math.min(100, discountPercent));
    }

    @Override
    public double getPrice() {
        return basePrice * (100 - discountPercent) / 100.0;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }
}