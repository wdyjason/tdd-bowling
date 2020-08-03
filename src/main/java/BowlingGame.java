import java.util.List;

public class BowlingGame {
    private final float HALF_FRAME = 0.5f;

    public String calculateGrade(List<Integer> hitNumbers) {

        int size = hitNumbers.size();
        int totGrade = 0;
        float frame = 1;

        if (size < 11) {
            throw new RuntimeException("input size is illegal!");
        }

        for (int i = 0; i < size; i++){

            if (equals10((int)frame)) {
                totGrade += hitNumbers.subList(i, size).stream().mapToInt(h -> h).sum();
                break;
            }

            int cur = hitNumbers.get(i);
            int next = hitNumbers.get(i + 1);
            int nextNext = hitNumbers.get(i + 2);

            if (cur < 0) {
                throw new RuntimeException("negative number is illegal!");
            }

            if (equals10(cur + next)) {
                totGrade += nextNext;
            }

            totGrade += cur;
            frame += HALF_FRAME;

            if (equals10(cur)) {
                totGrade += (next + nextNext);
                frame += HALF_FRAME;
            }
        }

        return Integer.toString(totGrade);
    }

    public boolean equals10(int compare) {
        return compare == 10;
    }
}
