import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N+1][3];
		
		
		dp[1][0]=1;
		dp[1][1]=1;
		dp[1][2]=1;
		
		
		
		for(int i = 2; i<=N; i++) {
			dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
			dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901;
			dp[i][2]=(dp[i-1][0]+dp[i-1][1])%9901;
		}
		
		System.out.println((dp[N][0]+dp[N][1]+dp[N][2])%9901);
		//dp[n+1]=dp[n]중 공란갯수*3 + 전배치*2+ 후배치+2;
		//에[n+2]=dp[n+1]중 공란갯수 *3 + " ;
	}
	
}