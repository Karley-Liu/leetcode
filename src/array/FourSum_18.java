package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int a = 0;a<length;a++){
            if (a > 0 && nums[a] == nums[a-1]){
                continue;
            }
            int d = length-1;
            long val = (long)target - nums[a] - nums[d];
            for (int b = a+1;b < length;b++){
                if (b > a + 1 && nums[b] == nums[b-1]){
                    continue;
                }
                for (int c = b+1;c<length;c++){
                    if (c > b+1 && nums[c] == nums[c-1]){
                        continue;
                    }
                    d = length-1;
                    val = (long)target - nums[a] - nums[d];

                    while (b < c && c < d && (long)nums[b] + nums[c] > val){
                        d--;
                        val = (long)target - nums[a] - nums[d];
                    }

                    if (b == c || c ==d){
                        break;
                    }
                    if (nums[b] + nums[c] == val){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        new FourSum_18().fourSum(nums,-294967296);
    }
}
