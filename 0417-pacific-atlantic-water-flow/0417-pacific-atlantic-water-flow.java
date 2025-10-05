class Solution {
    int rows, cols;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(heights == null || heights.length == 0) return result;

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        //pacific -> to row & left column
        for(int i=0; i<rows; i++) dfs(heights, pacific, i, 0);
        for(int j=0; j<cols; j++) dfs(heights, pacific, 0, j);

        //Atlantic -> bottom row & right column
        for(int i=0; i<rows; i++) dfs(heights, atlantic, i, cols-1);
        for(int j=0; j<rows; j++) dfs(heights, atlantic, rows-1, j);

        //Intersection
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c){
        visited[r][c] = true;

        for(int[] dir: directions) {
            int nr = r +dir[0];
            int nc = c +dir[1];
            if(nr<0 || nc <0 || nr >= rows || nc >= cols || visited[nr][nc])
                continue;
            if(heights[nr][nc] >= heights[r][c]) {
                dfs(heights, visited, nr, nc);
            }
        }
    }
}