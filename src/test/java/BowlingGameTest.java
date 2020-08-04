import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {

    public BowlingGame game;

    @BeforeEach
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    public void should_throw_exception_when_has_negative_number() {
        List<Integer> hasNegativeNum = Arrays.asList(0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThrows(RuntimeException.class, () -> game.calcGrade(hasNegativeNum));
    }

    @Test
    public void should_throw_exception_when_size_less_than_11() {
        List<Integer> sizeLessThan11 = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 1);
        assertThrows(RuntimeException.class, () -> game.calcGrade(sizeLessThan11));

    }

    @Test
    public void should_add_sum_when_no_spare_and_strike() {
        List<Integer> noSpareAndStrike = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        int result = game.calcGrade(noSpareAndStrike);
        assertEquals(20, result);
    }

    @Test
    public void should_add_once_when_has_spare() {
        List<Integer> hasSpare = Arrays.asList(0, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int result = game.calcGrade(hasSpare);
        assertEquals(10, result);
    }
}
