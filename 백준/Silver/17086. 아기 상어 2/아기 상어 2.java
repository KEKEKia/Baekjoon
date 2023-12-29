import java.util.*;

public class Main {
    static int[][] space;
    static int N, M;
    static int[] dn = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dm = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        space = new int[N][M];

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                space[n][m] = sc.nextInt();
            }
        }

        int answer = 0;

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (space[n][m] == 0) {
                    answer = Math.max(answer, bfs(n, m));
                }
            }
        }
        System.out.println(answer);
    }

    static int bfs(int n, int m) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Node(n, m, 0)); // 거리를 0으로 초기화
        visited[n][m] = true;

        while (!queue.isEmpty()) {
            Node nodeTmp = queue.poll();
            for (int a = 0; a < 8; a++) {
                int nn = nodeTmp.n + dn[a];
                int nm = nodeTmp.m + dm[a];
                if (nn >= 0 && nm >= 0 && nn < N && nm < M && !visited[nn][nm]) {
                    if (space[nn][nm] == 1) {
                        return nodeTmp.cnt + 1; // 0에서 가장 가까운 1까지의 거리 반환
                    }
                    queue.add(new Node(nn, nm, nodeTmp.cnt + 1));
                    visited[nn][nm] = true;
                }
            }
        }
        return 0; // 1을 찾을 수 없는 경우 -1 반환
    }

    static class Node {
        int n;
        int m;
        int cnt;

        Node(int n, int m, int cnt) {
            this.n = n;
            this.m = m;
            this.cnt = cnt;
        }
    }
}