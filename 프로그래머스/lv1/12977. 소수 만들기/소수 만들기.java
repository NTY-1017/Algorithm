
import java.util.*;

class Solution {
    private boolean[] check = new boolean[3000];
    private int count = 0;
    public int solution(int[] nums) {
        for(int i = 2; i < Math.sqrt(3000); i++) {
            if(!check[i]) {
                for(int j = i * i; j < 3000; j = j + i) check[j] = true;
            }
        }
        f(0, 0, 3, nums);
        return count;
    }
    
    private void f(int sum, int start, int depth, int[] nums) {
        if(depth == 0) {
            if(!check[sum]) count++;
        } else {
            for(int i = start; i <= nums.length - depth; i++) {
                if(nums[i] > 0) {
                    int temp = nums[i];
                    nums[i] = 0;
                    f(sum + temp, i + 1, depth - 1, nums);
                    nums[i] = temp;
                }
            }
        }
    }
}