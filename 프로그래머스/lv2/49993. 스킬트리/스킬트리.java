class Solution {
    static int[] topology;
    static String skillCopied;
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int length = skill_trees.length;
        skillCopied = skill;

        for(int i = 0 ; i< length ; i++){
            if(good(skill_trees[i])){
                answer++;
            }
        }
        return answer;
    }
    
    static boolean good(String str){
        String tmpString = "";
        for(int i = 0 ; i< str.length(); i++){
            if(skillCopied.contains(String.valueOf(str.charAt(i)))){
                tmpString+=String.valueOf(str.charAt(i));
            }
        }
        for(int i = 0 ; i<tmpString.length(); i++){
            if(tmpString.charAt(i)!=skillCopied.charAt(i)){
                return false;
            }
        }
        return true;
    }
    
}