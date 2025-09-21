class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Step 1: Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        // Step 2: Deque to store indices
        Deque<Integer> deque = new ArrayDeque<>();
        int result = n + 1;
        
        for (int j = 0; j <= n; j++) {
            // While valid subarray exists
            while (!deque.isEmpty() && prefix[j] - prefix[deque.peekFirst()] >= k) {
                result = Math.min(result, j - deque.pollFirst());
            }
            
            // Maintain increasing order of prefix sums
            while (!deque.isEmpty() && prefix[j] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            
            deque.addLast(j);
        }
        
        return result <= n ? result : -1;
    }
}