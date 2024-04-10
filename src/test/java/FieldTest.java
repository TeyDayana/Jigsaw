import com.example.jigsaw.Field;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldTest {
    @Test
    void getLayoutShouldReturnNearestLayoutCoordinatesMultipleOfFifty() {
        assertEquals(Field.getLayout(26, 76), new Pair<>(50, 100));
    }
}
