import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static boolean[][][] visited3d;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited3d = new boolean[N][M][K + 1]; // K까지의 벽 부수는 횟수를 고려하여 초기화

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                arr[n][m] = str.charAt(m) - '0';
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1}); // 시작점 추가

        while (!queue.isEmpty()) {
            int[] tmpArr = queue.poll();
            int r = tmpArr[0];
            int c = tmpArr[1];
            int wall = tmpArr[2];
            int distance = tmpArr[3];

            if (r == N - 1 && c == M - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    if (arr[nr][nc] == 1 && wall < K && !visited3d[nr][nc][wall + 1]) {
                        visited3d[nr][nc][wall + 1] = true;
                        queue.add(new int[]{nr, nc, wall + 1, distance + 1});
                    } else if (arr[nr][nc] == 0 && !visited3d[nr][nc][wall]) {
                        visited3d[nr][nc][wall] = true;
                        queue.add(new int[]{nr, nc, wall, distance + 1});
                    }
                }
            }
        }
        return -1; // 도착점에 도달하지 못할 경우
    }
}