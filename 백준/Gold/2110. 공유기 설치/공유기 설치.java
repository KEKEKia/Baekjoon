import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        for(int n = 0 ; n <  N ; n++) {
            str = br.readLine();
            arr[n] = Integer.parseInt(str);
        }
        Arrays.sort(arr);
        
        int start = 1; // 최소 간격은 1이어야 합니다.
        int end = arr[N-1]-arr[0];
        
        while(start <= end) {
            int mid = (start + end) / 2; // 중간값을 올바르게 계산합니다.
            int installed = 1; // 공유기가 설치된 집의 개수를 카운트합니다.
            int prevHouse = arr[0]; // 이전에 공유기가 설치된 집의 위치를 저장합니다.
            
            for(int n = 1 ; n < N ; n ++) {
                int distance = arr[n] - prevHouse; // 현재 집과 이전 집 사이의 거리를 계산합니다.
                if(distance >= mid) { // 현재 집과 이전 집 사이의 거리가 mid 이상이면 공유기 설치가 가능합니다.
                    installed++;
                    prevHouse = arr[n]; // 공유기가 설치된 집의 위치를 갱신합니다.
                }
            }
            
            // 설치된 공유기의 개수에 따라 이분 탐색 범위를 조절합니다.
            if(installed >= C) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(end); // 최대한 많이 설치한 경우가 정답입니다.
    }
}