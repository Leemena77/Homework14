import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Книга", "Интересная книга"));
        basket.addProduct(new SimpleProduct("Тетрадь", "48 листов"));
        basket.addProduct(new DiscountedProduct("Детектив", "Классика", 500, 10));
        basket.addProduct(new DiscountedProduct("Ноутбук", "Игровой", 1000, 20));
        basket.addProduct(new DiscountedProduct("Фен", "Стайлер", 3000, 15));
        basket.addProduct(new FixPriceProduct("Набор ручек", "10 цветных ручек"));
        basket.addProduct(new FixPriceProduct("Блокнот", "А5, 50 листов"));
        basket.addProduct(new FixPriceProduct("Календарь", "Настенный"));

        System.out.println(" Содержимое корзины ");
        basket.printBasket();

        System.out.println("Проверка специальных товаров");
        System.out.println("DiscountProduct isSpecial: " + new DiscountedProduct("Тест", "Тест", 100, 10).isSpecial());
        System.out.println("FixPriceProduct isSpecial: " + new FixPriceProduct("Тест", "Тест").isSpecial());
        System.out.printf("SimpleProduct isSpecial: %s%n", new SimpleProduct("Тест", "Тест"));
    }
}