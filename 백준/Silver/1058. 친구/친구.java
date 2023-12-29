import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] graph;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(str);
        graph = new int[n][n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = str.charAt(j) == 'Y' ? 1 : 0;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = findFriend(i);
        }
        int result = 0;
        for (int i : arr) {
            result = Math.max(result, i);
        }
        System.out.println(result);
    }

    static int findFriend(int i) {
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (i != j && graph[i][j] == 1) { // i와 j가 다르고, i와 친구인 경우
                cnt++; // 직접 친구일 때는 친구 수 증가
            } else if (i != j && graph[i][j] == 0) { // i와 j가 다르고, i와 친구가 아닌 경우
                for (int k = 0; k < n; k++) {
                    if (graph[i][k] == 1 && graph[j][k] == 1) { // i와 k, j와 k가 모두 친구인 경우
                        cnt++; // 간접적인 친구 관계이므로 친구 수 증가
                        break; // 친구 관계가 확인되었으므로 더 이상 확인할 필요 없음
                    }
                }
            }
        }
        return cnt;
    }
}