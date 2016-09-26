public class Solution {
    public String longestPalindrome(String s) {
        String lps = "";
        for(int i = 0; i < s.length(); i++)
        {
            int l = i, r = i;
            while(l >= 0 && r < s.length())
            {
                if(s.charAt(l) != s.charAt(r))
                    break;
                l--; r++;
            }
            l++; r--;
            if(r-l+1 > lps.length())
                lps = s.substring(l, r+1);
            
            if(i!=s.length()-1 && s.charAt(i)==s.charAt(i+1))
            {
                l = i;
                r = i+1;
                while(l >= 0 && r < s.length())
                {
                    if(s.charAt(l) != s.charAt(r))
                        break;
                    l--; r++;
                }
                l++; r--;
                if(r-l+1 > lps.length())
                    lps = s.substring(l, r+1);                
            }
        }
        return lps;
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
