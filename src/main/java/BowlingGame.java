import java.util.List;

public class BowlingGame {
    public String calculateGrade(List<Integer> hitNumbers) {
        int totGrade = 0;
        int frame = 1;

        for (int i = 0; i < hitNumbers.size(); i++){

            if (frame == 10) {
                totGrade += hitNumbers.subList(i, hitNumbers.size()).stream().mapToInt(h -> h).sum();
                break;
            }

            int cur = hitNumbers.get(i);
            int next = hitNumbers.get(i + 1);

            if (cur < 0) {
                throw new RuntimeException("negative number is illegal!");
            }

            if ((cur + next) == 10) {
                totGrade += hitNumbers.get(i + 2);
            }

            if (i % 2 == 0) {
                frame ++;
            }

            totGrade += cur;
        }

        return Integer.toString(totGrade);
    }
}
