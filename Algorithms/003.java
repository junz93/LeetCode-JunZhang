/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 */

public class Solution {
    public static int lengthOfLongestSubstring(String s)
    {
        if(s.length() == 0)
            return 0;
        int max = 1;
        int N = s.length();
        int i = 0, j = 0;
        while(i < N && j < N)
        {
            for(int k = i; k < j; k++)
                if(s.charAt(j) == s.charAt(k))
                {
                    i = k + 1;
                    break;
                }
            if(j-i+1 > max)
                max = j-i+1;
            j++;
        }
        int a[] = new int[5];
        return max;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(lengthOfLongestSubstring(s));
    }
}
