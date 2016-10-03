public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] rom = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int i = 0;
        // for(int t = num; t/10 > 0; i*=10);
        
        while(num > 0)
        {
            int digit = num % 10;
            if(i < 3)
            {
                if(digit < 4)
                {
                    for(int k = 0; k < digit; k++)
                        sb.append(rom[i*2]);
                }
                else if(digit == 4)
                {
                    sb.append(rom[i*2+1]);
                    sb.append(rom[i*2]);
                }
                else if(digit == 9)
                {
                    sb.append(rom[i*2+2]);
                    sb.append(rom[i*2]);
                }
                else
                {
                    for(int k = 0; k < digit-5; k++)
                        sb.append(rom[i*2]);
                    sb.append(rom[i*2+1]);
                }
            }
            else
            {
                for(int k = 0; k < digit; k++)
                    sb.append('M');
            }
            
            num /= 10;
            i++;
        }
        return sb.reverse().toString();
    }
}
