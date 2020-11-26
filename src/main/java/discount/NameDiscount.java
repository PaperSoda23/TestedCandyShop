package discount;

import candy.Candy;

public class NameDiscount extends Discount {
    private final String candyName;

    public NameDiscount(
            int amount,
            String candyName
    ) {
        super(amount);
        this.candyName = candyName;
    }

    public String getCandyName() {
        return candyName;
    }

    @Override
    public boolean apply(Candy candy) {
        return candyName.equals(candy.getName());
    }
}
