import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] parent;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList[M];
		parent = new int[N + 1];

		for (int n = 0; n <= N; n++) {
			parent[n] = n;
		}
		for (int m = 0; m < M; m++) {
			graph[m] = new ArrayList<>();
		}
		// 셋팅완.

		// 두번째줄입력
		int numLier = sc.nextInt();

		if (numLier == 0) {
			System.out.println(M);
		} else {
			int ans = M; // 정답 인자.
			int determinator = 0; // 식별자.
			int[] tmpArr = new int[numLier];
			for (int n = 0; n < numLier; n++) {
				tmpArr[n] = sc.nextInt();
			}
			Arrays.sort(tmpArr);


			for (int t = 1; t < numLier; t++) {
				union(tmpArr[0], tmpArr[t]);
			} // 첫 거짓말 아는 사람들의 무리들을 최소 숫자로 union

			// 세번째줄부터입력
			for (int m = 0; m < M; m++) {
				int tmp = sc.nextInt();
				int[] tmpArr1 = new int[tmp];

				for (int t = 0; t < tmp; t++) {
					tmpArr1[t] = sc.nextInt();
					graph[m].add(tmpArr1[t]);
				}
				Arrays.sort(tmpArr1);
				// 가장 작은 친구를 부모로 삼는 unionfind구조
				for (int t = 1; t < tmp; t++) {
					union(tmpArr1[0], tmpArr1[t]);
				}
			}
			determinator = find(tmpArr[0]);// 최저값으로 식별자 선언. 앞으로 이 '식별자'
			// 라는 친구가 parent[x]인 x들은 모두 거짓말을 아는 것임.
			for (ArrayList<Integer> lists : graph) {
				for (int items : lists) {
					if (find(items) == determinator) {
						ans--;
						break;
					}
				}
			}
			System.out.println(ans);
		}
//		System.out.println(Arrays.toString(graph));
//		System.out.println(Arrays.toString(parent));
//		System.out.println(find(3));
		// 여까진 구현 잘되어쓤!

	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a >= b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return find(parent[a]);
	}

}