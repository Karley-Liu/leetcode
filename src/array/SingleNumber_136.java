package array;

import java.util.*;

/**
 * 只出现一次的数字
 */
public class SingleNumber_136 {

    /**
     * 自己写的傻逼算法
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n:nums){
            if (!map.containsKey(n)){
                map.put(n,1);
            }else {
                map.replace(n,map.get(n)+1);
            }
        }
        int goal = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            if (map.get(key)==1){
                goal = key;
            }
        }
        System.out.println(goal);
        return goal;
    }

    /**
     * 位运算,抑或
     * 相异为真 0^a = a
     * 相同为假 a^a = 0
     * 抑或运算满足交换律 a^b^a = a^a^b = b
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums){
        int reduce = 0;
        for (int num:nums){
            reduce = reduce ^ num;
        }
        System.out.println(reduce);
        return reduce;
    }

    /**
     * set集合求解
     * @param nums
     */
    public static int singleNumber3(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            if (!set.add(num)){
                /**
                 * 如果添加失败,说明集合里有该值
                 * 移除掉
                 */
                set.remove(num);
            }
        }
        return (int) set.toArray()[0];
    }

    public void printArr(int[] nums){
        for (int n:nums){
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        singleNumber(nums);
    }
}
