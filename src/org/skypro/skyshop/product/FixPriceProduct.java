package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100; // Фиксированная цена

    public FixPriceProduct(String name) {
        super(name, FIX_PRICE);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (Фиксированная цена)";
    }
}