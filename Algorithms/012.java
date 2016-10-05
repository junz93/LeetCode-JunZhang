/**
 * 12. Integer to Roman
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * Symbol: 1(I) 5(V) 10(X) 50(L) 100(C) 500(D) 1000(M)
 * Rules: I II III (1 2 3)
 *        IV V VI VII VIII (4 5 6 7 8)
 *        IX (9)
 *        (10 20 30)
 *        (40 50 60
 */

public class Solution {
    // A very simple version:
    public String intToRoman(int num) {
        String[] s3 = {"", "M", "MM", "MMM"};
        String[] s2 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] s1 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] s0 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        return s3[num/1000] + s2[(num%1000)/100] + s1[(num%100)/10] + s0[num%10];
    }
    
    // More general version:
    public String intToRoman_2(int num) {
        StringBuilder sb = new StringBuilder();
        char[] rom = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int i = 0;
        for(int t = num; t >= 10; i++)
            t /= 10;
        int div = (int)Math.pow(10, i);
        while(i>=0)
        {
            int digit = num / div;
            if(i < 3)
            {
                if(digit < 4)
                {
                    for(int k = 0; k < digit; k++)
                        sb.append(rom[i*2]);
                }
                else if(digit == 4)
                {
                    sb.append(rom[i*2]);
                    sb.append(rom[i*2+1]);
                }
                else if(digit == 9)
                {
                    sb.append(rom[i*2]);
                    sb.append(rom[i*2+2]);
                }
                else
                {
                    sb.append(rom[i*2+1]);
                    for(int k = 0; k < digit-5; k++)
                        sb.append(rom[i*2]);
                }
            }
            else
            {
                for(int k = 0; k < digit; k++)
                    sb.append('M');
            }
            
            num %= div;
            div /= 10;
            i--;
        }
        return sb.toString();
}
