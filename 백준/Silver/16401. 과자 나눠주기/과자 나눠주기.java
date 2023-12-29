import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int M = Integer.valueOf(st.nextToken());
		int N = Integer.valueOf(st.nextToken());
		int[] cookieArr = new int[N];
		str = br.readLine();
		st = new StringTokenizer(str);
		int answer = 0;
		int max = 0;
		for (int n = 0; n < N; n++) {
			cookieArr[n] = Integer.valueOf(st.nextToken());
			max = Math.max(max, cookieArr[n]);
		}

		int start = 1;
		int end = max;
		int middlePoint = 0;
		while (start <= end) {
			int cnt = 0;
			middlePoint = (end + start) / 2;
			for (int n = 0; n < N; n++) {
				if (cookieArr[n] >= middlePoint) {
					cnt++;
				}
				int tmpCookieLength = cookieArr[n]-middlePoint;
				while(true) {
					if(tmpCookieLength>=middlePoint) {
						cnt++;
						tmpCookieLength = tmpCookieLength-middlePoint;
					}else break;
				}
//				System.out.println("루프진입1 : "+ middlePoint);
			}
			if (cnt >= M) {
				answer = middlePoint;
//				System.out.println("루프진입2 : "+ middlePoint);
//				System.out.println(answer);
				start = middlePoint + 1;
			} else {
//				System.out.println("루프진입3 : "+ middlePoint);
				end = middlePoint - 1;
			}
		}
		br.close();
		System.out.println(answer);
	}
}