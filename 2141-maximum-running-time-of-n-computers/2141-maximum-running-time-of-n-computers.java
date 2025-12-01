class Solution {
    public long maxRunTime(int n, int[] batteries) {
        // Calculate the total sum of all battery charges
        long total = 0; // total charge
        for (int b : batteries) {
            total += b; // add each battery's charge to total
        }
        long left = 1, right = total / n; // binary search range
        long answer = 0; // store the result
        while (left <= right) { // binary search loop
            long mid = left + (right - left) / 2; // middle value
            long curr = 0; // current total charge usable for mid minutes
            for (int b : batteries) {
                curr += Math.min(b, mid); // add min(battery, mid) for each battery
            }
            if (curr >= n * mid) { // can we run all computers for mid minutes?
                answer = mid; // update answer
                left = mid + 1; // try for a higher value
            } else {
                right = mid - 1; // try for a lower value
            }
        }
        return answer; // return the maximum running time
    }
}