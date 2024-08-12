import java.util.*;
import java.io.*;


public class Main {
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.valueOf(str);
		int[] arrN = new int[N];
		str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		for(int n = 0; n < N; n++) {
			arrN[n] = Integer.valueOf(st.nextToken());
		}
		str = br.readLine();
		int M = Integer.valueOf(str);
		str= br.readLine();
		st = new StringTokenizer(str);
		int[] arrM = new int[M];
		for(int m = 0 ; m < M; m++) {
			arrM[m] = Integer.valueOf(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(arrM));
		
		
		//완전탐색
//		for(int m = 0 ; m < M; m++) {
//			for(int n = 0 ; n < N; n++) {
//				if(arrM[m]==arrN[n]) {
//					System.out.print(1 + " ");
//					break;
//				}
//				if(n==N-1) System.out.print(0 + " ");
//			}
//		}
		
		// 시간 복잡도는 O(N*M) -> 문제 조건에서 최악의 케이스는 2500억개의 연산
		
		
		//이분탐색 while문을 쓰는게 기본
		Arrays.sort(arrN);
		for(int m = 0; m<M; m++) {
			//초기 index
			int start = 0; 
			int end = N-1;

//			System.out.println("인간디버거 이정석");
			while(start<=end) {
				int mid = (start + end)/2;
				int valueMid = arrN[mid];
				if(valueMid>arrM[m]) {
					end = mid-1;
				}else if (valueMid<arrM[m]) {
					start = mid+1;
				}else {
					System.out.print(1 + " ");
					break;
				}
				if(start>end) {
					System.out.print(0 + " ");
					break;
				}
			}
			
			
		}
		
		
	}
	

}