public class Main {

	public static void main(String[] args) {
		
		boolean[] check = new boolean[10001];
//		System.out.println(d(57));
		
		for(int i =1; i< 10001; i++) {
			int tmp = d(i);
			if(tmp<10001) {
				check[tmp]=true;				
			}
		}

		for(int i = 1; i<10001;i++) {
			if(!check[i]) System.out.println(i);
		}
		
		
	}
	static int d(int n) {
		int sum = n;
		
		while(n!=0){
			sum+=n%10;
			n = n/10;			
		}
		return sum;
	}
}