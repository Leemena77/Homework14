package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Книга", "Интересная книга", 500));
        basket.addProduct(new SimpleProduct("Тетрадь", "48 листов", 80));
        basket.addProduct(new SimpleProduct("Карандаш", "Простой", 25));

        basket.addProduct(new DiscountedProduct("Детектив", "Классика", 500, 10));
        basket.addProduct(new DiscountedProduct("Ноутбук", "Игровой", 1000, 20));
        basket.addProduct(new DiscountedProduct("Фен", "Стайлер", 3000, 15));
        basket.addProduct(new DiscountedProduct("Кроссовки", "Спортивные", 2500, 30));

        basket.addProduct(new FixPriceProduct("Набор ручек", "10 цветных ручек"));
        basket.addProduct(new FixPriceProduct("Блокнот", "А5, 50 листов"));
        basket.addProduct(new FixPriceProduct("Календарь", "Настенный"));
        basket.addProduct(new FixPriceProduct("Магнит", "Сувенирный"));

        System.out.println("СОДЕРЖИМОЕ КОРЗИНЫ");
        basket.printBasket();

        System.out.println("ДЕТАЛЬНАЯ ИНФОРМАЦИЯ");

        int itemNumber = 1;
        for (Product product : basket.getProducts()) {
            System.out.println("Товар #" + itemNumber++);
            System.out.println("  Название: " + product.getName());
            System.out.println("  Описание: " + product.getDescription());
            System.out.println("  Цена: " + product.getPrice());
            System.out.println("  Специальный: " + (product.isSpecial() ? "Да" : "Нет"));
            System.out.println("  Строка вывода: " + product.toString());
            System.out.println();
        }

        System.out.println("ПРОВЕРКА МЕТОДОВ ");

        testSpecialMethod();
    }

    private static void testSpecialMethod() {
        Product simple = new SimpleProduct("Тестовый", "Обычный", 100);
        Product discounted = new DiscountedProduct("Тестовый", "Со скидкой", 100, 10);
        Product fixPrice = new FixPriceProduct("Тестовый", "Фиксированная цена");

        System.out.println("SimpleProduct isSpecial: " + simple.isSpecial() + " (должен быть false)");
        System.out.println("DiscountedProduct isSpecial: " + discounted.isSpecial() + " (должен быть true)");
        System.out.println("FixPriceProduct isSpecial: " + fixPrice.isSpecial() + " (должен быть true)");
    }
}