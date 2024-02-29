import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        System.out.println(dfs(b, a));
    }

	private static int dfs(String b, String a) {
		
		if(b.length()==a.length()) {
			if(a.equals(b)) return 1;
			else return 0;
		}
		
		
		int tmp = 0 ;
		
		if(b.charAt(0)=='B') {
			String subString = b.substring(1);
			StringBuilder sb = new StringBuilder(subString);
			String str=sb.reverse().toString();
			tmp+= dfs(str, a);
		}
		
		if(b.charAt(b.length()-1)=='A') {
			tmp += dfs(b.substring(0, b.length()-1), a);
		}
		return tmp> 0 ? 1 : 0;
	}


}