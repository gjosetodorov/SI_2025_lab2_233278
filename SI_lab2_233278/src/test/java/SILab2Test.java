import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class SILab2Test {

    @Test
    public void testValidCart() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", 5, 100, 0));
        items.add(new Item("Item2", 2, 350, 0.1));

        double expected = 0;

        expected += 500;

        expected += 600;

        double actual = SILab2.checkCart(items, "1234567890123456");
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidCardNumberLength() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", 1, 100, 0));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, "12345");
        });
        assertEquals("Invalid card number!", exception.getMessage());
    }

    @Test
    public void testInvalidCardNumberCharacter() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", 1, 100, 0));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, "12345678901234AB");
        });
        assertEquals("Invalid character in card number!", exception.getMessage());
    }

    @Test
    public void testNullItemName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(null, 1, 100, 0));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, "1234567890123456");
        });
        assertEquals("Invalid item!", exception.getMessage());
    }

    @Test
    public void testNullAllItems() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, "1234567890123456");
        });
        assertEquals("allItems list can't be null!", exception.getMessage());
    }
}
