import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int N = Integer.valueOf(str);
		Node[] classes = new Node[N];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Node[] arr = new Node[N];
		
		
		for(int n = 0; n < N; n++) {
			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int classNum = Integer.valueOf(st.nextToken()); 
			int start = Integer.valueOf(st.nextToken()); 
			int end = Integer.valueOf(st.nextToken()); 
			arr[n] = new Node(classNum, start, end);
		}
		Arrays.sort(arr);
		pq.add(arr[0].end);
		
		for(int n  =1 ; n< N; n++) {
			if(arr[n].start>=pq.peek()) {
				pq.poll();
			}
			pq.add(arr[n].end);				
			
			
			
		}
		System.out.println(pq.size());
	}
	
	static class Node implements Comparable<Node>{
		int classNum;
		int start;
		int end;
		
		Node(int classNum, int start, int end){
			this.classNum = classNum;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Node o) {
			if(o.start == this.start) {
				return this.end-o.end;
			}else return this.start - o.start;
		}
		
	}
}