class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int r1 = 0;
        int c1 = c-1;
        while(r1 < r && c1 >= 0){
            if(matrix[r1][c1] == target){
                return true;
            }
            if(matrix[r1][c1] > target){
                c1--;
            }
            else{
                r1++;
            }
        }
        return false;
    }
}