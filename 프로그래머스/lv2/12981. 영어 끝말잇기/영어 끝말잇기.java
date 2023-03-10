import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = new int[]{0, 0};
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            if(set.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                result[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                result[1] = i / n + 1;
                break;
            } else set.add(words[i]);
        }
        return result;
    }
}