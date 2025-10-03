class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));

        // Step 1: Add all boundary cells into the min-heap
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int waterTrapped = 0;
        int maxBoundary = Integer.MIN_VALUE;

        // Step 2: Process cells in the min-heap
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            maxBoundary = Math.max(maxBoundary, cell.height);

            // Step 3: Check all 4 neighbors
            for (int[] dir : directions) {
                int newRow = cell.row + dir[0];
                int newCol = cell.col + dir[1];

                // Check boundaries and visited
                if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }

                visited[newRow][newCol] = true;
                int neighborHeight = heightMap[newRow][newCol];

                // If neighbor is lower, water can be trapped
                if (neighborHeight < maxBoundary) {
                    waterTrapped += maxBoundary - neighborHeight;
                }

                // Push the neighbor (with its actual height) into the heap
                minHeap.offer(new Cell(newRow, newCol, neighborHeight));
            }
        }

        return waterTrapped;
    }

    static class Cell {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
        
    }
