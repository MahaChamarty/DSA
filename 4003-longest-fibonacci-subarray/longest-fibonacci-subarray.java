class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int cur = 2, ans = 2;
        for(int i = 2; i < n; i++){
            if((long)nums[i] == (long)nums[i-1]+nums[i-2]){
                cur++;
            }
            else{
                cur = 2;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}