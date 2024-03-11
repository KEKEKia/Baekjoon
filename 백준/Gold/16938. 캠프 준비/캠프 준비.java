import java.util.*;

public class Main {
    static int answer, N, L, R, X;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        X = sc.nextInt();
        arr = new int[N];
        for (int n = 0; n < N; n++) {
            arr[n] = sc.nextInt();
        }
        answer = 0;
        dfs(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(answer);
    }

    static void dfs(int now, int sum, int min, int max) {
        if (now == N) {
            if (sum >= L && sum <= R && max - min >= X) {
                answer++;
            }
            return;
        }

        // 현재 요소를 선택하지 않는 경우
        dfs(now + 1, sum, min, max);
        // 현재 요소를 선택하는 경우
        dfs(now + 1, sum + arr[now], Math.min(min, arr[now]), Math.max(max, arr[now]));
    }
}