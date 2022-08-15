package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        先统计较短的数组数据重合情况
        for (int num:nums1){
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count);
        }
//        记录最终结果
        int[] intersection = new int[nums1.length];
        int index=0;
        for (int num:nums2){
            int count = map.getOrDefault(num, 0);
            if (count > 0){
//                有一个就弹出来去最终结果数组
                intersection[index++] = num;
                count--;
                if (count>0){
//                    出现一次减少一次计数
                    map.put(num,count);
                }else {
//                    出现完就移除
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }

    public int[] intersetc(int[] nums1,int[] nums2){
        if (nums1.length < nums2.length){
            return intersetc(nums2,nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int num:nums1){
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num,count);
        }

        int[] intersection = new int[nums2.length];
        int index=0;

        for (int num:nums2){
            int count = map.getOrDefault(num, 0);
            if (count > 0){
                intersection[index++] = num;
                count--;
                if (count > 0){
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }
    public static void main(String[] args) {
        Leetcode350 leetcode350 = new Leetcode350();
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        leetcode350.intersetc(nums1,nums2);
    }
}
