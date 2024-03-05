import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		str= br.readLine();
		st= new StringTokenizer(str);
		int end = 0;
		int maxValue =Integer.MIN_VALUE; ;
		for(int n = 0 ; n < N ;n++) {
			arr[n]=Integer.parseInt(st.nextToken());
			end+=arr[n];
			maxValue = Math.max(maxValue, arr[n]);
		}
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(end);
		
		
		int start = maxValue ;
		
		
		while(start<=end) {
			int bluerayCnt = 0 ; //이 친구가 M이어야함.
			int mid = (start+end)/2;
			int sumTmp = 0; 
			for(int n =0 ; n< N; n++) {
				if(sumTmp+arr[n]>mid) {
					bluerayCnt++;
//					System.out.println(sumTmp);
					sumTmp=0;
				}
				sumTmp+=arr[n];		
			}
			
			if(sumTmp>0) bluerayCnt++;
			
			if(bluerayCnt<=M) {
//				System.out.println("blueRay는 : "+bluerayCnt);
				end = mid -1;
			}else {
				start = mid + 1 ;
			}
			
		}
		
		System.out.println(start);
		
	}
	
	
	
}