import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] answer = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
	
		int cnt = 0 ;
		
		for(int n = 0 ; n < N; n++) {
			for(int i = 0 ; i< N; i++) {
				if(cnt == arr[n]&&answer[i]==0) {
					cnt=0;
					answer[i]=n+1;
					break;
				}if(answer[i]==0) {
					cnt++;
				}
				
			}
			
		}
//		System.out.println(Arrays.toString(answer));
		
		
		for(int i : answer) {
			System.out.print(i + " ");
		}
	}

}