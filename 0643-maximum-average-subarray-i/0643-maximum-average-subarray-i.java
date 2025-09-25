class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: sum of first k elements
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        double maxSum = windowSum;
        
        // Step 2: slide the window
        for (int i = k; i < n; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        // Step 3: return average
        return maxSum / k;
        
    }
}