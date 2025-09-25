class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        // Fill initial queues
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') rQueue.offer(i);
            else dQueue.offer(i);
        }

        // Simulate rounds
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();

            if (rIndex < dIndex) {
                // R acts first, D banned
                rQueue.offer(rIndex + n);
            } else {
                // D acts first, R banned
                dQueue.offer(dIndex + n);
            }
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}