package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 存在重复元素
 */
public class ContainsDuplicate_217 {
    /**
     * hashMap求解
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Object> map = new HashMap<>();
        int temp = 0;
        int flag = 0;
        for (Integer num:nums){
            if (map.get(num)==null){
                map.put(num,1);
            }else {
                temp = (int)map.get(num)+1;
                map.put(num,temp);
                flag = 1;
                break;
            }
        }
        return flag==1;
    }

    /**
     * set求解
     */

    public boolean containsDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            //集合中不能有重复元素,如果有重复元素添加失败
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        //如果set有重复会被覆盖,size减少
        //没有重复,set大小等于nums长度
        return set.size() != nums.length;
    }
}
