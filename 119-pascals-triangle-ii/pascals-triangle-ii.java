class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new ArrayList<>();
        long val = 1;
        for(int i = 0; i <= rowIndex; i++){
            r.add((int)val);
            val = val *(rowIndex - i)/(i+1);
        }
        return r;
    }
}