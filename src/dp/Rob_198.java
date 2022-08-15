package dp;

public class Rob_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;   //没偷
        dp[0][1] = nums[0];     //偷了
        for (int i = 1;i<length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]); //下一家没偷
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        System.out.println(Math.max(dp[length-1][0],dp[length-1][1]));
        return Math.max(dp[length-1][0],dp[length-1][1]);
    }

    /**
     * 动态规划优化
     * @param nums
     * @return
     */
    public int rob2(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        int dp0 = 0;    //第一家没偷
        int dp1 = nums[0];  //第一家投偷了
        for (int i = 1;i<length;i++){
            int temp = Math.max(dp0,dp1);
            dp1 = dp0 + nums[i];
            dp0 = temp;
        }
        return Math.max(dp0,dp1);
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        new Rob_198().rob(nums);
    }
}
