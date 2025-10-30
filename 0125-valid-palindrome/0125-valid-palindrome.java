class Solution {
    public boolean isPalindrome(String s) {
    
         // Convert the string to lowercase
        s = s.toLowerCase();
        
        // Remove all non-alphanumeric characters
        s = s.replaceAll("[^a-z0-9]", "");
        
        int n = s.length();
        
        // Check characters from both ends
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        
        return true;
    }
}