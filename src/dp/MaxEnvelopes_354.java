package dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes_354 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ?
                        o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int length = envelopes.length;
        //对高度数组寻找LIS
        int[] height = new int[length];
        for (int i = 0;i<length;i++){
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    int lengthOfLIS(int[] nums){
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
        int[][] envelopes = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        new MaxEnvelopes_354().maxEnvelopes(envelopes);
    }
}
