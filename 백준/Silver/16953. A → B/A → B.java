import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String output = sc.next();
		
		Queue<Node> queue = new LinkedList<Node>();
		int answer = -1;
		int count = 0;
		queue.add(new Node(input, 1));
		while(!queue.isEmpty()) {
			
			Node nodeTmp = queue.poll();
//			System.out.println("poll 된 nodeTmp : "+nodeTmp.value + " cnt : " + nodeTmp.cnt);
			if(nodeTmp.value.equals(output))
			{
				answer = nodeTmp.cnt;
				break;
			}
			count = nodeTmp.cnt+1;
			String strTmpAdd1 =nodeTmp.value+"1";
			String strTmpBy2 = String.valueOf(Long.parseLong(nodeTmp.value)*2);
//			System.out.println(strTmpBy2);
			if(Long.parseLong(strTmpAdd1)<=Long.parseLong(output)) {
				queue.add(new Node(strTmpAdd1, count));
			}if(Long.parseLong(strTmpBy2)<=Long.parseLong(output)) {
				queue.add(new Node(strTmpBy2, count));
			}
			
			
		}
		System.out.println(String.valueOf(answer));
		
	}
	static class Node{
		String value;
		int cnt;
		
		Node(String value, int cnt){
			this.value = value;
			this.cnt = cnt;
		}
		
	}
}