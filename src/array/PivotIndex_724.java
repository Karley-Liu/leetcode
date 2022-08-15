package array;

/**
 * 寻找数组的中心索引
 */
public class PivotIndex_724 {

    public int pivotIndex(int[] nums){
        int sum = 0,flag = 0,end = 0;
        int length = nums.length;
        for (int i = 0;i<nums.length;i++){
            sum += nums[i];
        }
        if (sum - nums[0] == 0){
            return 0;
        }
        for (int j = 0;j<length;j++){
            flag += nums[j];    //flag为数组索引为0到索引为j位置所有元素的总和
            if ( j != 0){
                end = flag-nums[j];     //end为数组中索引不为0的位置到索引为j-1位置所有元素的和
            }
            if (end == sum-flag){       //数组中索引为j位置前的所有元素总和
                return j;       //与数组中索引位置为j的位置后的所有元素总和相等
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        new PivotIndex_724().pivotIndex(nums);
    }
}
