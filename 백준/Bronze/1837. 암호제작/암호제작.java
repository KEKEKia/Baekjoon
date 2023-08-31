import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger P = new BigInteger(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int p = 0; 

		for (int n = 2; n < K; n++) {
			BigInteger T = new BigInteger(String.valueOf(n));
			if (P.mod(T).equals(BigInteger.ZERO)) {
				System.out.print("BAD ");
				System.out.println(T);
				System.exit(0);; // BAD를 찾으면 루프 종료
			}
		}
		System.out.printf("GOOD"); // 모든 n에 대해 BAD가 아니면 GOOD 출력
	}
}