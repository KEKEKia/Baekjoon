import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int n = 1; n <= N; n++) {
            graph[n] = new ArrayList<>();
        }

        for (int n = 0; n < K; n++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);

        int ans = 0;
        for (int n = 1; n <= N; n++) {
            if (visited[n]) ans++;
        }

        System.out.println(ans - 1);
    }

    static void dfs(int n) {
        visited[n] = true; // 현재 노드를 방문으로 표시

        for (int i = 0; i < graph[n].size(); i++) {
            int next = graph[n].get(i);
            if (!visited[next]) {
                dfs(next); // 다음 노드로 이동
            }
        }
    }
}