package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 */
public class MinimumTotal_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = triangle.size()-1;i>=0;i--){
            for (int j = 0;j < triangle.get(i).size();j++){
                if (i == triangle.size()-1){
                    dp[i][j] = triangle.get(i).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
                }
            }
        }
        System.out.println(dp[0][0]);
        return dp[0][0];
    }

    public static void main(String[] args) {
        Integer[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0;i<triangle.length;i++){
            lists.add(Arrays.asList(triangle[i]));
        }
        new MinimumTotal_120().minimumTotal(lists);
    }
}
