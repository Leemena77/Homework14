package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;

public class App {
    public static void main(String[] args) {
        System.out.println("1. ДЕМОНСТРАЦИЯ ОБРАБОТКИ НЕВАЛИДНЫХ ДАННЫХ ");

        System.out.println(" 1.1 Тестирование SimpleProduct ");
        try {
            SimpleProduct invalidName = new SimpleProduct("", 50);
            System.out.println("Создан продукт: " + invalidName);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }
        try {
            SimpleProduct nullName = new SimpleProduct(null, 50);
            System.out.println("Создан продукт: " + nullName);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }
        try {
            SimpleProduct zeroPrice = new SimpleProduct("Товар", 0);
            System.out.println("Создан продукт: " + zeroPrice);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }
        try {
            SimpleProduct negativePrice = new SimpleProduct("Товар", -10);
            System.out.println("Создан продукт: " + negativePrice);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }

        System.out.println(" 1.2 Тестирование DiscountedProduct ");

        try {
            DiscountedProduct zeroBasePrice = new DiscountedProduct("Сыр", 0, 20);
            System.out.println("Создан продукт: " + zeroBasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }
        try {
            DiscountedProduct negativeBasePrice = new DiscountedProduct("Сыр", -50, 20);
            System.out.println("Создан продукт: " + negativeBasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }
        try {
            DiscountedProduct negativeDiscount = new DiscountedProduct("Сыр", 150, -10);
            System.out.println("Создан продукт: " + negativeDiscount);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }
        try {
            DiscountedProduct tooHighDiscount = new DiscountedProduct("Сыр", 150, 150);
            System.out.println("Создан продукт: " + tooHighDiscount);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }

        System.out.println(" 1.3 Тестирование FixPriceProduct ");

        try {
            FixPriceProduct emptyName = new FixPriceProduct("");
            System.out.println("Создан продукт: " + emptyName);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }

        try {
            FixPriceProduct nullName = new FixPriceProduct(null);
            System.out.println("Создан продукт: " + nullName);
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }

        System.out.println(" 2. СОЗДАНИЕ КОРРЕКТНЫХ ОБЪЕКТОВ ");

        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        SimpleProduct bread = new SimpleProduct("Хлеб", 30);
        DiscountedProduct cheese = new DiscountedProduct("Сыр", 150, 20);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 80, 10);
        FixPriceProduct pen = new FixPriceProduct("Ручка");
        FixPriceProduct notebook = new FixPriceProduct("Тетрадь");

        System.out.println("✓ Созданы корректные продукты:");
        System.out.println("  " + apple);
        System.out.println("  " + bread);
        System.out.println("  " + cheese);
        System.out.println("  " + milk);
        System.out.println("  " + pen);
        System.out.println("  " + notebook);

        Article appleArticle = new Article(
                "Польза яблок",
                "Яблоки богаты витаминами и клетчаткой. Они укрепляют иммунитет и улучшают пищеварение."
        );

        Article breadArticle = new Article(
                "Как выбрать хлеб",
                "При выборе хлеба обращайте внимание на состав. Качественный хлеб должен быть без добавок."
        );

        Article milkArticle = new Article(
                "Польза молока",
                "Молоко содержит кальций, который необходим для здоровья костей и зубов."
        );

        Article healthArticle = new Article(
                "Здоровое питание",
                "Правильное питание включает фрукты, овощи, молочные продукты и хлеб из цельного зерна."
        );

        System.out.println("✓ Созданы статьи:");
        System.out.println("  " + appleArticle.getTitle());
        System.out.println("  " + breadArticle.getTitle());
        System.out.println("  " + milkArticle.getTitle());
        System.out.println("  " + healthArticle.getTitle());

        SearchEngine searchEngine = new SearchEngine(20);

        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(cheese);
        searchEngine.add(milk);
        searchEngine.add(pen);
        searchEngine.add(notebook);
        searchEngine.add(appleArticle);
        searchEngine.add(breadArticle);
        searchEngine.add(milkArticle);
        searchEngine.add(healthArticle);

        System.out.println("Всего элементов в поисковом движке: " + searchEngine.getSize());

        System.out.println("3. ДЕМОНСТРАЦИЯ МЕТОДА findMostSuitable ");

        System.out.println(" 3.1 Поиск существующего объекта ");

        String existingQuery = "яблоко";
        try {
            System.out.println("Поиск наиболее подходящего для запроса: '" + existingQuery + "'");
            Searchable result = searchEngine.findMostSuitable(existingQuery);
            System.out.println("✓ Найден: " + result.getStringRepresentation());
            System.out.println("  Search term: " + result.getSearchTerm());

            String searchTerm = result.getSearchTerm().toLowerCase();
            int count = countOccurrences(searchTerm, existingQuery.toLowerCase());
            System.out.println("  Количество вхождений: " + count);
        } catch (BestResultNotFound e) {
            System.out.println("✗ " + e.getMessage());
        }

        System.out.println("---");

        String existingQuery2 = "хлеб";
        try {
            System.out.println("Поиск наиболее подходящего для запроса: '" + existingQuery2 + "'");
            Searchable result = searchEngine.findMostSuitable(existingQuery2);
            System.out.println("✓ Найден: " + result.getStringRepresentation());
            System.out.println("  Search term: " + result.getSearchTerm());

            String searchTerm = result.getSearchTerm().toLowerCase();
            int count = countOccurrences(searchTerm, existingQuery2.toLowerCase());
            System.out.println("  Количество вхождений: " + count);
        } catch (BestResultNotFound e) {
            System.out.println("✗ " + e.getMessage());
        }

        System.out.println("3.2 Поиск несуществующего объекта ");

        String nonExistingQuery = "абрикос";
        try {
            System.out.println("Поиск наиболее подходящего для запроса: '" + nonExistingQuery + "'");
            Searchable result = searchEngine.findMostSuitable(nonExistingQuery);
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("✗ " + e.getMessage());
        }

        System.out.println("---");

        String nonExistingQuery2 = "компьютер";
        try {
            System.out.println("Поиск наиболее подходящего для запроса: '" + nonExistingQuery2 + "'");
            Searchable result = searchEngine.findMostSuitable(nonExistingQuery2);
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("✗ " + e.getMessage());
        }

        System.out.println("---");

        try {
            System.out.println("Поиск наиболее подходящего для пустого запроса: ''");
            Searchable result = searchEngine.findMostSuitable("");
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("✗ " + e.getMessage());
        }

        System.out.println(" 3.3 Тест с множественными вхождениями ");

        SearchEngine testEngine = new SearchEngine(10);

        Article test1 = new Article(
                "Яблоко яблоко яблоко",
                "Текст про яблоки"
        );
        Article test2 = new Article(
                "Яблоко груша",
                "Текст про фрукты"
        );
        Article test3 = new Article(
                "Груша яблоко яблоко яблоко яблоко",
                "Много яблок"
        );

        testEngine.add(test1);
        testEngine.add(test2);
        testEngine.add(test3);

        try {
            System.out.println("Поиск наиболее подходящего для 'яблоко':");
            Searchable best = testEngine.findMostSuitable("яблоко");
            System.out.println("✓ Найден: " + best.getStringRepresentation());
            System.out.println("  Search term: " + best.getSearchTerm());
            String searchTerm = best.getSearchTerm().toLowerCase();
            int count = countOccurrences(searchTerm, "яблоко");
            System.out.println("  Количество вхождений: " + count);
        } catch (BestResultNotFound e) {
            System.out.println("✗ " + e.getMessage());
        }

        System.out.println("4. РАБОТА С КОРЗИНОЙ ");

        ProductBasket basket = new ProductBasket();

        System.out.println("Добавление продуктов в корзину:");
        basket.addProduct(apple);
        System.out.println("  + " + apple);
        basket.addProduct(bread);
        System.out.println("  + " + bread);
        basket.addProduct(cheese);
        System.out.println("  + " + cheese);
        basket.addProduct(milk);
        System.out.println("  + " + milk);
        basket.addProduct(pen);
        System.out.println("  + " + pen);

        System.out.println(" Содержимое корзины:");
        basket.printBasket();

        System.out.println(" Общая стоимость: " + basket.getTotalPrice());

        System.out.println(" Поиск товара 'Сыр' в корзине: " + basket.containsProduct("Сыр"));
        System.out.println(" Поиск товара 'Рыба' в корзине: " + basket.containsProduct("Рыба"));

        System.out.println(" Очистка корзины...");
        basket.clearBasket();

        System.out.println(" Содержимое после очистки:");
        basket.printBasket();

        System.out.println(" КОНЕЦ ДЕМОНСТРАЦИИ ");
    }

    private static int countOccurrences(String text, String substring) {
        if (substring == null || substring.isEmpty() || text == null || text.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int substringIndex = text.indexOf(substring, index);

        while (substringIndex != -1) {
            count++;
            index = substringIndex + substring.length();
            substringIndex = text.indexOf(substring, index);
        }

        return count;
    }
}