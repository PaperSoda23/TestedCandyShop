import candy.Candy;
import candy.CandyStock;
import candy.CandyType;
import cart.CandyCart;
import discount.NameDiscount;
import discount.TypeDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import discount.DiscountService;

import java.util.HashMap;
import java.util.List;

public class CandyShopTests {
    private CandyShop candyShop;

    private CandyCart candyCart;

    private void setupCandyShop() {
        var candyStock = new HashMap<String, CandyStock>();
        candyStock.put("karvute", new CandyStock(new Candy("karvute", 20d, CandyType.CHOCOLATE), 20));
        candyStock.put("kregzdute", new CandyStock(new Candy("kregzdute", 30d, CandyType.BONBON), 30));

        var discounts = List.of(
                new TypeDiscount(20, CandyType.CHOCOLATE),
                new NameDiscount(30, "kregzdute")
        );

        candyShop = new CandyShop(candyStock, new DiscountService(), discounts);
    }

    private void setupCandyCart() {
        candyCart = new CandyCart();
        candyCart.addCandy("karvute", 10);
        candyCart.addCandy("kregzdute", 5);
    }

    @BeforeEach
    public void init() {
        setupCandyShop();
        setupCandyCart();
    }

    @Test
    public void willCandyReturnResponse() {
        var candyResponse = candyShop.sellCandy(candyCart);
        Assertions.assertNotNull(candyResponse);
    }

    @Test
    public void willContainAccurateData() {
        var candyResponse = candyShop.sellCandy(candyCart);
        var candyPurchaseEntryList = candyResponse.getCandyPurchaseEntryList();

        Assertions.assertEquals(candyPurchaseEntryList.get(0).getCandyName(), "kregzdute");
        Assertions.assertEquals(candyPurchaseEntryList.get(0).getBasePrice(), 30);
        Assertions.assertEquals(candyPurchaseEntryList.get(0).getDiscountAmount(), 45);
        Assertions.assertEquals(candyPurchaseEntryList.get(0).getDiscountApplied(), 30);
        Assertions.assertEquals(candyPurchaseEntryList.get(0).getFinalPrice(), 105);
        Assertions.assertEquals(candyPurchaseEntryList.get(0).getInitialPrice(), 150);

        Assertions.assertEquals(candyPurchaseEntryList.get(1).getCandyName(), "karvute");
        Assertions.assertEquals(candyPurchaseEntryList.get(1).getBasePrice(), 20);
        Assertions.assertEquals(candyPurchaseEntryList.get(1).getDiscountAmount(), 40);
        Assertions.assertEquals(candyPurchaseEntryList.get(1).getDiscountApplied(), 20);
        Assertions.assertEquals(candyPurchaseEntryList.get(1).getFinalPrice(), 160);
        Assertions.assertEquals(candyPurchaseEntryList.get(1).getInitialPrice(), 200);
    }
}
