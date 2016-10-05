/**
 * 8. String to Integer (atoi)
 * Implement atoi to convert a string to an integer.
 *
 * Requirements for atoi: 
 * The function first discards as many whitespace characters as necessary 
 * until the first non-whitespace character is found. Then, starting from this character, 
 * takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
 * and interprets them as a numerical value. 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, 
 * no conversion is performed, and a zero value is returned. 
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

public class Solution {
    public int myAtoi(String str) {
        int num = 0;
        // str = str.trim();
        int N = str.length();
        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
        boolean neg = false;          // indicate whether the integer is positive or negative
        boolean start = false;        // indicate whether the first sign or digit is encountered
        for(int i = 0; i < N; i++)
        {
            char c = str.charAt(i);
            if(!start && c <= '\u0020')       // pass the whitespace
                continue;
            else if(!start && (c == '-' || c == '+'))   // positive/negative sign
            {
                start = true;
                neg = (c=='-') ? true: false;
            }
            else if(c >= '0' && c <= '9')       // numerical digit
            {
                start = true;
                if(!neg)
                {
                    if(num>MAX/10 || num*10>MAX-(c-'0'))
                        return MAX;
                }
                else
                {
                    if(-num<MIN/10 || -num*10<MIN+(c-'0'))
                        return MIN;
                }
                num = num*10 + c - '0';
            }
            else        // all the other characters, or all characters except digits after start
            {
                break;
            }
        }
        return neg ? -num: num;
    }
}
