class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0; // position to write result
        int i = 0;     // read pointer

        while (i < n) {
            char current = chars[i];
            int count = 0;

            // count consecutive chars
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            // write the character
            chars[write++] = current;

            // write the count if > 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // new length
        
    }
}