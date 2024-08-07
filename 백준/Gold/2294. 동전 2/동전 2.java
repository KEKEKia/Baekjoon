import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		for(int n = 0 ; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int[] dp = new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0; // dp 배열 초기값 설정
		
		for(int k = 1; k <= K; k++) {
			for(int n = 0; n < N; n++) {
				if (k - arr[n] >= 0 && dp[k - arr[n]] != Integer.MAX_VALUE) {
					dp[k] = Math.min(dp[k - arr[n]] + 1, dp[k]);
				}
			}
		}
		
		if(dp[K] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}
	}
}