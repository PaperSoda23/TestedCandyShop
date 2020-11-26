package discount;

import candy.Candy;

import java.util.Comparator;
import java.util.List;

public class DiscountService implements IDiscountService {
    public int applyDiscount(List<Discount> discounts, Candy candy) {
        if (discounts == null || candy == null) throw new IllegalArgumentException("candy or discount list is null");

        var highestOptionalDiscount = discounts
                .stream()
                .filter(discount -> discount.apply(candy))
                .max(Comparator.comparingInt(Discount::getAmount));

        if (highestOptionalDiscount.isEmpty()) return 0;
        return highestOptionalDiscount.get().getAmount();
    }
}
