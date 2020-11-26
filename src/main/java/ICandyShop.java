import cart.CandyCart;
import cart.SellCandyResponse;

public interface ICandyShop {
    SellCandyResponse sellCandy(CandyCart candyCart);
}
