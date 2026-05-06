class Solution {
    public boolean isValid(String s) {
        var brackets = Map.of('{', '}', '(', ')', '[', ']');
        var openBrackets = brackets.keySet();
        var stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (openBrackets.contains(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && brackets.get(stack.peek()).equals(c)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
