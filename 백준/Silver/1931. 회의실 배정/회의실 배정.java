import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] arr = new Node[N];
		for(int n = 0 ; n  <  N; n ++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());			
			arr[n]= new Node(a, b);
			
		}
		Arrays.sort(arr);
//		System.out.println(Arrays.deepToString(arr));
		
		int answer = 1;
		int checkInt = arr[0].end ; 
		for(int n = 1 ; n <  N ; n++) {
			if(arr[n].start>=checkInt) {
				answer++;
				checkInt = arr[n].end;
//				System.out.println(arr[n]);
			}
			
		}
		System.out.println(answer);
		
	}
	
	static class Node implements Comparable<Node>{
		int start;
		int end;
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Node o) {
			if(this.end==o.end) {
				return this.start-o.start;
			}
		else{
			return this.end-o.end;
		}
		}
		@Override
		public String toString() {
			
			
			return "("+start + ", " +end+")";
		}
	}
}