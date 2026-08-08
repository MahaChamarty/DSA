class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = 0;
        for(int bit = 0; bit <= 30; bit++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                if((num & (1 << bit)) != 0){
                    list.add(num);
                }
            }
            ans = Math.max(ans, lis(list));
        }
        return ans;
    }

    private int lis(ArrayList<Integer> list){
        ArrayList<Integer> dp = new ArrayList<>();
        for(int num : list){
            int left = 0;
            int right = dp.size();
            while(left < right){
                int mid = left + (right-left)/2;
                if(dp.get(mid) >= num){
                    right = mid;
                }
                else{
                    left = mid+1;
                }
            }
            if(left == dp.size()){
                dp.add(num);
            }
            else{
                dp.set(left, num);
            }
        }
        return dp.size();
    }
}