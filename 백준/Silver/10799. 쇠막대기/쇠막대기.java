import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            
            if (now == '(') {
                stack.push(now);
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    ans += stack.size();
                } else {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}