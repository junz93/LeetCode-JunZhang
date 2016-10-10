/**
 * 18. 4Sum
 * Given an array S of n integers and a target, 
 * find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 */

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums==null || nums.length<4)
            return res;
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        if(nums[0]*4>target || max*4<target)
            return res;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i>0 && nums[i] == nums[i-1])
                continue;
            if(nums[i]+3*max < target)
                continue;
            if(4*nums[i] > target)
                continue;
            for(int j = i+1; j < nums.length; j++)
            {
                if(j>i+1 && nums[j] == nums[j-1])
                    continue;
                int lo = j+1, hi = nums.length-1;
                while(lo < hi)
                {
                    if(lo>j+1 && nums[lo]==nums[lo-1])
                    {
                        lo++; continue;
                    }
                    if(hi<nums.length-1 && nums[hi]==nums[hi+1])
                    {
                        hi--; continue;
                    }
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if(sum < target)
                        lo++;
                    else if(sum > target)
                        hi--;
                    else
                    {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        lo++; hi--;
                    }
                }
            }
        }
        return res;
    }
}
