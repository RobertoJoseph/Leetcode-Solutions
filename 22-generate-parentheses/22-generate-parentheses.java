class Solution {
    
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        backtrackBrackets(ans, result, 0, 0, n);
        return ans;

    }

    public void backtrackBrackets(ArrayList<String> ans, StringBuilder result,
                                  int open, int close,
                                  int max) {
        if (result.length() == max * 2) {
            ans.add(result.toString());
            return;
        }
        if (open < max) {
            result.append("(");
            backtrackBrackets(ans, result, open + 1, close, max);
            result.deleteCharAt(result.length() - 1);
        }
        if (close < open) {
            result.append(")");
            backtrackBrackets(ans, result, open, close + 1, max);
            result.deleteCharAt(result.length() - 1);


        }

    }
}