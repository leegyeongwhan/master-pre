package codesquad.week2.algorithm;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    static final int[] firstStudent = {1, 2, 3, 4, 5};
    static final int[] secondStudent = {2, 1, 2, 3, 2, 4, 2, 5};
    static final int[] thirdStudent = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] answer ={};
        int[] students = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == firstStudent[i % firstStudent.length]) {
                students[0]++;
            }
            if (answers[i] == secondStudent[i % secondStudent.length]) {
                students[1]++;
            }
            if (answers[i] == thirdStudent[i % thirdStudent.length]) {
                students[2]++;
            }
        }
        int max = Math.max(Math.max(students[0], students[1]), students[2]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == students[i]) {
                list.add(i + 1);
            }
        }
        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        //[1,2,3,4,5]	[1]
        Test test = new Test();
        System.out.println(test.solution(new int[]{1, 2, 3, 4, 5}));
    }
}
