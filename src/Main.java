import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class Main {
    public static void main(String[] args) {
        System.out.println("РАБОТА С КОРЗИНОЙ");
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

        basket.printBasket();
    }
}