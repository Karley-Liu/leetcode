package dp;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i =1;i<length;i++){
            dp[i] = Math.max(dp[i-1],0)+nums[i];
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        new MaxSubArray().maxSubArray(nums);
    }
}
