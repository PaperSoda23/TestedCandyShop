package discount;

import candy.Candy;
import candy.CandyType;

public class TypeDiscount extends Discount {
    private final CandyType candyType;

    public TypeDiscount(
            int amount,
            CandyType candyType
    ) {
        super(amount);
        this.candyType = candyType;
    }

    public CandyType getCandyType() {
        return candyType;
    }

    @Override
    public boolean apply(Candy candy) {
        return candyType.equals(candy.getCandyType());
    }
}
