import java.io.*;
import java.util.*;

public class Main {
	static int N, M, answer;
	static boolean[][] visited;
	static boolean[] visitedCombi;
	static int[][] arr;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		visited=new boolean[N][M];
		answer = 0;
		arr = new int[N][M];
		for (int n = 0; n < N; n++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.valueOf(st.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(arr));

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
//				answer=0;
				dfs(new int[] { i, j }, 0, 0);

			}
		}
		System.out.println(answer);
	}

	static void dfs(int[] arrNow, int now, int depth) {
		if (depth == 4) {
//			System.out.println(now);
			answer = Math.max(answer, now);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = arrNow[0] + dr[i];
			int nc = arrNow[1] + dc[i];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if(visited[nr][nc]) continue;
				if(depth==2) {
					visited[nr][nc] =true;
					dfs(new int[]{arrNow[0], arrNow[1]}, now + arr[nr][nc], depth+1);
					visited[nr][nc] =false;
				}
				
				visited[nr][nc] = true;
				dfs(new int[] { nr, nc }, now+arr[nr][nc], depth + 1);
				visited[nr][nc] = false;

			}

		}

	}

}