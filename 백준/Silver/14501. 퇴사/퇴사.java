import java.util.*;

public class Main {

//	1 2 3 4 5 6 7 8 9
//	2 5 6 8 4 2 2 1 2

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[20];
		int[] arrDays = new int[N];
		int[] arrValue = new int[N];
		for (int n = 0; n < N; n++) {
			arrDays[n]= sc.nextInt();
			arrValue[n]= sc.nextInt();
		}

		for (int n = 0; n < N; n++) {
			
			if(n+arrDays[n]<=N) {
				dp[n + arrDays[n]] = Math.max(dp[n] + arrValue[n], dp[n + arrDays[n]]);				
			}
			dp[n+1] = Math.max(dp[n+1],dp[n]);
		}
		

			System.out.println(dp[N]);	
	}

}