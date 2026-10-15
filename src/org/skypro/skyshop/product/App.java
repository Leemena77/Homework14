package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Set;

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

        System.out.println("\n Удаляем все товары с именем 'Блокнот' ");
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
        if (nothing.isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println("\n Финальная корзина ");
        basket.printBasket();

        SearchEngine engine = new SearchEngine();

        engine.add(new SimpleProduct("Java Book", 500));
        engine.add(new DiscountedProduct("Java Course", 1000, 20));
        engine.add(new FixPriceProduct("Java Sticker"));
        engine.add(new SimpleProduct("Java", 100)); // короткое имя
        engine.add(new SimpleProduct("Java Programming Language", 1500)); // длинное

        engine.add(new SimpleProduct("Java Book", 999)); // дубликат по имени

        System.out.println("Всего объектов в движке (без дубликатов): "
                + engine.getSearchables().size());

        String query = "Java";
        System.out.println("\n Поиск по запросу: \"" + query + "\" ");
        Set<Searchable> results = engine.search(query);

        if (!results.isEmpty()) {
            System.out.println("Найдено результатов: " + results.size());
            System.out.println("(сортировка: от длинного имени к короткому, "
                    + "при равенстве — по алфавиту)\n");
            int i = 1;
            for (Searchable s : results) {
                System.out.println("  " + i++ + ". [" + s.getName().length() + " симв.] "
                        + s.getName());
            }
        } else {
            System.out.println("Список пуст");
        }

        String emptyQuery = "C++";
        System.out.println("\n Поиск по запросу: \"" + emptyQuery + "\" ");
        Set<Searchable> emptyResults = engine.search(emptyQuery);

        if (emptyResults.isEmpty()) {
            System.out.println("Список пуст");
        }
    }
}