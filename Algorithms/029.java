/**
 * 29. Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */

public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        
        int quotient = 0;
        long d1 = dividend;
        long d2 = divisor;
        boolean pos = true;
        if(d1 < 0)
        {
            pos = !pos;
            d1 = -d1;
        }
        if(d2 < 0)
        {
            pos = !pos;
            d2 = -d2;
        }
        
        while(d1 >= d2)
        {
            long d2_t = d2;
            long i = 1;
            while(d1 >= d2_t)
            {
                d2_t = d2_t << 1;
                i = i << 1;
            }
            quotient += (i >> 1);
            d1 -= (d2_t >> 1);
        }
        
        return pos ? quotient : -quotient;
    }
}
