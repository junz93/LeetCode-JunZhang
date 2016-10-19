/**
 * 338. Counting Bits
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num 
 * calculate the number of 1's in their binary representation and return them as an array.
 */

public class Solution {
    public int[] countBits(int num) {
        int[] c = new int[num+1];
        for(int i = 0; i <= num; i++)
        {
            int count = 0;
            int n = i;
            while(n > 0)
            {
                count += n & 1;
                n = n >> 1;
            }
            c[i] = count;
        }
        return c;
    }
}
