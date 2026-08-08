class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] Gcd = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            Gcd[i]  =gcd(nums[i], max);
        }
        Arrays.sort(Gcd);
        long ans = 0;
        for(int i = 0; i < n/2; i++){
            ans += gcd(Gcd[i], Gcd[n-i-1]);
        }
        return ans;
    }

    private int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}