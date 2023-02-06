class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long big, small;
        
        if(w > h) {
            big = w; small = h; 
        } else {
            big = h; small = w; 
        }
        
        long n = gcd(big, small);
        
        answer = (big * small) - (big + small - n);
        
        return answer;
    }
    
    private long gcd(long a, long b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}