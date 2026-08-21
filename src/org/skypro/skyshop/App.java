package org.skypro.skyshop;
public class App {
    public static void main(String[] args) {
        ProductBasket.Product apple = new ProductBasket.Product("Яблоко", 50);
        ProductBasket.Product bread = new ProductBasket.Product();
        ProductBasket.Product milk = new ProductBasket.Product("Молоко", 80);
        ProductBasket.Product cheese = new ProductBasket.Product("Сыр", 150);
        ProductBasket.Product meat = new ProductBasket.Product("Мясо", 300);
        ProductBasket.Product fish = new ProductBasket.Product("Рыба", 250);
        ProductBasket.Product juice = new ProductBasket.Product("Сок", 100);
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

        System.out.println("КОНЕЦ СЦЕНАРИЯ ");
        System.out.println("\n\n=== ДОПОЛНИТЕЛЬНО: Демонстрация нескольких корзин ===\n");

        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        System.out.println("Корзина 1:");
        basket1.addProduct(apple);
        basket1.addProduct(juice);
        basket1.printBasket();

        System.out.println("\nКорзина 2:");
        basket2.addProduct(fish);
        basket2.addProduct(meat);
        basket2.addProduct(cheese);
        basket2.printBasket();
    }
}
