package codesquad.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//10001
//11101
//00111
//00100
//00111


public class _3번문제 {
    static int[][] map;
    static int[][] dfsMap;
    static boolean[][] visit;
    static List<Point> list = new ArrayList<>();
    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};
    static int N;
    static int M;
    static Stack<Point> stack;
    static Boolean exitFlag = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dfsMap = new int[N][M];
        visit = new boolean[N][M];
        dfsMap[0][0] = 1;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - 48;
            }
        }


        bfs(0, 0);

        for (int[] ints : dfsMap) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        while (!stack.isEmpty()) {

            Point point = stack.pop();
            System.out.print(" (" + point.getX() + " " + point.getY() + ") , ");
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        stack = new Stack<>();
        queue.offer(new Point(x, y));
        visit[x][y] = true; //지난 곳은 1로 바꿔준다

        while (!queue.isEmpty()) {
            Point tmpPoint = queue.poll();
            //     Point peek = stack.peek();
//            if (dfsMap[tmpPoint.getX()][tmpPoint.getY()] == dfsMap[peek.getX()][peek.getY()]) {
//
//            }

            stack.add(tmpPoint);

            for (int i = 0; i < 4; i++) {
                int nx = tmpPoint.getX() + dirX[i];
                int ny = tmpPoint.getY() + dirY[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || visit[nx][ny]) {
                    continue;
                }
//
//                if (nx == N - 1 && ny == N - 1) {
//                    exitFlag = true;
//                    return;
//                }
                // 아니라면 더 가기
//                bfs(nx, ny);
//                if (!exitFlag) {
//                   stack.pop(); // 되돌아가는 좌표 pop
//                }

                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    // 0,0  1,0 0,1
                    queue.offer(new Point(nx, ny));
                    dfsMap[nx][ny] = dfsMap[tmpPoint.getX()][tmpPoint.getY()] + 1;
                }
            }
        }
    }

}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

