import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();

		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.valueOf(st.nextToken());
		Node[] arr = new Node[N];
		for (int i = 0; i < N; i++) {
			str = bf.readLine();
			st = new StringTokenizer(str);
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			arr[i] = new Node(a, b);
		}
//        System.out.println(Arrays.deepToString(arr));

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(arr);
		pq.add(arr[0].end);

		for (int n = 1; n < N; n++) {
			if (pq.peek() <= arr[n].start) {
				pq.poll();
				pq.add(arr[n].end);
			} else {
				pq.add(arr[n].end);
			}

		}
		System.out.println(pq.size());

	}

	static class Node implements Comparable<Node> {
		int start;
		int end;

		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if (this.start == o.start)
				return this.end - o.end;
			return this.start - o.start;
		}
	}
}