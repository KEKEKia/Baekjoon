import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1]; // 도시는 1부터 시작하므로 N+1 크기의 배열 사용
        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 초기에는 자기 자신을 가리키도록 설정
        }

        // 연결 정보 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if (isConnected == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        // 여행 계획에 포함된 도시들의 부모 노드 찾기
        int root = find(plan[0]);
        boolean possible = true;
        for (int i = 1; i < M; i++) {
            if (root != find(plan[i])) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
}