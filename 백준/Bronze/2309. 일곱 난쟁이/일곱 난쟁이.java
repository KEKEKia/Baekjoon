import java.util.*;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr= new int[9];
		int sum = 0 ;
		List<Integer> answer = new ArrayList<>();
		for(int n = 0 ; n <9; n++) {
			int tmp = sc.nextInt();
			sum+=tmp;
			arr[n]=tmp;
		}
		
		a : for(int i = 0 ; i < 9; i++) {
			for(int j = i; j<9; j++) {
				if(i!=j) {
					int tmp = sum-arr[i]-arr[j];
					if(tmp==100) {
//						System.out.println("걸렸드");
						for(int n = 0 ; n < 9; n++) {
							if(n!=i&&n!=j) {
								answer.add(arr[n]);
							}
						}
						break a;
					}
				}
			}
		}
		
		Collections.sort(answer);
		for(int i : answer) System.out.println(i);
		
	}
}