class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        int pro = k;
        while(hs.contains(pro)){
            pro += k;
        }
        return pro;
    }
}