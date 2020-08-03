import java.util.List;

public class BowlingGame {
    public String calculateGrade(List<Integer> hitNumbers) {
        Integer totGrade = 0;

        for (Integer h : hitNumbers){
            if (h < 0) {
                throw new RuntimeException("negative number is illegal!");
            }
            totGrade += h;
        }

        return totGrade.toString();
    }
}
