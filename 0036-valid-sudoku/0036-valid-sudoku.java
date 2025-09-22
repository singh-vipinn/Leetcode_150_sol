class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;

                // Encode uniqueness checks
                String rowKey = val + " in row " + r;
                String colKey = val + " in col " + c;
                String boxKey = val + " in box " + (r / 3) + "-" + (c / 3);

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false; // Duplicate found
                }
            }
        }

        return true;
    }
}