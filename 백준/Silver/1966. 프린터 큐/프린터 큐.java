import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();

        for (int t = 0; t < tc; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Queue<Node> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                int priority = scanner.nextInt();
                queue.add(new Node(i, priority));
                priorityQueue.add(priority);
            }

            int answer = 0;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int priority = priorityQueue.peek();

                if (node.priority == priority) {
                    priorityQueue.poll();
                    answer++;
                    if (node.number == M) {
                        System.out.println(answer);
                        break;
                    }
                } else {
                    queue.add(node);
                }
            }
        }
        scanner.close();
    }

    static class Node {
        int number;
        int priority;

        Node(int number, int priority) {
            this.number = number;
            this.priority = priority;
        }
    }
}