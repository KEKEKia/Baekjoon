import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong(); // N이 클 수 있으므로 long 타입 사용
		long[] arr = new long[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = sc.nextLong();
		}

		if (N == 1) { // N이 1일 때 특별한 케이스 처리
			long maxVal = Long.MIN_VALUE;
			long sum = 0;
			for (int i = 0; i < 6; i++) {
				sum += arr[i];
				maxVal = Math.max(maxVal, arr[i]);
			}
			System.out.println(sum - maxVal);
		} else {
			long oneFace = findMinOneVal(arr);
			long twoFaces = findMinTwoVal(arr);
			long threeFaces = findMinThreeVal(arr);

			long result = oneFace * (5 * N * N - 16 * N + 12) + twoFaces * (8 * N - 12) + threeFaces * 4;
			System.out.println(result);
		}
	}

	static long findMinOneVal(long[] arr) {
		long min = Long.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			min = Math.min(min, arr[i]);
		}
		return min;
	}

	static long findMinTwoVal(long[] arr) {
		long min = Long.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (j != 5 - i) {
					min = Math.min(min, arr[i] + arr[j]);
				}
			}
		}
		return min;
	}

	static long findMinThreeVal(long[] arr) {
		long min = Long.MAX_VALUE;
		min = Math.min(min, arr[0] + arr[1] + arr[2]);
		min = Math.min(min, arr[0] + arr[1] + arr[3]);
		min = Math.min(min, arr[0] + arr[2] + arr[4]);
		min = Math.min(min, arr[0] + arr[3] + arr[4]);
		min = Math.min(min, arr[1] + arr[2] + arr[5]);
		min = Math.min(min, arr[1] + arr[3] + arr[5]);
		min = Math.min(min, arr[2] + arr[4] + arr[5]);
		min = Math.min(min, arr[3] + arr[4] + arr[5]);
		return min;
	}
}