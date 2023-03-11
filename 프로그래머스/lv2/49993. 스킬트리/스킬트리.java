class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++) {
            int idx = -1;
            
            loop:
            for(int j = 0; j < skill_trees[i].length(); j++) {
                for(int k = 0; k < skill.length(); k++) {
                    if(skill.charAt(k) == skill_trees[i].charAt(j)) {
                        if(k != idx + 1) break loop;
                        else idx = k;
                    }
                }
                if(j == skill_trees[i].length() - 1) answer++;
            }
        }
        return answer;
    }
}