package cart;

import java.util.HashMap;


public class CandyCart implements ICandyCart {
    private final HashMap<String, Integer> cart = new HashMap<>();

    public void addCandy(String candyName, int candyAmount) {
        if (candyAmount <= 0 || candyName == null || candyName.trim().isBlank())  {
            throw new IllegalArgumentException("zero or negative candy amount");
        }

        if (!cart.containsKey(candyName)) {
            cart.put(candyName, candyAmount);
            return;
        }

        Integer currentCandyAmount = cart.get(candyName);
        cart.replace(candyName, candyAmount + currentCandyAmount);
    }

    public HashMap<String, Integer> getCandies() {
        return (HashMap<String, Integer>)cart.clone();
    }

    public void clear() {
        cart.clear();
    }

    public int getCandyAmount(String candyName) {
        if (cart.containsKey(candyName)) return cart.get(candyName);
        return 0;
    }

    public int size() {
        return cart.size();
    }
}
