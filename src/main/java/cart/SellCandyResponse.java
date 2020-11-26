package cart;

import java.util.ArrayList;
import java.util.List;

public class SellCandyResponse {
    private final List<CandyPurchaseEntry> candyPurchaseEntryList = new ArrayList<>();

    public void addPurchaseEntry(CandyPurchaseEntry entry) {
        candyPurchaseEntryList.add(entry);
    }

    public List<CandyPurchaseEntry> getCandyPurchaseEntryList() {
        return candyPurchaseEntryList;
    }

    @Override
    public String toString() {
        for (var el : candyPurchaseEntryList) {
            System.out.println(el.getCandyName());
            System.out.println(el.getFinalPrice());
            System.out.println(el.getDiscountAmount());
        }
        return "hello";
    }
}
