class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();

        for (var token : tokens) {
            var expressionResult = switch (token) {
                case "+" -> sum(stack);
                case "-" -> subtract(stack);
                case "*" -> multiply(stack);
                case "/" -> division(stack);
                default -> Integer.parseInt(token);
            };
            stack.push(expressionResult);
        }

        return stack.pop();
    }

    int sum(Stack<Integer> stack) {
        var a = stack.pop();
        var b = stack.pop();
        return a + b;
    }

    int multiply(Stack<Integer> stack) {
        var a = stack.pop();
        var b = stack.pop();
        return a * b;
    }

    int subtract(Stack<Integer> stack) {
        var a = stack.pop();
        var b = stack.pop();
        return b - a;
    }

    int division(Stack<Integer> stack) {
        var a = stack.pop();
        var b = stack.pop();
        return b / a;
    }
}
