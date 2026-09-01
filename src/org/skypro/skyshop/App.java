package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);

        var apple = new Product("Яблоко", 50) {
            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        var bread = new Product("Хлеб", 30) {
            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        var milk = new Product("Молоко", 80) {
            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        var cheese = new Product("Сыр", 150) {
            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        var meat = new Product("Мясо", 300) {
            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        var fish = new Product("Рыба", 250) {
            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        var juice = new Product("Сок", 100) {
            @Override
            public boolean isSpecial() {
                return false;
            }
        };
        var chocolate = new Product("Шоколад", 120) {
            @Override
            public boolean isSpecial() {
                return false;
            }
        };

        Article appleArticle = new Article(
                "Польза яблок",
                "Яблоки богаты витаминами и клетчаткой. Они укрепляют иммунитет и улучшают пищеварение."
        );

        Article breadArticle = new Article(
                "Как выбрать хлеб",
                "При выборе хлеба обращайте внимание на состав. Качественный хлеб должен быть без добавок и консервантов."
        );

        Article milkArticle = new Article(
                "Польза молока",
                "Молоко содержит кальций, который необходим для здоровья костей и зубов."
        );

        Article meatArticle = new Article(
                "Как выбрать мясо",
                "При выборе мяса обращайте внимание на цвет, запах и упругость. Свежее мясо имеет приятный запах."
        );

        System.out.println("ДОБАВЛЕНИЕ ЭЛЕМЕНТОВ В ПОИСК");

        searchEngine.add(apple);
        System.out.println("+ Добавлен: Яблоко (PRODUCT)");
        searchEngine.add(bread);
        System.out.println("+ Добавлен: Хлеб (PRODUCT)");
        searchEngine.add(milk);
        System.out.println("+ Добавлен: Молоко (PRODUCT)");
        searchEngine.add(cheese);
        System.out.println("+ Добавлен: Сыр (PRODUCT)");
        searchEngine.add(meat);
        System.out.println("+ Добавлен: Мясо (PRODUCT)");
        searchEngine.add(fish);
        System.out.println("+ Добавлен: Рыба (PRODUCT)");
        searchEngine.add(juice);
        System.out.println("+ Добавлен: Сок (PRODUCT)");
        searchEngine.add(chocolate);
        System.out.println("+ Добавлен: Шоколад (PRODUCT)");
        searchEngine.add(appleArticle);
        System.out.println("+ Добавлена: Польза яблок (ARTICLE)");
        searchEngine.add(breadArticle);
        System.out.println("+ Добавлена: Как выбрать хлеб (ARTICLE)");
        searchEngine.add(milkArticle);
        System.out.println("+ Добавлена: Польза молока (ARTICLE)");
        searchEngine.add(meatArticle);
        System.out.println("+ Добавлена: Как выбрать мясо (ARTICLE)");

        System.out.println("\nВсего элементов в движке: " + searchEngine.getSize());

        System.out.println(" ПОИСК ");

        String[] queries = {"хлеб", "молоко", "выбор", "польза", "яблоко", "рыба", "овощи"};

        for (String query : queries) {
            System.out.println("Поиск по запросу: '" + query + "'");
            Searchable[] results = searchEngine.search(query);

            boolean found = false;
            for (int i = 0; i < results.length; i++) {
                if (results[i] != null) {
                    System.out.println("  " + (i + 1) + ". " + results[i].getStringRepresentation());
                    found = true;
                }
            }

            if (!found) {
                System.out.println("  Ничего не найдено");
            }
            System.out.println();
        }

        System.out.println(" РАБОТА КОРЗИНЫ ");

        ProductBasket basket = new ProductBasket();

        System.out.println("1. Добавление продуктов в корзину:");
        basket.addProduct(apple);
        System.out.println("   + Яблоко");
        basket.addProduct(bread);
        System.out.println("   + Хлеб");
        basket.addProduct(milk);
        System.out.println("   + Молоко");
        basket.addProduct(cheese);
        System.out.println("   + Сыр");
        basket.addProduct(meat);
        System.out.println("   + Мясо");

        System.out.println("\n2. Попытка добавить 6-й продукт:");
        basket.addProduct(fish);

        System.out.println("\n3. Содержимое корзины:");
        basket.printBasket();

        System.out.println("\n4. Общая стоимость: " + basket.getTotalPrice());

        System.out.println("\n5. Поиск товара 'Хлеб' в корзине:");
        System.out.println("   Результат: " + basket.containsProduct("Хлеб"));

        System.out.println("\n6. Поиск товара 'Рыба' в корзине:");
        System.out.println("   Результат: " + basket.containsProduct("Рыба"));

        System.out.println("\n7. Очистка корзины:");
        basket.clearBasket();

        System.out.println("\n8. Содержимое пустой корзины:");
        basket.printBasket();

        System.out.println("\n9. Стоимость пустой корзины: " + basket.getTotalPrice());

        System.out.println("\n10. Поиск в пустой корзине:");
        System.out.println("    Результат поиска 'Хлеб': " + basket.containsProduct("Хлеб"));

    }
}