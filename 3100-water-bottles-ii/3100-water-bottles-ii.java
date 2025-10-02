class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        long drunk = 0;
        long full = numBottles;
        long empties = 0;

        while(full > 0) {

            drunk += full;
            empties += full;
            full = 0;

            while(empties >= numExchange) {

                empties -= numExchange;
                full +=1;
                numExchange++;
            }
        }
        return (int) drunk;
    }
}