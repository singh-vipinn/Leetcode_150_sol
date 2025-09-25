class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        
        StringBuilder result = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }
}