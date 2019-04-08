package cn.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int nums[] = {1,3,5,6};
        int result = new SearchInsertPosition().searchInsert(nums, 7);
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
