class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>(); // adjacency list for each course
        // Create in-degree array to count prerequisites for each course
        int[] inDegree = new int[numCourses]; // in-degree for each course
        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>()); // add empty list for each course
        }
        // Build the graph and fill in-degree array
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); // add edge from pre[1] to pre[0]
            inDegree[pre[0]]++; // increment in-degree for pre[0]
        }
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>(); // queue for courses with in-degree 0
        // Add all courses with in-degree 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i); // if in-degree is 0, add to queue
        }
        // List to store the course order
        int[] order = new int[numCourses]; // array to store the result order
        int idx = 0; // index for order array
        // Process the queue
        while (!queue.isEmpty()) {
            int curr = queue.poll(); // get course from queue
            order[idx++] = curr; // add course to order
            for (int neighbor : adj.get(curr)) { // for each neighbor
                inDegree[neighbor]--; // reduce in-degree
                if (inDegree[neighbor] == 0) queue.offer(neighbor); // if in-degree is 0, add to queue
            }
        }
        // If all courses are processed, return order; else, return empty array
        if (idx == numCourses) return order; // if all courses are in order, return it
        return new int[0]; // else, return empty array
    }
}