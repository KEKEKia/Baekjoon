import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		String As = Integer.toBinaryString(A);
		String Bs = Integer.toBinaryString(B);
		
		int C = A^B;
		System.out.println(C);
	}
}