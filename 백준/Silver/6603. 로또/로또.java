import java.util.*;

public class Main {
	static int N;
	static List<Integer> list ;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<>();
		
		while (true) {
			N = sc.nextInt();
			visited = new boolean[N];
			if (N == 0)
				break;
			arr = new int[N];
			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}
//			System.out.println(Arrays.toString(arr));
			combination(0, 0);
			System.out.println();
	 	}
		

	}
	
	static void combination(int cnt, int now) {
		if(cnt==6) {
			for(int a : list) {
				System.out.print(a+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i  = now; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				list.add(arr[i]);
				combination(cnt+1, i+1);
				visited[i]=false;
				list.remove(list.size()-1);
			}
			
			
		}
		
		
	}
	
}