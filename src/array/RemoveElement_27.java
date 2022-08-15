package array;

/**
 * 移除元素
 */
public class RemoveElement_27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int left = 0,right = nums.length-1;
        int temp;
        while (left != right){
            if (nums[right] == val){
                right--;
            }else if (nums[left] != val){
                left++;
            }else {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        System.out.println(nums[left]==val?left:++right);
        return nums[left]==val?left:++right;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        new RemoveElement_27().removeElement(nums,val);
    }
}
