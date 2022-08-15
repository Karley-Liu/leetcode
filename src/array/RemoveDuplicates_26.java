package array;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 */
public class RemoveDuplicates_26 {

    /**
     * 双指针解决
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int left = 0;
        for (int right = 1;right < nums.length;right++){
            if (nums[left] != nums[right]){
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int k = removeDuplicates(nums);
    }
}
