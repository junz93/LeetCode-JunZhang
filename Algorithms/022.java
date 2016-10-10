/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generateParenthesis(res, "", n, n);
        return res;
    }
    
    private void generateParenthesis(List<String> res, String com, int n_left, int n_right)
    {
        if(n_left==0 && n_right==0)
        {
            res.add(com);
            return;
        }
        if(n_left > 0)
            generateParenthesis(res, com+"(", n_left-1, n_right);
        if(n_right > n_left)
            generateParenthesis(res, com+")", n_left, n_right-1);
    }
}
