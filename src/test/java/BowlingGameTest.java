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
}
