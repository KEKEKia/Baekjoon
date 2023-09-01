import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        
       
        
       a : for(int i = 0 ; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push("(");
            }else{
                if(stack.isEmpty()){
                    answer = false;
                    break a;
                }stack.pop();
            }
        }
        if(!stack.isEmpty()){
            answer = false;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}