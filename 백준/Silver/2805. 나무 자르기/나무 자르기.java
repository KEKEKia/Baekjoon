import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        str = br.readLine();
        st = new StringTokenizer(str);
        int maxHeight = 0;
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            if (arr[n] > maxHeight) maxHeight = arr[n];
        }

        int start = 0;
        int end = maxHeight;
        int result = 0;

        while (start <= end) { // 수정: 종료 조건을 변경
            int cut = (end + start) / 2;
            long sum = 0; // 수정: sum을 long으로 변경
            for (int n = 0; n < N; n++) {
                if (cut < arr[n]) {
                    sum += arr[n] - cut;
                }
            }
            if (sum >= M) {
                result = cut; // 결과값 저장
                start = cut + 1;
            } else {
                end = cut - 1;
            }
        }
        System.out.print(result);
    }
}