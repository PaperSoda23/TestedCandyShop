import cart.CandyCart;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

public class CandyCartTests {
    private CandyCart candyCart;

    @BeforeEach
    public void init() {
        candyCart = new CandyCart();
    }

    @Test
    public void isEmptyInitially() {
        assertEquals(0, candyCart.size());
    }

    @Nested
    class AddToCart {
        @ParameterizedTest
        @ValueSource(ints = {-1, 0})
        public void throwsExceptionWithIllegalCandyAmount(int candyAmount) {
            assertThrows(IllegalArgumentException.class, () -> candyCart.addCandy("legalName", candyAmount));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" ", ""})
        public void throwsExceptionWithIllegalCandyName(String candyName) {
            assertThrows(IllegalArgumentException.class, () -> candyCart.addCandy(candyName, 1));
        }

        @Test
        public void increasesSizeWhenCandyIsAdd() {
            candyCart.addCandy("legalName", 1);
            //Assert
            assertEquals(1, candyCart.size());
        }

        @Test
        public void addsToExistingAmountWhenExistingCandyIsAdd() {
            var candyName = "coolCandy";
            var candyAmount = 1;
            //Act
            candyCart.addCandy(candyName, candyAmount);
            candyCart.addCandy(candyName, candyAmount);
            //Assert
            assertEquals(1, candyCart.size());
            assertEquals(2 * candyAmount, candyCart.getCandyAmount(candyName));
        }
    }

    @Nested
    class GetCartAmount {
        @Test
        public void returnZeroWhenNoCandyFound() {
            assertEquals(0, candyCart.getCandyAmount("unknownName"));
        }

        @Test
        public void returnCandyAmountAdd() {
            var candyName = "coolCandy";
            var candyAmount = 5;
            //Act
            candyCart.addCandy(candyName, candyAmount);
            //Assert
            assertEquals(candyAmount, candyCart.getCandyAmount(candyName));
        }
    }

    @Nested
    class ClearCandyCart {
        @Test
        public void willClearCartWhenCartIsCleared() {
            candyCart.addCandy("coolName", 20);
            Assertions.assertEquals(1, candyCart.size());

            candyCart.clear();
            Assertions.assertEquals(0, candyCart.size());
        }
    }
}
