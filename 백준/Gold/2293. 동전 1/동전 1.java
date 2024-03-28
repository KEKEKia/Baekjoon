import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		int dp[] = new int[K + 1];
		dp[0] = 1;
		// top-down
		for (int i = 0; i < N; i++) {
			for (int k = 1; k <= K; k++) {
				if (k - arr[i] >= 0) {
//					System.out.print("뭄뭄");
					dp[k] += dp[k - arr[i]];
				}

			}
		}
		System.out.println(dp[K]);

	}
}