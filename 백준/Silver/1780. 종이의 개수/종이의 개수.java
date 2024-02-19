import java.util.*;

public class Main {

	static int N, a, b, c ;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a=0;
		b=0;
		c=0;
		N = sc.nextInt(); // 1~7
		arr = new int[N][N];
		
		for(int n = 0 ; n < N; n++) {
			for(int m = 0 ; m<N; m++) {
				arr[n][m] = sc.nextInt();
			}
		}
		dfs(N, 0 , 0);
//		System.out.println(Arrays.deepToString(arr));
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	static void dfs(int n, int rStart, int cStart) {
		if(n == 0) {
			return;
		}
		if(checkOnePiece(n, rStart, cStart)) {
			switch (arr[rStart][cStart]) {
				case -1:
					a++;
					break;
				case 0:
					b++;
					break;
				case 1:
					c++;
					break;
			}
			return;
		}
		
		int part = n / 3;
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0 ; j < 3; j ++) {
				dfs(part, rStart + part * i, cStart + part * j);
			}
		}
	}
	
	static boolean checkOnePiece(int part, int rStart, int cStart) {
		int tmp = arr[rStart][cStart];
		for(int i = rStart ; i<rStart + part; i++) {
			for(int j = cStart; j<cStart + part; j++) {
				if(arr[i][j]!=tmp) {
					return false;
				}
			}
		}
		return true;
	}
}