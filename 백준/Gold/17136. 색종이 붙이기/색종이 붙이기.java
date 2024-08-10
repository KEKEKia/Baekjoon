import java.util.*;

public class Main {
	static int[][] arr;
	static int[] paper;
	static boolean[][] visited;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10][10];
		paper = new int[] { 0, 5, 5, 5, 5, 5 };
		visited = new boolean[10][10];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0, 0);
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}

	private static void dfs(int i, int j, int cnt) {
		if(i>=9 && j>9) {
			ans = Math.min(ans, cnt);
			return;
		}
		if(ans <= cnt) {
			return ;
		}
		if(j>9) {
			dfs(i+1, 0, cnt);
			return;
		}
		
		if(arr[i][j]==1) {
			for(int k = 5; k>0; k--) {
				if(paper[k]>0&& canAttach(i, j, k)) {
					doAttach(i, j, k, 0); //색종이 붙히기
					paper[k]--;
					dfs(i, j+1, cnt+1);
					doAttach(i,j, k, 1);
					paper[k]++;
				}
			}
		}else dfs(i, j+1, cnt);
		
	}

	private static void doAttach(int i, int j, int k, int l) {
		for(int a = i; a<i+k; a++) {
			for(int b = j ; b < j+k; b++) {
				arr[a][b]=l;
			}
		}
		
	}

	private static boolean canAttach(int i, int j, int k) {
		for(int a = i; a<i+k; a++) {
			for(int b = j; b< j+k; b++) {
				if(a<0||a>=10||b<0||b>=10) return false;
				if(arr[a][b]!=1) return false;
			}
		}
		return true;
	}



}