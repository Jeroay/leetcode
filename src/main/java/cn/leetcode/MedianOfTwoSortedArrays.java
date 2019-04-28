package cn.leetcode;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example :
 * nums1 = [1, 3]    nums2 = [2]    The median is 2.0
 * nums1 = [1, 2]    nums2 = [3, 4]    The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[nums1.length + i] = nums2[i];
        }
        Arrays.sort(nums);
        int length = nums.length;
        if (length % 2 == 0) {
            return (double) (nums[length / 2] + nums[length / 2 - 1]) / 2;
        } else {
            return nums[(int) length / 2];
        }
    }
}
