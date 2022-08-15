package array.Incomplete;

import java.util.Arrays;

public class ThreeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0;i + 2 < nums.length;i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1;j+1< nums.length;j++){
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                for (int z = j+1;z+1< nums.length;z++){
                    if (z > j+1 && nums[z] == nums[z-1]){
                        continue;
                    }
                    int temp = nums[i] + nums[j] + nums[z];
                    int abs = temp - target;
                    min = Math.min(Math.abs(min - target),Math.abs(abs));
                    if (Math.abs(abs) == min){
                        ans = temp;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        new ThreeSumClosest_16().threeSumClosest(nums,target);
    }
}
