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
    public static String path = "";        // 이동경로


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
        path = "";
        System.out.println("이동한거리는= " + bfs() + " " + path);

    }

    private static int bfs() {

        int ret = 0;
        int curX = 0;        // 현재 row
        int curY = 0;        // 현재 col
        int curDist = 1;    // 현재 이동한 거리
        String curPath = "";    // 현재까지 이동경로
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, curDist, curPath));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            curX = point.getX();
            curY = point.getY();
            curDist = point.getDist();
            curPath = point.getPath();
            path = curPath;
            ret = curDist; //거리
            visit[curX][curY] = true;


            // 목적지에 도착하면 루핑 종료
            if (curX == N - 1 && curY == M - 1) {
                break;
            }

            // 위로 갈수 있으면
            if (curX - 1 >= 0 && !visit[curX - 1][curY]) {
                queue.add(new Point(curX - 1, curY, curDist + 1, curPath));
            }
            // 아래로 갈수 있으면
            if (curX + 1 < N && !visit[curX + 1][curY]) {
                queue.add(new Point(curX + 1, curY, curDist + 1, curPath));
            }
            // 왼쪽으로 갈수 있으면
            if (curY - 1 >= 0 && !visit[curX][curY - 1]) {
                queue.add(new Point(curX, curY - 1, curDist + 1, curPath));
            }
            // 오른쪽으로 갈수 있으면
            if (curY + 1 < M && !visit[curX][curY + 1]) {
                queue.add(new Point(curX, curY + 1, curDist + 1, curPath));
            }
        }
        return ret;
    }


    public static boolean dfs(int x, int y, boolean[][] clone) {

        if (x == N - 1 && y == M - 1) {
            return true;
            // 종료
        } else {

            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];

                if (nx >= 0 && nx <= N - 1 && ny >= 0 && ny <= M - 1 && map[nx][ny] == 1) {
                    if (!clone[nx][ny]) {
                        clone[nx][ny] = true;
                        dfs(nx, ny, clone);
                        clone[nx][ny] = false;
                    }
                }
            }
        }
        return false;
    }

}

class Point {
    private int x;
    private int y;
    private int dist;
    String path;

    public Point(int x, int y, int dist, String path) {
        this.x = x;
        this.y = y;
        this.dist = dist;

        if ("".equals(path)) {
            this.path = "(" + x + ", " + y + ")";
        } else {
            this.path = path + " -> " + "(" + x + ", " + y + ")";
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDist() {
        return dist;
    }

    public String getPath() {
        return path;
    }
}