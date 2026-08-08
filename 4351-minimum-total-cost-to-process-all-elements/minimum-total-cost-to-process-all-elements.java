class Solution {
    public int minimumCost(int[] nums, int k) {
        final long mod = 1000000007L;
        long cur = k;
        long cnt = 0;
        for(int x : nums){
            long diff = x-cur;
            if(diff > 0){
                long times = (diff + k -1L)/k;
                cur += times*k;
                cnt += times;
            }
            cur -= x;
        }
        cnt %= mod;
        return (int)(((cnt+1) * cnt/2) % mod);
    }
}