class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int[] ans = new int[n+1];
        int j = m-1;
        for(int i = n-1; i >= 0; i--){
            ans[i] = ans[i+1];
            if(j >= 0 && a[i] == b[j]){
                ans[i]++;
                j--;
            }
        }

        int[] res = new int[m];
        int i = 0;
        j = 0;
        while(i < n && j < m){
            if(a[i] == b[j]){
                res[j] = i;
                j++;
            }
            else if(ans[i+1] >= m-j-1){
                res[j] = i;
                j++;
                i++;
                break;
            }
            i++;
        }

        if(j < m && i == n){
            return new int[0];
        }
        while(i < n && j < m){
            if(a[i] == b[j]){
                res[j] = i;
                j++;
            }
            i++;
        }

        if(j < m){
            return new int[0];
        }
        return res;
    }
}