package discount;

import candy.Candy;

public abstract class Discount {
    protected int amount;

    public Discount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
    public abstract boolean apply(Candy candy);
}
