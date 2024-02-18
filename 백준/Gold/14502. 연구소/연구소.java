import java.util.*;
import java.io.*;

public class Main {
    static int N, M, answer;
    static int[][] arr;
    static boolean[] visitedCombi;
    static List<Integer> list;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        answer = 0;
        arr = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                arr[n][m] = sc.nextInt();
            }
        }

        visitedCombi = new boolean[N * M];
        list = new ArrayList<>();
        combination(N * M, 0, 0);
        System.out.println(answer);
    }

    static void combination(int numbers, int depth, int count) {
        if (depth == 3) {
            bfs(list);
            return;
        }

        for (int i = count; i < numbers; i++) {
            if (!visitedCombi[i]) {
                visitedCombi[i] = true;
                list.add(i);
                combination(numbers, depth + 1, i + 1);
                visitedCombi[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    static void bfs(List<Integer> list) {
        int cntTmp = 0;
        Queue<Node> queue = new LinkedList<>();
        int[][] arrTmp = new int[N][M];
        for (int n = 0; n < N; n++) {
            arrTmp[n] = arr[n].clone();
        }

        for (Integer n : list) {
            if (arr[n / M][n % M] == 0) {
                arrTmp[n / M][n % M] = 1;
            } else {
                return;
            }
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (arrTmp[n][m] == 2) {
                    queue.add(new Node(n, m));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node nodeTmp = queue.poll();
            int r = nodeTmp.r;
            int c = nodeTmp.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && arrTmp[nr][nc] == 0) {
                    arrTmp[nr][nc] = 2;
                    queue.add(new Node(nr, nc));
                }
            }
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (arrTmp[n][m] == 0) {
                    cntTmp++;
                }
            }
        }
        answer = Math.max(answer, cntTmp);
    }

    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}