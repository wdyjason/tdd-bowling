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

    @Test
    void should_add_total_when_no_spare_or_strike() {
        BowlingGame game = new BowlingGame();
        List<Integer> noSpareOrStrike = Arrays.asList(1, 2, 3, 4, 5, 4, 1, 2, 8, 1, 1, 2, 3, 4, 3, 6, 1, 7, 8, 1);
        String result = game.calculateGrade(noSpareOrStrike);
        assertEquals("67", result);
    }
}
