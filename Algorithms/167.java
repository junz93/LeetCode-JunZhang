public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0, j = numbers.length-1;
        int sum;
        while(i < j)
        {
            sum = numbers[i] + numbers[j];
            if(sum < target)
                i++;
            else if(sum > target)
                j--;
            else
            {
                result[0] = i+1;
                result[1] = j+1;
                break;
            }
        }
        return result;
    }
}
