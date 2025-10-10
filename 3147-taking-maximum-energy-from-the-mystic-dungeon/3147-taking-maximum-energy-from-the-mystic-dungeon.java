class Solution {
    public int maximumEnergy(int[] energy, int k) {
         int n = energy.length;
        // Use a very small initial value, since energies can be negative
        int ans = -(1 << 30);
        // For each possible endpoint in the last k positions
        for (int i = n - k; i < n; i++) {
            int s = 0;
            // Traverse backwards in this chain by steps of k
            for (int j = i; j >= 0; j -= k) {
                s += energy[j];
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }
}