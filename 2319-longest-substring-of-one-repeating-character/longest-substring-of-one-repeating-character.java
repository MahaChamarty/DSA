class Solution {
    int[] pref, suff, len, best;
    char[] left, right;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        pref = new int[4*n];
        suff = new int[4*n];
        best = new int[4*n];
        left = new char[4*n];
        right = new char[4*n];
        len = new int[4*n];
        build(1, 0, n-1, s);
        int ans[] = new int[queryIndices.length];
        for(int i = 0; i < queryIndices.length; i++){
            update(1, 0, n-1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = best[1];
        }
        return ans;
    }

    void build(int node, int l, int r, String str){
        if(l == r){
            left[node] = right[node] = str.charAt(l);
            pref[node] = suff[node] = best[node] = 1;
            len[node] = 1;
            return;
        }
        int mid = (l+r)/2;
        build(node*2, l, mid, str);
        build(node*2+1, mid+1, r, str);
        merge(node, node*2, node*2+1);
    }

    void update(int node, int l, int r, int ind, char ch){
        if(l == r){
            left[node] = right[node] = ch;
            pref[node] = suff[node] = best[node] = 1;
            len[node] = 1;
            return;
        }
        int mid = (l+r)/2;
        if(ind <= mid) update(node*2, l, mid, ind, ch);
        else update(node*2+1, mid+1, r, ind, ch);
        merge(node, node*2, node*2+1);
    }

    void merge(int node, int a, int b){
        left[node] = left[a];
        right[node] = right[b];
        pref[node] = pref[a];
        suff[node] = suff[b];
        best[node] = Math.max(best[a], best[b]);
        len[node] = len[a] + len[b];
        if(right[a] == left[b]){
            best[node] = Math.max(best[node], suff[a]+pref[b]);
            if(pref[a] == len[a]) pref[node] = len[a]+pref[b];
            if(suff[b] == len[b]) suff[node] = len[b]+suff[a];
        }
        else{
            best[node] = Math.max(best[a], best[b]);
        }
    }
}