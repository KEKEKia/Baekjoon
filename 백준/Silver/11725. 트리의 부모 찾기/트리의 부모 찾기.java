import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr, ans;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		ans = new int[N+1];
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int n =0; n<=N; n++) {
			graph[n]=new ArrayList<>();
		}
		
		for(int n=0 ; n<N-1; n++) {
			str =br.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1]=true;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for(int numbers : graph[tmp]) {
				if(!visited[numbers]) {
					visited[numbers]=true;
					queue.add(numbers);
					ans[numbers]=tmp;
				}
			}
		}
		
		for(int n=2;n<=N;n++)
			System.out.println(ans[n]);
		
		
	}
	
}