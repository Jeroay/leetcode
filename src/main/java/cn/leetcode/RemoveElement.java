package cn.leetcode;

import java.util.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 5, 3};
        int val = 3;
        int length = new RemoveElement().removeElement(nums, val);
        System.out.println(length);
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i : nums) {
            if (i != val) {
                nums[index++] = i;
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }
}
