/**
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int N = len1 + len2;
        if(len2 == 0)
            return (nums1[(N-1)/2] + nums1[N/2]) / 2.0;
        // if(nums1[len1-1] <= nums2[0])
        //     if(len1 == len2)
        //         return (nums1[len1-1] + nums2[0]) / 2;
        //     else
        //         return (nums1[(N-1)/2] + nums1[N/2]) / 2;
        // if(nums2[len2-1] <= nums1[0])
        //     if(len1 == len2)
        //         return (nums2[len2-1] + nums1[0]) / 2;
        //     else
        //         return (nums1[(N-1)/2-len2] + nums1[N/2-len2]) / 2;
        
        int len = N / 2;
        int lo = 0, hi = len2;
        while(lo <= hi) {
            int c2 = (lo+hi) / 2;
            int c1 = len - c2;
            if(c1 > 0 && c2 < len2 && (nums1[c1-1] > nums2[c2]))
                lo = c2 + 1;
            else if(c1 < len1 && c2 > 0 && (nums2[c2-1] > nums1[c1]))
                hi = c2 - 1;
            else if(N % 2 == 0) {
                if(c2 == len2) {
                    if(c1 == 0)
                        return (nums2[c2-1] + nums1[0]) / 2.0;
                    else
                        return (Math.max(nums1[c1-1], nums2[c2-1]) + nums1[c1]) / 2.0;
                }
                else if(c2 == 0) {
                    if(c1 == len1)
                        return (nums1[c1-1] + nums2[0]) / 2.0;
                    else
                        return (nums1[c1-1] + Math.min(nums1[c1], nums2[0])) / 2.0;
                }
                else
                    return (Math.max(nums1[c1-1], nums2[c2-1]) + Math.min(nums1[c1], nums2[c2])) / 2.0;
            }
            else {
                if(c2 == len2)
                    return nums1[c1];
                return Math.min(nums1[c1], nums2[c2]);
            }
        }
        
        return -1;
    }
}
