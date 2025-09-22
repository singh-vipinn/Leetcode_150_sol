class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            // If end of array or current number is not consecutive
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start)); // single number
                } else {
                    result.add(start + "->" + nums[i - 1]); // range
                }
                if (i < nums.length) start = nums[i]; // new range start
            }
        }

        return result;
    }
}