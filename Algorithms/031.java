/**
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically 
 * next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest 
 * possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 */

public class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for(i = nums.length-1; i>0 && nums[i]<=nums[i-1]; i--) ;
        if(i == 0)
            Arrays.sort(nums);
        else
        {
            int k = i;
            for(int j = i; j < nums.length; j++)
                if(nums[j]>nums[i-1] && nums[j]<nums[k])
                    k = j;
            int temp = nums[i-1];
            nums[i-1] = nums[k];
            nums[k] = temp;
            Arrays.sort(nums, i, nums.length);
        }
    }
    
    public void nextPermutation(int[] nums) {
        int i;
        for(i = nums.length-1; i>0 && nums[i]<=nums[i-1]; i--) ;
        if(i == 0)
        {
            for(int j = 0; j < nums.length/2; j++)
            {
                int temp = nums[j];
                nums[j] = nums[nums.length-1-j];
                nums[nums.length-1-j] = temp;
            }
        }
        else
        {
            int k = i;
            for(int j = i; j < nums.length; j++)
                if(nums[j]>nums[i-1] && nums[j]<=nums[k])
                    k = j;
            int temp = nums[i-1];
            nums[i-1] = nums[k];
            nums[k] = temp;
            for(int j = i; j < i+(nums.length-i)/2; j++)
            {
                temp = nums[j];
                nums[j] = nums[nums.length-1+i-j];
                nums[nums.length-1+i-j] = temp;
            }
        }
    }
}
