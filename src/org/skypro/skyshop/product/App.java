package org.skypro.skyshop.product;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.List;
public class App {
    public static void main(String[] args) {

        System.out.println(" ДЕМОНСТРАЦИЯ: УДАЛЕНИЕ ПО ИМЕНИ + ПОИСК");

        demonstrateRemoveByName();
        demonstrateSearchEngine();
    }

    private static void demonstrateRemoveByName() {
        System.out.println(" СЦЕНАРИЙ 1: Удаление по имени ");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Книга", 500));
        basket.addProduct(new SimpleProduct("Блокнот", 50));
        basket.addProduct(new FixPriceProduct("Блокнот"));
        basket.addProduct(new DiscountedProduct("Блокнот", 200, 15));
        basket.addProduct(new SimpleProduct("Ручка", 15));
        basket.addProduct(new FixPriceProduct("Календарь"));

        System.out.println("Исходная корзина:");
        basket.printBasket();

        System.out.println(" Удаляем все товары с именем 'Блокнот':");
        List<Product> removed = basket.removeProductsByName("Блокнот");

        if (!removed.isEmpty()) {
            System.out.println("Удалено товаров: " + removed.size());
            for (Product p : removed) {
                System.out.println("  • " + p);
            }
        } else {
            System.out.println("Список пуст");
        }

        System.out.println(" Корзина после удаления:");
        basket.printBasket();

        System.out.println(" Удаляем 'НесуществующийТовар':");
        List<Product> nothing = basket.removeProductsByName("НесуществующийТовар");

        if (!nothing.isEmpty()) {
            System.out.println("Удалено товаров: " + nothing.size());
            for (Product p : nothing) {
                System.out.println("  • " + p);
            }
        } else {
            System.out.println("Список пуст");
        }

        System.out.println(" Финальная корзина:");
        basket.printBasket();
    }
    private static void demonstrateSearchEngine() {
        System.out.println(" СЦЕНАРИЙ 2: Поиск с возвратом всех результатов ");

        SearchEngine engine = new SearchEngine();

        System.out.println("Всего документов в движке: " + engine.getDocuments().size());

        String query = "Java";
        System.out.println(" Поиск по запросу: " + query + " ");
        List<String> results = engine.search(query);

        if (!results.isEmpty()) {
            System.out.println("Найдено результатов: " + results.size());
            int i = 1;
            for (String result : results) {
                System.out.println("  " + i++ + ". " + result);
            }
        } else {
            System.out.println("Список пуст");
        }

        String emptyQuery = "C++";
        System.out.println(" Поиск по запросу: " + emptyQuery + " ");
        List<String> emptyResults = engine.search(emptyQuery);

        if (!emptyResults.isEmpty()) {
            System.out.println("Найдено результатов: " + emptyResults.size());
            for (String result : emptyResults) {
                System.out.println("  • " + result);
            }
        } else {
            System.out.println("Список пуст");
        }
    }
}