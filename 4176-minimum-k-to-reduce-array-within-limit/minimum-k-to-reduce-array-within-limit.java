class Solution {
    public int minimumK(int[] nums) {
        int left = 1;
        int right = 100000;
        while(left < right){
            int mid = left + (right-left) / 2;
            if(canReduce(nums, mid)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    private boolean canReduce(int[] nums, int k){
        long op = 0;
        for(int num : nums){
            op += (num + k - 1)/k;
            if(op > (long)k*k){
                return false;
            }
        }
        return true;
    }
}