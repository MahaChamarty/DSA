class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int zc = 0;
        for(int val : nums){
            xor ^= val;
            if(val == 0) zc++;
        }
        if(xor != 0) return nums.length;
        if(zc == nums.length) return 0;
        return nums.length-1;
    }
}