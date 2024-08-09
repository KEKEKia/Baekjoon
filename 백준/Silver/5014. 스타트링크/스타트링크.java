import java.util.*;

public class Main {

	static int F, S, G, U, D;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt(); // F층 건물
		S = sc.nextInt(); // 강호 시작 층
		G = sc.nextInt(); // 스타트링크 층
		U = sc.nextInt(); // 올라가는 층수
		D = sc.nextInt(); // 내려가는 층수

		visited = new boolean[F + 1];
		if(S==G) {
			System.out.println(0);
		}else bfs(new Node(S, 0));
		

	}

	static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		visited[node.now] = true;
		
		
		while (!queue.isEmpty()) {
			Node nodeTmp = queue.poll();
			int nowTmp = nodeTmp.now;
			int depthTmp = nodeTmp.depth;
			if (nowTmp + U <= F&& !visited[nowTmp+U]) {
				if (nowTmp + U == G) {
					System.out.print(depthTmp + 1);
					return;
				}
				visited[nowTmp+U] =true;
				queue.add(new Node(nowTmp + U, depthTmp + 1));
			}
			if (nowTmp - D > 0&& !visited[nowTmp-D]) {
				if (nowTmp - D == G) {
					System.out.print(depthTmp + 1);
					return;
				}
				visited[nowTmp-D] =true;
				queue.add(new Node(nowTmp - D, depthTmp + 1));
			}
		}
		System.out.println("use the stairs");

	}

	static class Node {
		int now;
		int depth;

		Node(int now, int depth) {
			this.now = now;
			this.depth = depth;
		}
	}

}