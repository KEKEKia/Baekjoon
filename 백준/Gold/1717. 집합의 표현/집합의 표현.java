import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =  br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        size = new int[N+1];
        for (int n = 1; n <= N; n++) {
            parent[n] = n;
            size[n] = 1;
        }

        for (int m = 0; m < M; m++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int C =  Integer.parseInt(st.nextToken());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());

            if (C == 0) {
                union(a, b);
            } else {
                System.out.println((find(a) == find(b)) ? "YES" : "NO");
            }
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // 경로 압축
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }
}