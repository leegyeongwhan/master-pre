package codesquad.week2.algorithm;

import java.util.Arrays;

public class 나누어_떨어지는_숫자_배열 {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            int[] answer = new int[arr.length];
            int cnt = 0;

            int[] newArray = Arrays.stream(arr)
                    .filter(i -> i % divisor == 0)
                    .toArray();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % divisor == 0) {
                    answer[i] = arr[i];
                    cnt++;
                }
            }

            if (cnt == 0) {
                answer = new int[1];
                answer[0] = -1;
                return answer;
            }
            Arrays.sort(newArray);
            return newArray;
        }
    }
}
