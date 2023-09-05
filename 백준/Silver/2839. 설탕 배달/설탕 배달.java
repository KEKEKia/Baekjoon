import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int[] dp =  new int[5001];
	Arrays.fill(dp, Integer.MAX_VALUE);
	
	dp[3]=1;
	dp[5]=1;
	
	for(int n = 6; n<=N; n++) {
		dp[n]=Math.min(dp[n-3], dp[n-5])+1;
		if(dp[n]==Integer.MAX_VALUE+1) {
			dp[n]=Integer.MAX_VALUE;
		}
//		System.out.println(dp[n]);
	}
	dp[0]=dp[1]=dp[2]=dp[4]=Integer.MAX_VALUE;
	System.out.println((dp[N]==Integer.MAX_VALUE) ? -1:dp[N]);
	}
}