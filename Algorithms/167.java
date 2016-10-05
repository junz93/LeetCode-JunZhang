/**
 * 167. Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target.
 * Note: your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 */

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
