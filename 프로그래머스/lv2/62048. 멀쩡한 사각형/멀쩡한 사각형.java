class Solution {
    public long solution(int w, int h) {
        long big, small, n;
        
        if(w > h) {
            big = w; small = h; 
        } else {
            big = h; small = w; 
        }
        n = gcd(big, small);
        
        return (big * small) - (big + small - n);
    }
    
    private long gcd(long a, long b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}