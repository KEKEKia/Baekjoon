import java.util.*;

class Solution {
    public int solution(String name) {

        // 최소 조작 횟수 계산
        int minMoves = calculateMinMoves(name);
        
        int answer = minMoves;
        return answer;
    }
    public static int calculateMinMoves(String name) {
        int totalMoves = 0;
        int length = name.length();
        int minLeftRightMoves = length - 1;

        for (int i = 0; i < length; i++) {
            // 알파벳 변경에 필요한 최소 조작 횟수
            totalMoves += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            // 다음 문자로 이동
            int nextIndex = i + 1;
            // 연속된 'A' 찾기
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            // 이동 방향에 따른 최소 조작 횟수 계산
            minLeftRightMoves =
            		Math.min(Math.min(minLeftRightMoves,2 * i + length - nextIndex),2 * (length - nextIndex) + i);
        }

        return totalMoves + minLeftRightMoves;
    }
}