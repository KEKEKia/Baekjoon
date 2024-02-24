import java.util.*;


public class Main {
	static int N, answer ;
	static int[][] arr;
	static boolean[] visited;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		answer = 2000000;
		visited = new boolean[N];
		list = new ArrayList<>();
		arr = new int[N][N];
		for(int i = 0 ; i<N; i++) {
			for(int j = 0 ; j<N; j++) {
				arr[i][j]=sc.nextInt();
			}
		}

		dfs(0, 0);
		System.out.println(answer);
	}
	
	static void dfs(int depth, int now) {
		if(depth==N/2) {
//			System.out.println("Start");
//			System.out.println(list);
			List<Integer> listOppo = new ArrayList<>();
			for(int i = 0 ; i< N; i++) {
				listOppo.add(i);
			}
			for(int i : list) {
				listOppo.remove(Integer.valueOf(i));
			}
//			System.out.println(listOppo);
//			System.out.println(answer);
//			System.out.println("End");
//			System.out.println(calculate(listOppo));
//			System.out.println(calculate(list));
			answer = Math.min(answer, Math.abs(calculate(listOppo)-calculate(list)));
			
			return;
		}
		for(int i = now; i< N; i++) {
			if(!visited[i]) {
				visited[i]= true;
				list.add(i);
				dfs(depth+1, i+1);
				list.remove(list.size()-1);
				visited[i]=false;
			}
		}	
	}
	
	static int calculate(List<Integer> list) {
		int sum = 0;
		for(int i=0; i< list.size();i++) {
			for(int j = 0 ; j< list.size(); j++) {
				if(j!=i) {
					sum+=arr[list.get(j)][list.get(i)];

				}
			}
		}
//		System.out.println(sum);
		return sum;
	}
	
	
}