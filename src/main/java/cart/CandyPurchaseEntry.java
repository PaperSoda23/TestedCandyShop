package cart;

public class CandyPurchaseEntry {
    private final String candyName;
    private final double basePrice;
    private final double initialPrice;
    private final double finalPrice;
    private final int discountApplied;
    private final double discountAmount;

    public CandyPurchaseEntry(
            String candyName,
            double basePrice,
            double initialPrice,
            double finalPrice,
            int discountApplied,
            double discountAmount
    ) {
        this.candyName = candyName;
        this.basePrice = basePrice;
        this.initialPrice = initialPrice;
        this.finalPrice = finalPrice;
        this.discountApplied = discountApplied;
        this.discountAmount = discountAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }
    public int getDiscountApplied() {
        return discountApplied;
    }
    public double getInitialPrice() {
        return initialPrice;
    }
    public double getFinalPrice() {
        return finalPrice;
    }
    public String getCandyName() {
        return candyName;
    }
    public double getBasePrice() {
        return basePrice;
    }
}
