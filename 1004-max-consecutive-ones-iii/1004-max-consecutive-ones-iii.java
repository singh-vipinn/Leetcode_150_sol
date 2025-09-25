class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            // shrink window if zeroCount exceeds k
            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            // update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}