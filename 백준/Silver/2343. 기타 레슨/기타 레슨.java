import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        str= br.readLine();
        st= new StringTokenizer(str);
        int sum = 0; // 모든 레슨의 길이 합을 저장할 변수입니다.
        int max = 0; // 레슨의 최대 길이를 저장할 변수입니다.
        for(int n = 0 ; n < N ;n++) {
            arr[n]=Integer.parseInt(st.nextToken());
            sum += arr[n]; // 각 레슨의 길이를 모두 합칩니다.
            max = Math.max(max, arr[n]); // 레슨 중 최대 길이를 갱신합니다.
        }
        
        int start = max; // 최소 길이는 레슨 중 최대 길이여야 합니다.
        int end = sum; // 최대 길이는 모든 레슨의 길이를 합한 값입니다.
        
        while(start <= end) {
            int mid = (start + end) / 2; // 블루레이에 녹화할 수 있는 길이의 중간값을 계산합니다.
            int cnt = 0; // 블루레이 개수를 세는 변수입니다.
            int sumTmp = 0; // 현재 블루레이에 녹화한 레슨의 길이를 저장하는 변수입니다.
            
            for(int n = 0; n < N; n++) {
                if(sumTmp + arr[n] > mid) { // 레슨의 길이가 블루레이에 녹화할 수 있는 길이보다 커지면
                    cnt++; // 새로운 블루레이에 레슨을 녹화합니다.
                    sumTmp = 0; // 블루레이에 녹화한 레슨의 길이를 초기화합니다.
                }
                sumTmp += arr[n]; // 현재 블루레이에 레슨을 녹화합니다.
            }
            
            // 남은 레슨이 있을 경우 하나의 블루레이에 녹화합니다.
            if(sumTmp > 0)
                cnt++;
            
            // 블루레이 개수가 목표치보다 크거나 같으면 블루레이 길이를 늘립니다.
            if(cnt <= M)
                end = mid - 1;
            // 블루레이 개수가 목표치보다 작으면 블루레이 길이를 줄입니다.
            else
                start = mid + 1;
        }
        
        System.out.println(start); // 최소 길이가 정답입니다.
        
    }
}