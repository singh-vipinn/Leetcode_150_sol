class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Convert arrays to sets to remove duplicates
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        
        // Find differences
        set1.removeAll(set2); // Elements in set1 but not in set2
        set2.removeAll(new HashSet<>(Arrays.asList(nums1))); // Elements in set2 but not in set1
        
        // Convert sets to lists
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(set1));
        result.add(new ArrayList<>(set2));
        
        return result;
    }
}