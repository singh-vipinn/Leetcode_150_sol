class Solution {
    public int equalPairs(int[][] grid) {
    
        int n = grid.length;
        int count = 0;

        // Iterate through each row
        for (int i = 0; i < n; i++) {
            // Iterate through each column
            for (int j = 0; j < n; j++) {
                boolean isEqual = true;

                // Compare row[i] with column[j]
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    count++;
                }
            }
        }

        return count;
    }
}
