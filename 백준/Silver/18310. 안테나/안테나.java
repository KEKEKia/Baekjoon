import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int n = 0 ; n < N; n++) {
			arr[n]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.println((N%2==0)? arr[N/2-1]:arr[N/2] );
		
		
	}
}