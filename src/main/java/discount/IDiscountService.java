package discount;

import candy.Candy;

import java.util.List;

public interface IDiscountService {
    int applyDiscount(List<Discount> discounts, Candy candy);
}
