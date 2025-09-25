class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        // Step 2: Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }

        // Step 3: Remove the last extra space and return
        return result.toString().trim();
    }
}