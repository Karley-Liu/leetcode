package array;

public class NumArray_303 {

    private int[] preSum;

    public NumArray_303(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i =1;i<n+1;i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }

    public static void main(String[] args) {

    }
}
