class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // min-heap : stores {maxElevationSoFar, x, y}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]- b[0]);
        pq.offer(new int[] {grid[0][0],0,0});

        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], x = curr[1], y= curr[2];

            if(visited[x][y]) continue;
            visited[x][y] = true;

            if(x==n-1 && y==n-1) return time; // Reached destination

            for(int[] dir : directions) {
                int nx = x+dir[0];
                int ny = y+dir[1];

                if(nx >= 0 && ny >= 0 && nx <n && ny <n && !visited[nx][ny]) {
                    pq.offer(new int[] {Math.max(time, grid[nx][ny]), nx, ny});
                }
            }
        }
        return -1;  // Unreachable
    }
}