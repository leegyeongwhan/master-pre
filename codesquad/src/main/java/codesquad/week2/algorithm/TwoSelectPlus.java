package codesquad.week2.algorithm;

import java.util.*;

public class TwoSelectPlus {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
