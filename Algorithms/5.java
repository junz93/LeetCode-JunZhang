/**
 * 5. Longest Palindromic Substring
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

public class Solution {
    public String longestPalindrome(String s) {
        int begin = 0, end = 0;
        boolean odd = true;
        for(int i = 0; i < s.length();)
        {
            int l, r;
            if(odd)
            {
                l = i; r = i;
            }
            else
            {
                l = i; r = ++i;
            }
            
            while(l >= 0 && r < s.length())
            {
                if(s.charAt(l) != s.charAt(r))
                    break;
                l--; r++;
            }
            l++; r--;
            if(r-l > end-begin)
            {
                begin = l;
                end = r;
            }
            odd = !odd;
        }
        return s.substring(begin, end+1);
    }
    
    // private boolean isPalin(String s) {
    //     int N = s.length();
    //     int mid_left = N / 2 - 1;
    //     for(int i = 0; i <= mid_left; i++) {
    //         if(s.charAt(i) != s.charAt(N-1-i))
    //             return false;
    //     }
    //     return true;
    // }
}
