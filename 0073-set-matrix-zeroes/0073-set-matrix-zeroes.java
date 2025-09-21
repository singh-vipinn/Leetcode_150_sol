class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        // Check first row
        for(int j=0; j<cols; j++) {
            if(matrix[0][j]==0) firstRow = true;
        }

        //Check first col
        for(int i=0; i<rows; i++) {
            if(matrix[i][0]==0) firstCol = true;
        }
        //Use first row/col as marker
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] =0;
                    matrix[0][j] =0;
                }
            }
        }
        //fill cells
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                if(matrix[i][0] ==0 ||  matrix[0][j] ==0) {
                    matrix[i][j] =0;
                }
            }
        }
        //Handle first rows
        if(firstRow) {
            for(int j=0; j<cols; j++) matrix[0][j] = 0;

        }
        if(firstCol) {
            for(int i=0; i<rows; i++) matrix[i][0] = 0;
        }
    }
}