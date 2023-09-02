import java.util.*;

class Solution {
    static ArrayList<Node>[] graph;

    class Node implements Comparable<Node> {
        int to;
        int price;

        Node(int to, int price) {
            this.to = to;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return this.price - o.price;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프에 간선 정보 추가
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int price = fare[2];

            graph[from].add(new Node(to, price));
            graph[to].add(new Node(from, price));
        }

        int answer = Integer.MAX_VALUE;

        // 다익스트라 알고리즘을 s, a, b 각각에 대해서만 실행
        int[] dpS = new int[n + 1];
        int[] dpA = new int[n + 1];
        int[] dpB = new int[n + 1];

        Arrays.fill(dpS, Integer.MAX_VALUE);
        Arrays.fill(dpA, Integer.MAX_VALUE);
        Arrays.fill(dpB, Integer.MAX_VALUE);

        dijkstra(s, dpS);
        dijkstra(a, dpA);
        dijkstra(b, dpB);

        // 출발지부터 a와 b까지 합승하는 경우의 요금 계산
        for (int i = 1; i <= n; i++) {
            int sharedFee = dpS[i] + dpA[i] + dpB[i];
            answer = Math.min(answer, sharedFee);
        }

        return answer;
    }

    void dijkstra(int start, int[] dp) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dp[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node next : graph[current.to]) {
                int newCost = dp[current.to] + next.price;
                if (newCost < dp[next.to]) {
                    dp[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
    }
}
