class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Create adjaency list
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph and indegree
        for(int[] p: prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        //add all coures with no prerequisites
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            completed++;

            for(int next : graph.get(curr)) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return completed == numCourses;
    }
}