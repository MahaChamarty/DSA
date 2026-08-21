class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long l = 1, h = (long)1e18;
        while(l < h){
            long mid = l+(h-l) / 2;
            if(count(mid, coins) >= k) h = mid;
            else l = mid+1;
        }
        return l;
    }

    private long count(long x, int coins[]){
        int n = coins.length;
        long ans = 0;
        for(int i = 1; i < (1 << n); i++){
            long lcm = 1;
            boolean valid = true;
            int bits = 0;
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    bits++;
                    lcm = lcm(lcm, coins[j]);
                    if(lcm > x){
                        valid = false;
                        break;
                    }
                }
            }
            if(!valid) continue;
            if(bits % 2 == 1) ans += x / lcm;
            else ans -= x / lcm;
        }
        return ans;
    }

    private long gcd(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b){
        return a / gcd(a, b)*b;
    }
}