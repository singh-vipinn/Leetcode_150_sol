class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, maxLen = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            // shrink window if more than 1 zero
            while (zeroCount > 1) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            // max length of window with at most 1 zero
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // we have to delete one element
        return maxLen - 1;
    }
}