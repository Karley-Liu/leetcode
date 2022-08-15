package array;

import java.util.*;

/**
 * 两个数组的交集 II
 */
public class Intersect_350 {
    /**
     * 自己写的傻逼算法
     * map
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null){
            return null;
        }
        Map<Integer, Integer> nums1Map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (Integer num:nums1){
            if (nums1Map.containsKey(num)){
                nums1Map.put(num,nums1Map.get(num)+1);
            }else {
                nums1Map.put(num,1);
            }
        }
        for (Integer num:nums2){
            if (nums1Map.containsKey(num)){
                if (nums1Map.get(num) != 0){
                    nums1Map.put(num,nums1Map.get(num)-1);
                    list.add(num);
                }
            }
        }
        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        return array;
    }

    /**
     * 先对数组进行排序
     * 然后用两个指针分别指向两个数组开始的位置
     * 如果两个指针的值相同,说明交交集,加入list集合,两个指针后移一步
     * 如果值不同,相对较小的后移一步,相对较大的不动,再做比较
     * 直到其中一个指针不能动为止,再把集合list转为数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1,int[] nums2){
        /**
         * 先排序
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[i]){
                /**
                 * 如果i指向的值小于j指向的值
                 * i后移
                 */
                i++;
            }else if (nums1[i] > nums2[i]){
                j++;
            }else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        /**
         * list转为数组
         */
        int index = 0;
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[index++] = list.get(k);
        }
        return res;
    }
}
