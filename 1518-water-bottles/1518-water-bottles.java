class Solution {
    public int numWaterBottles(int numBottles, int numExchanges){
        int ans = numBottles;

        while(numBottles>=numExchanges){
            int newBottles=numBottles/numExchanges;
            int remBottles=numBottles%numExchanges;
            ans = ans+newBottles;

            numBottles=newBottles+remBottles;
        }
        return ans;
    }
}