package array;

import java.util.*;

public class ThreeSum_15 {

    //自己写的垃圾算法超时了
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arrList = new ArrayList<>();
        if (nums.length < 3){
            return arrList;
        }
        Set<List<Integer>> set = new HashSet<>();
        int i = 0,j = i+1;
        int temp = j+1;
        while (i < nums.length){
            if (j >= nums.length){
                i++;
                j = i+1;
                temp = j+1;
                continue;
            }
            if (temp >= nums.length){
                j++;
                temp = j+1;
                continue;
            }
            if (nums[i] + nums[j] + nums[temp] == 0){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[temp]);
                set.add(list);
                j++;
                temp = j+1;
            }else {
                temp++;
            }
        }
        arrList.addAll(set);
        return arrList;
    }

    public List<List<Integer>> threeSum2(int[] nums){
        int length = nums.length;
        //利用排序避免重复答案
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        //枚举a
        for (int first = 0;first < length;first++){
            //需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int third = length-1;
            int target = -nums[first];
            //枚举b
            for (int second = first+1;second < length;second++){
                //需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second-1]){
                    continue;
                }
                //需要保证b的指针在c的指针的左侧,确保二三指针加和大于一指针就不对直接三指针减少
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }
                //如果指针重合,随着b后续的增加
                //不会有满足a+b+c=0且b<c的,可以推出循环
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,1,2,3,0,-1,2};
        new ThreeSum_15().threeSum2(nums);
    }
}
