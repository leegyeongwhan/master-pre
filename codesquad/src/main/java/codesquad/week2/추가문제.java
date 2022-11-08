package codesquad.week2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 추가문제 {
    public static void main(String[] args) {

        Bfs tree = new Bfs();
        tree.root = new Node(0);
        tree.root.lt = new Node(1);
        tree.root.rt = new Node(2);
        tree.root.lt.lt = new Node(3);
        tree.root.lt.rt = new Node(4);
        tree.root.rt.lt = new Node(5);
        tree.root.rt.rt = new Node(6);
        tree.root.lt.lt.lt = new Node(7);
        tree.bfs(tree.root);
        System.out.println();

        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);

        graph.DFS(0); /* 주어진 노드를 시작 노드로 DFS 탐색 */
        //graph.DFS(); /* 비연결형 그래프의 경우 */
    }


}

class Node {
    int data = 0;
    Node lt, rt, mid;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

class Bfs {
    Node root;

    public static void bfs(Node treeRoot) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeRoot);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            System.out.print(curNode.data + " ");
            if (curNode.lt != null) queue.offer(curNode.lt);
            if (curNode.rt != null) queue.offer(curNode.rt);
        }
    }
}

class Graph {
    private int V;
    private LinkedList<Integer> adj[]; // 인접 리스트

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) // 인접 리스트 초기화
            adj[i] = new LinkedList();
    }

    //노드를 연결 v->w
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    //** DFS에 의해 사용되는 함수
    void DFSUtil(int v, boolean visited[]) {
        System.out.print(v + " ");
        // 현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[v] = true;

        // 방문한 노드와 인접한 모든 노드를 가져온다.
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
            if (!visited[n])
                System.out.print(v + " ");

            DFSUtil(n, visited); // 순환 호출
        }
    }

    /**
     * 주어진 노드를 시작 노드로 DFS 탐색
     */
    void DFS(int v) {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean visited[] = new boolean[V];

        // v를 시작 노드로 DFSUtil 순환 호출
        DFSUtil(v, visited);
    }
}
