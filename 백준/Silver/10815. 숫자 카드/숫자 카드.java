import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.valueOf(st.nextToken());
		int[] arr = new int[N];
		str= br.readLine();
		st = new StringTokenizer(str);
		for(int n = 0 ; n < N; n++) {
			arr[n] = Integer.valueOf(st.nextToken());
		}
		str= br.readLine();
		st = new StringTokenizer(str);

		int M = Integer.valueOf(st.nextToken());
		str= br.readLine();
		st = new StringTokenizer(str);
		int[] testArr = new int[M];
		for(int m = 0 ; 	m < M; m++) {
			testArr[m]=Integer.valueOf(st.nextToken());
		}
//		System.out.println(N);
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(M);
		for(int m = 0 ; m<M; m++) {
			
			int starter = 0;
			int ender = N-1;
			int test = testArr[m];
			boolean found = false;

			while(starter<=ender) {

				int middler = (starter+ender)/2;
				
				if(arr[middler]<test) {
					starter= middler+1;
				}else if(arr[middler]>test) {
					ender = middler-1;
				}else {
					found=true;
					break;
				}
				
				
			}
			if(found) {System.out.print(1+" ");}
			else {System.out.print(0 +  " ");}
			
		}
		
		
		
	}
}