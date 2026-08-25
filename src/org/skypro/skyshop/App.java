package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
public class App {
    public static void main(String[] args) {
        // Создаем продукты
        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 30);
        Product milk = new Product("Молоко", 80);
        Product cheese = new Product("Сыр", 150);
        Product meat = new Product("Мясо", 300);
        Product fish = new Product("Рыба", 250);
        Product juice = new Product("Сок", 100);
        ProductBasket basket = new ProductBasket();
        System.out.println("СЦЕНАРИЙ РАБОТЫ КОРЗИНЫ");

        System.out.println("1. Добавление продуктов в корзину:");
        basket.addProduct(apple);
        System.out.println("   + Добавлен: Яблоко (50)");
        basket.addProduct(bread);
        System.out.println("   + Добавлен: Хлеб (30)");
        basket.addProduct(milk);
        System.out.println("   + Добавлен: Молоко (80)");
        basket.addProduct(cheese);
        System.out.println("   + Добавлен: Сыр (150)");
        basket.addProduct(meat);
        System.out.println("   + Добавлен: Мясо (300)");
        System.out.println();

        System.out.println("2. Попытка добавить продукт в заполненную корзину:");
        basket.addProduct(fish);
        System.out.println();

        System.out.println("3. Печать содержимого корзины:");
        basket.printBasket();
        System.out.println();

        System.out.println("4. Получение стоимости корзины:");
        System.out.println("   Общая стоимость: " + basket.getTotalPrice());
        System.out.println();

        System.out.println("5. Поиск товара, который есть в корзине:");
        System.out.println("   Результат поиска 'Хлеб': " + basket.containsProduct("Хлеб"));
        System.out.println();

        System.out.println("6. Поиск товара, которого нет в корзине:");
        System.out.println("   Результат поиска 'Рыба': " + basket.containsProduct("Рыба"));
        System.out.println();

        System.out.println("7. Очистка корзины:");
        basket.clearBasket();
        System.out.println("   Корзина очищена");
        System.out.println();

        System.out.println("8. Печать содержимого пустой корзины:");
        basket.printBasket();
        System.out.println();

        System.out.println("9. Получение стоимости пустой корзины:");
        System.out.println("   Общая стоимость: " + basket.getTotalPrice());
        System.out.println();

        System.out.println("10. Поиск товара по имени в пустой корзине:");
        System.out.println("   Результат поиска 'Хлеб': " + basket.containsProduct("Хлеб"));
        System.out.println();

        System.out.println("КОНЕЦ СЦЕНАРИЯ");

        System.out.println("ДОПОЛНИТЕЛЬНО: Демонстрация нескольких корзин");

        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        System.out.println("Корзина 1:");
        basket1.addProduct(apple);
        basket1.addProduct(juice);
        basket1.printBasket();

        System.out.println("Корзина 2:");
        basket2.addProduct(fish);
        basket2.addProduct(meat);
        basket2.addProduct(cheese);
        basket2.printBasket();
    }
}