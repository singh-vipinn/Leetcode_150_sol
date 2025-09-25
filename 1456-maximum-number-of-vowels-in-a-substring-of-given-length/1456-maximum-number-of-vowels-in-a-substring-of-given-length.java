class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0, maxCount = 0;
        
        // Helper lambda to check vowels
        java.util.function.Predicate<Character> isVowel = 
            c -> "aeiou".indexOf(c) != -1;
        
        // Step 1: count vowels in first window
        for (int i = 0; i < k; i++) {
            if (isVowel.test(s.charAt(i))) {
                count++;
            }
        }
        maxCount = count;
        
        // Step 2: slide the window
        for (int i = k; i < n; i++) {
            if (isVowel.test(s.charAt(i - k))) count--; // char leaving
            if (isVowel.test(s.charAt(i))) count++;     // char entering
            maxCount = Math.max(maxCount, count);
            
            // optimization: early exit if maxCount == k
            if (maxCount == k) return k;
        }
        
        return maxCount;
    }
}