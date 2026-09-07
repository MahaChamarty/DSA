class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        long ew[] = new long[26];
        for(int i = 0; i <s.length(); i++){
            int charidx = s.charAt(i) - 'a';
            long cs = 1;
            for(int j = 0; j < 26; j++){
                cs = (cs + ew[j]) % mod;
            }
            ew[charidx] = cs;
        }
        long tot = 0;
        for(int j = 0; j < 26; j++){
            tot = (tot + ew[j]) % mod;
        }
        return (int)tot;
    }
}