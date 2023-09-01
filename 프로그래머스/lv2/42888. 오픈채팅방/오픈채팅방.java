import java.io.*;
import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record){
     
        Map<String, String> map = new HashMap<>();
        
        
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> result2 = new ArrayList<>();
        
        
        for(String str : record){
            StringTokenizer st = new StringTokenizer(str);
            String orderString = st.nextToken();
            String idString = st.nextToken();
           
            
            if(orderString.equals("Enter")){
                 String nameString = st.nextToken();
                map.put(idString, nameString);
                result.add("님이 들어왔습니다.");
                result2.add(idString);
            }else if (orderString.equals("Leave")){
                result.add("님이 나갔습니다.");
                result2.add(idString);
            }else {
                 String nameString = st.nextToken();
                map.put(idString, nameString);
            }
        }
        
        ArrayList<String> result3 = new ArrayList<>();
       
        for(int i = 0 ; i<result2.size();i++){
            result3.add(map.get(result2.get(i))+result.get(i));
            
        }
        
        
        return result3;
    }
}