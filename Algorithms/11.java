/**
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: there is not a lid of the container.
 */

public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1, max = 0;
        while(i < j)
        {
            int t_max;
            if(height[i] < height[j])
                t_max = (j-i) * height[i++];
            else
                t_max = (j-i) * height[j--];
            if(t_max > max)
                max = t_max;
        }
        
        return max;
    }
}
