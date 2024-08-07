import java.util.*;


public class Main {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int n = 1; n<= N; n++) {
			graph[n]=new ArrayList<>();
		}
		
		for(int n =0; n<K; n++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		bfs(1);
		
		int ans = 0;
		for(int n = 1; n<= N; n++) {
			if(visited[n]) ans++;
			
		}
		
		System.out.println(ans-1);
	}
	
	
	static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1]=true;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for(int i = 0 ; i < graph[tmp].size();i++) {
				if(visited[graph[tmp].get(i)]) continue;
				queue.add(graph[tmp].get(i));
				visited[graph[tmp].get(i)]=true;
			}
		}
		
		
		
		
		
	}
	
}