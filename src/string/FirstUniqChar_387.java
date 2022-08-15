package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 */
public class FirstUniqChar_387 {

    /**
     * 使用hashMap
     * @param args
     */
    public static int firstUniqChar(String s){
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for (int i = 0;i < arr.length;i++){
            if (map.get(arr[i]) == 1){
                System.out.println(i);
                return i;
            }
        }
        System.out.println(-1);
        return -1;
    }

    /**
     * 两次遍历
     * @param args
     */
    public int firstUniqChar2(String s){
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        //先统计每个字符出现的次数
        for (int i=0;i<s.length();i++){
            //chars[i]为98,99 - a等于0,1,2
            count[chars[i] - 'a']++;
        }
        //然后在遍历字符串s中的字符,如果出现次数1直接返回
        for (int i = 0;i<s.length();i++){
            if (count[chars[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "aabb";
        new FirstUniqChar_387().firstUniqChar2(s);
    }
}
