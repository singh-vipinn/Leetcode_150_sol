class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // Directions for 8 neighbors
        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int[] d : dirs) {
                    int r = i + d[0], c = j + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && Math.abs(board[r][c]) == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply rules
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; // live -> dead
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2;  // dead -> live
                }
            }
        }

        // Final pass: normalize the values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}