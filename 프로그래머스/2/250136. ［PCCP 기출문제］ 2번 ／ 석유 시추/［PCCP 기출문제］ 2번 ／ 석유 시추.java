import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] landBottom;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int height, width;

    public int solution(int[][] land) {
        int answer = 0;
        height = land.length;
        width = land[0].length;
        visited = new boolean[height][width];
        landBottom = new int[width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }

        for (int i = 0; i < width; i++) {
            if (answer < landBottom[i]) answer = landBottom[i];
        }

        return answer;
    }

    static void bfs(int i, int j, int[][] land) {
        Set<Integer> columns = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        visited[i][j] = true;
        int oilCount = 1; // 현재 셀도 포함

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            columns.add(node.j);

            for (int k = 0; k < 4; k++) {
                int nr = node.i + dr[k];
                int nc = node.j + dc[k];

                if (nr >= 0 && nc >= 0 && nr < height && nc < width && !visited[nr][nc] && land[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new Node(nr, nc));
                    oilCount++;
                }
            }
        }

        for (int col : columns) {
            landBottom[col] += oilCount;
        }
    }

    static class Node {
        int i;
        int j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
