import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE ;
		for(int n = 0 ; n  < N ; n ++) {
			int tmp = Integer.parseInt(br.readLine());
			max=Math.max(tmp, max);
			arr[n] = tmp;	
		}
//		System.out.println(Arrays.toString(arr));
//		max++;
		long start = 1 ; 
		long end = max;
		long mid =0 ;
		while(start<=end) {
			mid = (start+end)/2;
			
			int cnt = 0 ;
			for(int n =0; n< N; n++) {
				cnt+=arr[n]/mid;
			}
			if(cnt<K) {
				end=mid-1;
			}else {
				start = mid + 1;
			}
			
		}
		System.out.println(end);
		
	}
}