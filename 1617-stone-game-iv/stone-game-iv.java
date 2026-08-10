class Solution {
    public boolean winnerSquareGame(int n) {
        boolean ans[] = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            for(int j = 1; j*j <= i; j++){
                if(!ans[i-j*j]){
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[n];
    }
}