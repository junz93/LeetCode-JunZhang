/**
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int N = nums.length;
        for(int i = 0; i < N; i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int j = i+1, k = N-1;
            while(j < k)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                {
                    j++;
                    continue;
                }
                if(k<N-1 && nums[k]==nums[k+1])
                {
                    k--;
                    continue;
                }
                
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0)
                    j++;
                else if(sum > 0)
                    k--;
                else
                {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[j++]);
                    lst.add(nums[k--]);
                    result.add(lst);
                }
            }
        }
        return result;
    }
}
