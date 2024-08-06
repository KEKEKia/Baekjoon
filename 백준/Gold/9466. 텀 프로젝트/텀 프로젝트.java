import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static boolean[] hasTeam;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.valueOf(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);

			arr = new int[N+1];
			for (int n = 1; n <= N; n++) {
				arr[n] = Integer.valueOf(st.nextToken());
			}
			visited = new boolean[N + 1];
			hasTeam = new boolean[N + 1];
			cnt=0;
			for(int n = 1 ; n<=N; n++) {
				if(!hasTeam[n]) {
					dfs(n);						
				}
			}
			
		System.out.println(N-cnt);
		}
	}
	
	static void dfs(int n)	{
		if(visited[n]) {
			hasTeam[n]=true;
			cnt++;
		}else {
			visited[n]=true;
		}
		if(!hasTeam[arr[n]]) {
			dfs(arr[n]);
		}
		visited[n] =false;
		hasTeam[n]=true;
	}
	
}