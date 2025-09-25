class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count occurrences
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Check uniqueness of counts
        Set<Integer> counts = new HashSet<>();
        for (int freq : countMap.values()) {
            if (!counts.add(freq)) { // add returns false if already exists
                return false;
            }
        }
        
        return true;
    }
}