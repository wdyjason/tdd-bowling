import java.util.List;

public class BowlingGame {
    public String calculateGrade(List<Integer> hitNumbers) {
        int totGrade = 0;
        float frame = 1;

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

            if (cur == 10) {
                totGrade += (cur + next + hitNumbers.get(i + 2));
                frame ++;
                continue;
            }

            if ((cur + next) == 10) {
                totGrade += hitNumbers.get(i + 2);
            }

            totGrade += cur;
            frame += 0.5;
        }

        return Integer.toString(totGrade);
    }
}
