import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {

    @Test
    void should_throw_exception_when_receive_negative_number() {
        BowlingGame game = new BowlingGame();
        List<Integer> listHasNegativeNum = Arrays.asList(1, 2, 3, -4, 5, 6, 6, 7, 8, 1, 1, 2, 3, 4, 5, 6, 6, 7, 8, 1);
        assertThrows(RuntimeException.class, () -> game.calculateGrade(listHasNegativeNum));
    }
}
