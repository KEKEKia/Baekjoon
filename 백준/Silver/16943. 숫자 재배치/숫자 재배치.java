import java.util.*;
public class Main {
	static int output, answer;
	static String input;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 input = sc.next();
		 output = sc.nextInt();
		 answer= -1;
		 visited = new boolean[input.length()];
		Integer[] arr = new Integer[input.length()];
		
		for(int i = 0 ; i<input.length(); i++) {
			arr[i]=(input.charAt(i)-'0');
		}
		Arrays.sort(arr, Collections.reverseOrder());
//		System.out.println(Arrays.toString(arr));
		
		System.out.println(dfs(arr, 0, ""));
		
	}
	static int dfs(Integer[] arr, int now, String str) {
		
		if(now==input.length()&&Integer.parseInt(str)<=output&&String.valueOf(Integer.valueOf(str)).length()==input.length()) {
			
			answer = Math.max(answer, Integer.valueOf(str));
		}
		for(int i =0; i< input.length(); i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(arr, now+1, str+arr[i]);
				visited[i]=false;
			}
		}
		return answer;
		
	}
	
}