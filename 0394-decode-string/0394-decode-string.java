class Solution {
    public String decodeString(String s) {
       Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // build number
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = current;
                current = stringStack.pop();
                int repeat = countStack.pop();
                for (int i = 0; i < repeat; i++) {
                    current.append(temp);
                }
            } else {
                current.append(ch);
            }
        }

        return current.toString(); 
    }
}