class Solution {
    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        backtracking(result, "", 0, 0, n);
        return result;
    }

    void backtracking(List<String> result, String parenthesis, int openCount, int closeCount, int n) {
        if (openCount == n && closeCount == n) {
            result.add(parenthesis);
            return;
        }

        if (openCount < n) {
            backtracking(result, parenthesis + "(", openCount + 1, closeCount, n);
        }

        if (closeCount < openCount) {
            backtracking(result, parenthesis + ")", openCount, closeCount + 1, n);
        }
    }
}

