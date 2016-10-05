/**
 * 10. Regular Expression Matching
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }
    
    private boolean isMatch(String s, String p, int i, int j)
    {
        if(j < p.length() && i < s.length())
        {
            if(p.charAt(j) == '.')
            {
                if(j!=p.length()-1 && p.charAt(j+1)=='*')
                {
                    for(int k = i; k <= s.length(); k++)
                        if(isMatch(s, p, k, j+2))
                            return true;
                    return false;
                }
                else
                    return isMatch(s, p, i+1, j+1);
            }
            else
            {
                if(j!=p.length()-1 && p.charAt(j+1)=='*')
                {
                    for(int k = i; k <= s.length(); k++)
                    {
                        if(isMatch(s, p, k, j+2))
                            return true;
                        if(k<s.length() && s.charAt(k)!=p.charAt(j))
                            return false;
                    }
                    return false;
                }
                else if(s.charAt(i) == p.charAt(j))
                    return isMatch(s, p, i+1, j+1);
                else
                    return false;
            }
        }
        else if(j == p.length())
        {
            if(i == s.length())
                return true;

            else
                return false;
        }
        if(j!=p.length()-1 && p.charAt(j+1)=='*')
            return isMatch(s, p, i, j+2);
        return false;
    }
}
