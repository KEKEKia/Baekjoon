import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for(int n = 0 ; n<N; n++) {
			int tmpNum = sc.nextInt();
			
			
			if(tmpNum!=0) {
				pq.add(tmpNum);
			}else if (tmpNum == 0 && !pq.isEmpty()) {
				sb.append(pq.poll() + "\n");
			}else sb.append(0 + "\n");

		}
		System.out.print(sb);
	}
	
}