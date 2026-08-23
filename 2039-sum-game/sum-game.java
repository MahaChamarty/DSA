class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int ls = 0, rs = 0;
        int lq = 0, rq = 0;
        for(int i = 0; i < n/2; i++){
            char c = num.charAt(i);
            if(c == '?') lq++;
            else ls += c-'0';
        }
        for(int i = n/2; i < n; i++){
            char c = num.charAt(i);
            if(c == '?') rq++;
            else rs += c-'0';
        }
        int diff = ls-rs;
        int qdiff = lq-rq;
        if(((lq + rq) & 1) == 1) return true;
        return diff != -qdiff/2*9;
    }
}