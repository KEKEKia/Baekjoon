import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		String answer = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine();
		// 1. 마지막이 0
		// 2. 각 자리의 숫자들을 다 더해서 3의 배수면 된다.
		int[] arr= new int[10];
		for(int i = 0 ; i < str.length(); i ++) {
			arr[str.charAt(i)-48]++;
		}
//		System.out.println(Arrays.toString(arr));
		if(arr[0]==0) answer = "-1";
		else {
			int checker = 0;
			for(int i=0 ; i < 10; i++) {
				
				checker+=i*arr[i];
			}
			if (checker%3!=0) answer = "-1";
			else {
				StringBuilder sb = new StringBuilder();
				for(int i = 9; i>=0; i--) {
					while(arr[i]>0) {
						sb.append(i);
						arr[i]--;
					}
				}
				answer = String.valueOf(sb);
				
			}
		}
		System.out.println(answer);
	}
}