/**
 * 16. 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // if(nums.length <= 3)
        // {
        //     int sum = 0;
        //     for(int i = 0; i < nums.length; i++)
        //         sum += nums[i];
        //     return sum;
        // }
        
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length-2; i++)
        {
            int j = i+1, k = nums.length-1;
            while(j < k)
            {
                int t_sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(t_sum - target) < Math.abs(sum - target))
                    sum = t_sum;

                if(t_sum < target)
                    j++;
                else if(t_sum > target)
                    k--;
                else
                    return target;
            }
        }
        
        return sum;
    }
}
