import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        for(String p : participant){
            if(hashmap.get(p) != null) hashmap.put(p, hashmap.get(p)+1);
            else hashmap.put(p, 1);
        }
        
        for(String c : completion) hashmap.put(c, hashmap.get(c) -1);
        
        for(String p : participant){
            if(hashmap.get(p) != 0){
                answer = p;
                break;
            }
        }
        return answer;      
    }
}