class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n+1];
        for(int i = n-1; i >= 0; i--){
            suffix[i] = suffix[i+1] + piles[i];
        }
        int[][] dp = new int[n][n+1];
        return solve(0, n, 1, piles, suffix, dp);
    }

    private int solve(int i, int n, int m, int[] piles, int[] suffix, int[][] dp){
        if(i >= n) return 0;
        if(2*m >= n-i) return suffix[i];
        if(dp[i][m] != 0) return dp[i][m];
        int best = 0;
        for(int j = 1; j <= 2*m && i+j <= n; j++){
            int temp = solve(i+j, n, Math.max(m, j), piles,suffix, dp);
            best = Math.max(best, suffix[i]-temp);
        }
        dp[i][m] = best;
        return best;
    }
}