import candy.CandyStock;
import cart.CandyCart;
import cart.CandyPurchaseEntry;
import cart.SellCandyResponse;
import discount.Discount;
import discount.DiscountService;

import java.util.HashMap;
import java.util.List;

public class CandyShop implements ICandyShop {
    public HashMap<String, CandyStock> candyStock;
    private final DiscountService discountService;
    private final List<Discount> discounts;

    public CandyShop(
            HashMap<String, CandyStock> candyStock,
            DiscountService discountService,
            List<Discount> discounts
    ) {
        this.candyStock = candyStock;
        this.discountService = discountService;
        this.discounts = discounts;
    }

    @Override
    public SellCandyResponse sellCandy(CandyCart candyCart) {
        HashMap<String, Integer> candies = candyCart.getCandies();
        var response = new SellCandyResponse();

        candies.forEach((candyNameRequired, candyAmountRequired) -> {
            var currentStock = candyStock.getOrDefault(candyNameRequired, null);
            if (currentStock == null) return;

            if (currentStock.amount < candyAmountRequired) return;

            currentStock.decreaseCandyAmount(candyAmountRequired);

            int discount = discountService.applyDiscount(discounts, currentStock.candy);
            double initialPrice = currentStock.candy.getPrice() * (double)candyAmountRequired;
            double discountedAmount = ((double)discount / 100) * initialPrice;
            double finalPrice = initialPrice - discountedAmount;

            var purchaseEntry = new CandyPurchaseEntry(
                    currentStock.candy.getName(),
                    currentStock.candy.getPrice(),
                    initialPrice,
                    finalPrice,
                    discount,
                    discountedAmount
            );

            response.addPurchaseEntry(purchaseEntry);
        });

        candyCart.clear();

        return response;
    }
}
