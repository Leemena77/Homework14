package org.skypro.skyshop.product;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        System.out.println(" РАБОТА С КОРЗИНОЙ ");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Книга", 500));
        basket.addProduct(new SimpleProduct("Тетрадь", 80));
        basket.addProduct(new SimpleProduct("Карандаш", 25));
        basket.addProduct(new SimpleProduct("Ручка", 15));

        basket.addProduct(new DiscountedProduct("Детектив", 500, 10));
        basket.addProduct(new DiscountedProduct("Ноутбук", 1000, 20));
        basket.addProduct(new DiscountedProduct("Фен", 3000, 15));

        basket.addProduct(new FixPriceProduct("Набор ручек"));
        basket.addProduct(new FixPriceProduct("Блокнот"));
        basket.addProduct(new FixPriceProduct("Календарь"));

        basket.addProduct(new SimpleProduct("Блокнот", 50));
        basket.addProduct(new SimpleProduct("Блокнот", 120));

        System.out.println(" Исходная корзина ");
        basket.printBasket();

        System.out.println("\n  Удаляем все товары с именем 'Блокнот' ");
        List<Product> removed = basket.removeProductsByName("Блокнот");

        if (!removed.isEmpty()) {
            System.out.println("Удалено товаров: " + removed.size());
            for (Product p : removed) {
                System.out.println("  • " + p);
            }
        } else {
            System.out.println("Список пуст");
        }

        System.out.println("\n Корзина после удаления ");
        basket.printBasket();

        System.out.println("\n Удаляем 'НесуществующийТовар' ");
        List<Product> nothing = basket.removeProductsByName("НесуществующийТовар");

        if (!nothing.isEmpty()) {
            System.out.println("Удалено товаров: " + nothing.size());
            for (Product p : nothing) {
                System.out.println("  • " + p);
            }
        } else {
            System.out.println("Список пуст");
        }

        System.out.println("\n Финальная корзина ");
        basket.printBasket();

        SearchEngine engine = new SearchEngine();

        System.out.println("Всего документов в движке: " + engine.getSearchables().size());

        String query = "Java";
        System.out.println(" Поиск по запросу: \"" + query + "\" ");
        Map<String, Searchable> results = engine.search(query);

        if (!results.isEmpty()) {
            System.out.println("Найдено результатов: " + results.size());
            int i = 1;
            for (Searchable s : results.values()) {
                System.out.println("  " + i++ + ". " + s.getSearchTerm());
            }
        } else {
            System.out.println("Список пуст");
        }

        String emptyQuery = "C++";
        System.out.println(" Поиск по запросу: \"" + emptyQuery + "\" ");
        Map<String, Searchable> emptyResults = engine.search(emptyQuery);

        if (!emptyResults.isEmpty()) {
            System.out.println("Найдено результатов: " + emptyResults.size());
            for (Searchable s : emptyResults.values()) {
                System.out.println("  • " + s.getSearchTerm());
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    static class SimpleSearchable implements Searchable {
        private final String content;

        SimpleSearchable(String content) {
            this.content = content;
        }

        @Override
        public String getSearchTerm() {
            return content;
        }

        @Override
        public String getContentType() {
            return "DOCUMENT";
        }

        @Override
        public String getName() {
            return content;
        }
    }
}