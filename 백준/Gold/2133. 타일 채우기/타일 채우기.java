import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];

//		N=4일때까지는 우리가 하나하나 입력해주는게 좋을거 같다.

		if (N >= 4) {
			dp[0] = 1;
			dp[2] = 3;
			dp[4] = 11;
			for (int n = 5; n <= N; n++) {
				dp[n] = dp[n - 2] * 3;
				for (int m = n - 4; m >= 0; m -= 2) {
					dp[n] += 2 * dp[m];
				}
			}
//			System.out.println(Arrays.toString(dp));
			System.out.println(dp[N]);
		} else {
			switch(N) {
			case 1 : {System.out.println(0); break;}
			case 2 : {System.out.println(3); break;}
			case 3 : {System.out.println(0); break;}
			}
		
		}

	}
}