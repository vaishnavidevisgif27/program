public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0, right = m;
        while (left <= right) {
            int i = left + (right - left) / 2; 
            int j = (m + n + 1) / 2 - i; 

            
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) 
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                
                right = i - 1;
            } else {
            
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + solution.findMedianSortedArrays(nums1, nums2)); 

        int[] nums1b = {1, 2};
        int[] nums2b = {3, 4};
        System.out.println("Median: " + solution.findMedianSortedArrays(nums1b, nums2b)); 
    }
}