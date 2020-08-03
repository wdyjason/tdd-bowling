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
        List<Integer> noSpareOrStrike = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        String result = game.calculateGrade(noSpareOrStrike);
        assertEquals("20", result);
    }

    @Test
    void should_add_one_more_when_receive_only_spare() {
        BowlingGame game = new BowlingGame();
        List<Integer> spareOnly = Arrays.asList(1, 1, 1, 4, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        String result = game.calculateGrade(spareOnly);
        assertEquals("29", result);
    }

    @Test
    void should_add_twice_more_when_receive_only_strike() {
        BowlingGame game = new BowlingGame();
        List<Integer> strikeOnly = Arrays.asList(1, 1, 1, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        String result = game.calculateGrade(strikeOnly);
        assertEquals("30", result);
    }

    @Test
    void should_success_when_receive_spare_and_strike() {
        BowlingGame game = new BowlingGame();
        List<Integer> spareAndStrike = Arrays.asList(1, 1, 1, 10, 4, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        String result = game.calculateGrade(spareAndStrike);
        assertEquals("47", result);
    }

    @Test
    void should_throw_exception_when_receive_less_than_11() {
        BowlingGame game = new BowlingGame();
        List<Integer> lessThan11 = Arrays.asList(1, 1, 1, 1, 1, 1, 1);
        assertThrows(RuntimeException.class, () -> game.calculateGrade(lessThan11));
    }

}
