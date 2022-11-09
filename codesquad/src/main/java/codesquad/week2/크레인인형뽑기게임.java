package codesquad.week2;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {  //1, 5, 3, 5, 1, 2, 1, 4]
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 0; i < moves.length; i++) {
            int idx = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][idx] != 0) {
                    if (stack.peek() == board[j][idx]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][idx]);
                    }
                    board[j][idx] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        크레인인형뽑기게임 s = new 크레인인형뽑기게임();
        System.out.println(s.solution(new int[][]{{0, 0, 0, 0, 0}
                , {0, 0, 1, 0, 3}
                , {0, 2, 5, 0, 1}
                , {4, 2, 4, 4, 2}
                , {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }
}
