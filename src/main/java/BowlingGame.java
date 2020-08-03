import java.util.List;

public class BowlingGame {
    public String calculateGrade(List<Integer> hitNumbers) {
        hitNumbers.forEach(h -> {
            if (h < 0) {
                throw new RuntimeException("negative number is illegal!");
            }
        });

        return null;
    }
}
