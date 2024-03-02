import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int day = sc.nextInt();
            pq.add(new Node(pay, day));
        }

        boolean[] visited = new boolean[10001]; // 각 날짜별로 강연을 했는지 여부를 나타내는 배열
        int answer = 0;
        while (!pq.isEmpty()) {
            Node nodeTmp = pq.poll();
            for (int i = nodeTmp.days; i >= 1; i--) {
                if (!visited[i]) { // 해당 날짜에 강연을 하지 않았다면
                    visited[i] = true; // 강연을 했다고 표시하고
                    answer += nodeTmp.pays; // 급여를 누적
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {
        int pays;
        int days;

        Node(int pays, int days) {
            this.pays = pays;
            this.days = days;
        }

        @Override
        public int compareTo(Node o) {
            if (this.pays == o.pays) { // 급여가 같은 경우
                return o.days - this.days; // 강연일자가 더 큰 순으로 정렬
            }
            return o.pays - this.pays; // 급여가 더 큰 순으로 정렬
        }
    }
}