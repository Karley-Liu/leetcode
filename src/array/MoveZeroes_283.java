package array;

/**
 * 移动零
 */
public class MoveZeroes_283 {

    /**
     * 非0往前挪
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums.length == 1){
            return;
        }
        int index = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length){
            nums[index++] = 0;
        }
    }

    /**
     * 双指针解决
     * j一直往后移动,如果指向的值不等于0才操作
     * i统计前面0的个数
     * 把j-i看作另一个指针,指向前面第一个0的位置
     * 让j指向的值和j-i指向的值交换
     * @param args
     */
    public static void moveZeroes2(int[] nums){
        int i = 0;
        for (int j=0;i< nums.length;j++){
            if (nums[j] == 0){
                i++;
            }else if (i != 0){
                nums[j - i] = nums[j];
                nums[j] = 0;
            }
        }
    }

    /**
     * 只要不为0就往前挪
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //只要不为0就往前挪
            if (nums[j] != 0) {
                //i指向的值和j指向的值交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0};
        moveZeroes(nums);
    }
}
