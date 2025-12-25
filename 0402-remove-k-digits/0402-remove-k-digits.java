class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(char digit: num.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            } 
            stack.push(digit);
        }

        while(k >0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }
        String result = sb.substring(idx);
        return result.isEmpty() ? "0" : result;
    }
}