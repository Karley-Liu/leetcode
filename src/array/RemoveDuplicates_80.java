package array;

public class RemoveDuplicates_80 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 2,right = 2;
        while (right < n ){
            if (nums[left-2] != nums[right]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        new RemoveDuplicates_80().removeDuplicates(nums);
    }
}
