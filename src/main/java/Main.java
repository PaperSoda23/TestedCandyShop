import candy.Candy;
import candy.CandyStock;
import candy.CandyType;
import cart.CandyCart;
import discount.DiscountService;
import discount.NameDiscount;
import discount.TypeDiscount;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var candyStock = new HashMap<String, CandyStock>();
        candyStock.put("karvute", new CandyStock(new Candy("karvute", 20d, CandyType.CHOCOLATE), 20));
        candyStock.put("kregzdute", new CandyStock(new Candy("kregzdute", 30d, CandyType.BONBON), 30));

        var candyCart = new CandyCart();
        candyCart.addCandy("karvute", 10);
        candyCart.addCandy("kregzdute", 5);

        var discounts = List.of(
                new TypeDiscount(20, CandyType.CHOCOLATE),
                new NameDiscount(30, "kregzdute")
        );
        var candyShop = new CandyShop(candyStock, new DiscountService(), discounts);

        var sellCandyResponse = candyShop.sellCandy(candyCart);

        System.out.println(sellCandyResponse);
    }
}
