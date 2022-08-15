package array;

import java.util.Arrays;

public class LengthOfLIS_300 {

    //动态分析
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以nums[i]这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        //base case:dp数组全都初始化为1
        Arrays.fill(dp,1);

        for (int i = 0;i< nums.length;i++){
            for (int  j =0;j<i;j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int res = 0;
        for (int i =0;i<dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    //二分查找解法
    public int lengthOfLIS2(int[] nums){
        int length = nums.length;
        int[] top = new int[length];
        //牌堆数初始化为0
        int piles = 0;
        for (int i = 0;i<length;i++){
            //要处理的扑克
            int poker = nums[i];

            //搜索左侧边界的二分查找
            int left = 0,right = piles;
            while (left < right){
                int mid = (left + right) / 2;
                if (top[mid] > poker){
                    right = mid;
                }else if (top[mid] < poker){
                    left = mid+1;
                }else {
                    right = mid;
                }
            }

            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        new LengthOfLIS_300().lengthOfLIS(nums);
    }
}
