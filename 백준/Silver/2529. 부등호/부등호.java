import java.util.*;

public class Main {
    static int N;
    static List<String> list;
    static String[] arrStr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        list = new ArrayList<>();
        arrStr = new String[N];

        for (int n = 0; n < N; n++) {
            arrStr[n] = sc.next();
        }

        // 0부터 9까지의 숫자를 조합하여 가능한 수를 찾는다.
        for (int i = 0; i <= 9; i++) {
            boolean[] visited = new boolean[10]; // 각 숫자의 사용 여부를 체크하기 위한 배열
            visited[i] = true; // 현재 숫자를 방문했음을 표시
            dfs(0, String.valueOf(i), visited); // 깊이 우선 탐색을 통해 가능한 수를 찾음
        }

        System.out.println(list.get(list.size() - 1)); // 최소값 출력
        System.out.println(list.get(0)); // 최대값 출력
    }

    static void dfs(int depth, String str, boolean[] visited) {
        if (depth == N) {
            list.add(str); // 깊이가 N이 되었을 때 결과를 리스트에 추가
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i] && check(str.charAt(depth) - '0', i, arrStr[depth])) {
                visited[i] = true; // 현재 숫자를 방문했음을 표시
                dfs(depth + 1, str + i, visited); // 다음 자리수를 탐색
                visited[i] = false; // 백트래킹을 위해 방문 여부를 초기화
            }
        }
    }

    static boolean check(int a, int b, String sign) {
        if (sign.equals(">")) {
            return a > b;
        } else {
            return a < b;
        }
    }
}