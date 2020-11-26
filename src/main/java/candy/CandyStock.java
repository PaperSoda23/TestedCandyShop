package candy;

public class CandyStock {
    public Candy candy;
    public int amount;

    public CandyStock(
            Candy candy,
            int amount
    ) {
        this.candy = candy;
        this.amount = amount;
    }

    public double getCandyPrice() {
        return candy.getPrice();
    }
    public double getCandyAmount() {
        return amount;
    }
    public void increaseCandyAmount(int amount) {
        this.amount += amount;
    }
    public void decreaseCandyAmount(int amount) {
        this.amount -= amount;
    }
}
