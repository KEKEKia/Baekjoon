import java.util.*;


public class Main {
	static int N;
	static Set<String> set;
	static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int answer = 0 ;
		int[] arrAlpha = new int[26];
//		System.out.println(Integer.valueOf('A')-65);
//		System.out.println(Integer.valueOf('Z')-65);
		for(int n = 0 ; n<N ; n++) {
			String str = sc.next();
			int lengthStr = str.length();
			
			for(int i = 0 ; i< lengthStr ; i++) {
				arrAlpha[str.charAt(i)-65]+=(int)Math.pow(10, lengthStr-1-i);
			}
		}
		Arrays.sort(arrAlpha);
//		System.out.println(Arrays.toString(arrAlpha));
//		for(int i =0 ; i<)
		
		
		for(int i = 25; i >=0; i--) {
			if(arrAlpha[i]==0) break;
			answer+=arrAlpha[i]*(i-16);
		}
		System.out.println(answer);
	}
	

}