class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long totalHappiness = 0;
        int n = happiness.length;
        int decrease = 0;


        for(int i=n-1; i>=n-k; i--) {
            int current = happiness[i] - decrease;

            if(current > 0) {
                totalHappiness += current;
            }

            decrease++;
        }
        return totalHappiness;
    }
}