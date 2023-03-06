class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 1;
        for(int i = 0; i < stations.length; i++) {
            if(stations[i] - w > idx) answer += 1 + (stations[i] - w - idx - 1) / (2 * w + 1) ;
            idx = stations[i] + w + 1; 
        }
        if(idx <= n) answer += 1 + (n - idx) / (2 * w + 1);
        return answer;
    }
}