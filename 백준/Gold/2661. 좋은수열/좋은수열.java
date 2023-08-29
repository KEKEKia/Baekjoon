import java.util.Scanner;

public class Main {
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sb = new StringBuilder();
        generateSequence(0);
        sc.close();
    }

    static void generateSequence(int depth) {
        if (depth == N) {
            System.out.println(sb.toString());
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            sb.append(i);
            if (isGoodSequence(sb.toString())) {
                generateSequence(depth + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static boolean isGoodSequence(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            String a = s.substring(len - i);
            String b = s.substring(len - 2 * i, len - i);
            if (a.equals(b)) {
                return false;
            }
        }
        return true;
    }
}