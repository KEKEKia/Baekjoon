import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int ans = 0;
        LinkedList<Integer> numList = new LinkedList<>();
        for (int n = 1; n <= N; n++) {
            numList.add(n);
        }
        LinkedList<Integer> wanted = new LinkedList<>();
        for (int m = 0; m < M; m++) {
            wanted.add(sc.nextInt());
        }

        while (!wanted.isEmpty()) {
            int wantedValue = wanted.removeFirst();
            int index = numList.indexOf(wantedValue);
            int halfSize = numList.size() / 2;

            if (index <= halfSize) {
                // 왼쪽으로 회전
                while (numList.peek() != wantedValue) {
                    numList.addLast(numList.pollFirst());
                    ans++;
                }
            } else {
                // 오른쪽으로 회전
                while (numList.peek() != wantedValue) {
                    numList.addFirst(numList.pollLast());
                    ans++;
                }
            }

            numList.poll(); // 원하는 값 제거
        }
        System.out.println(ans);
    }
}