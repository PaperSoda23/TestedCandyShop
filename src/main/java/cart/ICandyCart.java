package cart;

public interface ICandyCart {
    int size();
    void addCandy(String candyName, int candyAmount);
    int getCandyAmount(String candyName);
}
