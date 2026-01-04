class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for(int n : nums) {
            int sum = getFourDivisorSum(n);
            totalSum += sum;
        }

        return totalSum;
    }

    private int getFourDivisorSum(int n) {
        for(int i=2; i*i<= n; i++) {
            if(n%i == 0) {
                int j= n/i;

                if(i==j) return 0;

                if(isPrime(i) && isPrime(j)) {
                    return 1+i+j+n;
                } else {
                    return 0;
                }
            }
        }
        return 0;
    }

    private boolean isPrime(int x) {
        if(x < 2) return false;

        for(int i=2; i*i<=x; i++) {
            if(x%i == 0) return false;
        }
        return  true;
    }
}