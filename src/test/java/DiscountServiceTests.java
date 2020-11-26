import candy.Candy;
import candy.CandyType;
import discount.Discount;
import discount.DiscountService;
import discount.NameDiscount;
import discount.TypeDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class DiscountServiceTests {
    private DiscountService discountService;

    @BeforeEach
    public void init() {
        discountService = new DiscountService();
    }

    @Test
    public void willApplyTypeDiscount() {
        var discountAmount = 50;
        var chocolateDiscount = new TypeDiscount(discountAmount, CandyType.CHOCOLATE);
        var candy = new Candy("candy", 20d, CandyType.CHOCOLATE);

        var discounts = List.of((Discount)chocolateDiscount);
        var amount = discountService.applyDiscount(discounts, candy);

        assertEquals(discountAmount, amount);
    }

    @Test
    public void willApplyNameDiscount() {
            var discountAmount = 40;
            var candyName = "candy";
            var chocolateDiscount = new NameDiscount(discountAmount, candyName);
            var candy = new Candy(candyName, 20d, CandyType.CHOCOLATE);
            var discounts = List.of((Discount)chocolateDiscount);
            // Act
            var amount = discountService.applyDiscount(discounts, candy);
            // Assert
            assertEquals(discountAmount, amount);
    }

    @Test
    public void willApplyHigherDiscount() {
        var highestDiscountAmount = 60;
        var lowerDiscountAmount = 40;
        var discountedType = CandyType.CHOCOLATE;
        var candyName = "candy";

        var candy = new Candy(candyName, 20d, discountedType);
        var discounts = List.of(
                new NameDiscount(highestDiscountAmount, candyName),
                new TypeDiscount(lowerDiscountAmount, discountedType)
        );
        // Act
        var amount = discountService.applyDiscount(discounts, candy);
        // Assert
        assertEquals(highestDiscountAmount, amount);
    }

    @Test
    public void willErrorOnInvalidArguments() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> discountService.applyDiscount(
                        List.of(new TypeDiscount(20, CandyType.CHOCOLATE)),
                        null
                )
        );
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> discountService.applyDiscount(
                        null,
                        new Candy("candy", 20, CandyType.CHOCOLATE)
                )
        );
    }

    @Test
    public void willNotDiscountWithNoDiscounts() {
        var discount = discountService
                .applyDiscount(new ArrayList<>(), new Candy("candy", 20, CandyType.CHOCOLATE));
        Assertions.assertEquals(0, discount);
    }
}
