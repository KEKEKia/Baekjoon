import java.util.*;
import java.io.*;

public class Main {
	static int L, C;
	static String[] code;
	static String[] stringArray;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		code = new String[L];
		stringArray = new String[C];
		for(int c = 0; c < C; c++) {
			stringArray[c]=sc.next();
		}
		Arrays.sort(stringArray);
		makePassword(0, 0);
		
	}
	
	
	private static void makePassword(int i, int idx) {
		StringBuilder sb = new StringBuilder();;

        if (idx == L) {
            
            if (!goodPassword()) {
                for(String a : code) {
                	sb.append(a);
                }
               System.out.println(sb);
               
            }
            return;
        }

        for (int a = i; a < C; a++) {
            code[idx] = stringArray[a];
            makePassword(a+1, idx + 1);
        }
    }
	
	//조건 판정
	private static boolean goodPassword() {
		int A = 0 ; 
		int B = 0 ; 
		
		
		for( int a = 0 ; a<code.length; a++) {
			if(code[a].equals("a")||code[a].equals("e")||code[a].equals("i")||code[a].equals("o")||code[a].equals("u")) A++;
			else B++;
		}
		if(A<1||B<2) {
			return true;
		}
		
		return false;
	}
}