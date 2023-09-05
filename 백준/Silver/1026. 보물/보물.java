import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arrA = new int[N];
		int[] arrB = new int[N];
		
		for(int a = 0 ; a<N; a++) {
			arrA[a] = sc.nextInt();
		}
		for(int b = 0 ; b<N; b++) {
			arrB[b] = sc.nextInt();
		}
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		int ans = 0;
		for(int i = 0; i<N; i++) {
			ans+=arrA[i]*arrB[N-1-i];
		}
		System.out.println(ans);
	}
}