class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1); // Default value for dry days

        HashMap<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i); // Store available dry day
            } else {
                ans[i] = -1; // Rain day
                
                if (fullLakes.containsKey(lake)) {
                    // Find a dry day after last rain of this lake
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) {
                        return new int[0]; // No valid dry day → flood
                    }
                    ans[dryDay] = lake; // Dry this lake on chosen dry day
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i); // Update last rain day
            }
        }

        return ans;

    }
}