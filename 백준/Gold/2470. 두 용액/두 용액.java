import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //전체 용액의 수 입력
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sol = new int[N]; 

        //용액의 값 입력
        for (int i = 0; i < N; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }

        binaryResearch(sol, N);

    }

    private static void binaryResearch(int[] sol, int n) {
        // TODO Auto-generated method stub
        Arrays.sort(sol);

        int first = 0;
        int last = n-1; // 마지막값
        int close = Integer.MAX_VALUE;
        int closefirst = 0, closelast = 0;

        while(first < last) {
            int sum = sol[first]+sol[last];

            if(Math.abs(sum)<Math.abs(close)) {
                close =sum;
                closefirst = first;
                closelast = last;
            }

            if(sum>0) {
                last--;
            }else {
                first++;
            }

        }
                System.out.println(sol[closefirst] + " " + sol[closelast]);
    }

}