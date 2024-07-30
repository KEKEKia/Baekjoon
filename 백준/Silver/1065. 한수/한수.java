import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		int answer = 0;

		for (int n = 1; n <= N; n++) {
			String strTmp = String.valueOf(n);
			if (strTmp.length() == 1)
				answer++;
			else if (strTmp.length() == 2)
				answer++;
			else {

				if (strTmp.charAt(0) - strTmp.charAt(1) == strTmp.charAt(1) - strTmp.charAt(2)) {
					answer++;
				}
			}

		}
		System.out.println(answer);
	}
}