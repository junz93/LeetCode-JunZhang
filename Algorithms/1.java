/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 */
 
public class Solution {
    public static int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
            ht.put(nums[i], i);
        for(int i = 0; i < nums.length; i++)
        {
            if(ht.containsKey(target - nums[i]))
            {
                int j = ht.get(target - nums[i]);
                if(j != i)
                {
                    result[0] = i;
                    result[1] = ht.get(target - nums[i]);
                    break;
                }
            }
        }
        return result;
    }
}
