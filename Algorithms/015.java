/**
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums==null || nums.length<3)
            return res;
        int N = nums.length;
        Arrays.sort(nums);
        int max = nums[N-1];
        if(nums[0]*3>0 || max*3<0)
            return res;
        
        for(int i = 0; i < N; i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            if(nums[i]+2*max < 0)
                continue;
            if(3*nums[i]>0)
                continue;
            int lo = i+1, hi = N-1;
            while(lo < hi)
            {
                if(lo>i+1 && nums[lo]==nums[lo-1])
                {
                    lo++; continue;
                }
                if(hi<N-1 && nums[hi]==nums[hi+1])
                {
                    hi--; continue;
                }
                
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum < 0)
                    lo++;
                else if(sum > 0)
                    hi--;
                else
                {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++; hi--;
                }
            }
        }
        return res;
    }
}
