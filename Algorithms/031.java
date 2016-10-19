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
        if(i != 0)
        {
            int j;
            for(j = nums.length-1; j>=i && nums[j]<=nums[i-1]; j--) ;
            int temp = nums[i-1];
            nums[i-1] = nums[j];
            nums[j] = temp;
        }
        Arrays.sort(nums, i, nums.length);
    }
    
    // sort manually (O(n) running time) instead of using Arrays.sort(...)
    public void nextPermutation_2(int[] nums) {
        int i;
        for(i = nums.length-1; i>0 && nums[i]<=nums[i-1]; i--) ;
        if(i != 0)
        {
            int j;
            for(j = nums.length-1; j>=i && nums[j]<=nums[i-1]; j--) ;
            int temp = nums[i-1];
            nums[i-1] = nums[j];
            nums[j] = temp;
        }            
        // subarray nums[i .. N-1] is in reverse order
        // using two pointer (begin from both sides) is clearer and easier than the following mechanism
        for(int j = i; j < i+(nums.length-i)/2; j++)
        {
            int temp = nums[j];
            nums[j] = nums[nums.length-1+i-j];
            nums[nums.length-1+i-j] = temp;
        }
    }
}
