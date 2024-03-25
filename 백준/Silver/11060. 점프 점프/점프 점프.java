import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			if(i!=0&&dp[i]==Integer.MAX_VALUE)  break;
			for (int j = 0; j <= arr[i]; j++) {
				if (i + j < N) {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}

		}
		System.out.println(dp[N-1] = (dp[N-1]==Integer.MAX_VALUE)? -1: dp[N-1]);
	}
}