class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int mini = 0, maxi = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[mini]){
                mini = i;
            }
            if(nums[i] > nums[maxi]){
                maxi = i;
            }
        }
        int rff = Math.max(mini, maxi) + 1;
        int rfb = n - Math.min(mini, maxi);
        int rfbs = Math.min(mini + 1 + (n - maxi), maxi + 1 + (n - mini));
        return Math.min(rff, Math.min(rfb, rfbs));
    }
}