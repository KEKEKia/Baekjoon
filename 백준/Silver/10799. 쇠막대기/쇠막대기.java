import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
//		System.out.println(str.charAt(0));
		
		
		Stack<Character> stack  = new Stack<>();

		int cnt = 0 ; 
		int ans = 0 ;
		char last = 0;
		
		for(int i = 0 ; i< str.length(); i++) {
			char now = str.charAt(i);
			
			if(now == '(') {
				stack.push(now);
				cnt++;
			}else if( now ==')'&& last == ')') { //닫히는 쇠막대기일때 
				stack.pop();
				ans++;
				cnt--;
			}else { //레이저일 때
				stack.pop();
				cnt--;
				ans+=cnt;
			}
			last = now;
			
		}
		System.out.println(ans);
		
	}
}