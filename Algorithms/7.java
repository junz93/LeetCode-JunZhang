/**
 * 7. Reverse Integer
 * Reverse digits of an integer.
 */

public class Solution {
    public int reverse(int x) {
        boolean pos = true;
        if(x < 0)
        {
            pos = false;
            x = -x;
        }
        int n_old = x, n_new = 0;
        int INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
        int bmax = INT_MAX/10, bmin = INT_MIN/10;
        while(n_old > 0)
        {
            int base = n_new*10;
            int add = n_old%10;
            if(pos)
            {
                if(n_new > bmax || base > INT_MAX-add)
                return 0;
            }
            else
            {
                if(-n_new < bmin || -base < INT_MIN+add)
                return 0;
            }
            n_new = base + add;
            n_old /= 10;
        }
        return pos ? n_new : -n_new;
    }
}
