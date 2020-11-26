package candy;

public class Candy {
    private final String name;
    private final double price;
    private final CandyType candyType;

    public Candy(
            String name,
            double price,
            CandyType candyType
    ) {
        this.name = name;
        this.price = price;
        this.candyType = candyType;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public CandyType getCandyType() {
        return candyType;
    }
}
