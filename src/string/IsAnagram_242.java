package string;

import java.util.*;

/**
 * 有效的字母异位词
 */
public class IsAnagram_242 {

    /**
     * 自己写的傻逼代码
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s,String t){
        Map<Character, Integer> sMap = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (Character c:sArr){
            sMap.put(c,sMap.getOrDefault(c,0)+1);
        }
        for (Character c:tArr){
            if (sMap.getOrDefault(c,0) != 0){
                sMap.replace(c,sMap.get(c)-1);
            }else {
                System.out.println("false");
                return false;
            }
        }
        Set<Map.Entry<Character, Integer>> set = sMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Character, Integer> next = it.next();
            if (next.getValue() !=0){
                System.out.println("false");
                return false;
            }

        }
        System.out.println("true");
        return true;
    }

    /**
     * 计算两个字符串中字符的差值
     * 先统计字符串s中每个字符的数量
     * 减去t中每个字符对应的数量
     * @param args
     */
    public boolean isAnagram2(String s,String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] letterCount = new int[26];
        //统计字符串s中的每个字符的数量
        for (int i = 0;i<s.length();i++){
            letterCount[s.charAt(i) - 'a']++;
        }
        //减去字符串t中每个字符的数量
        for (int i = 0;i<t.length();i++){
            //如果当前字符等于0,直接返回false
            if (letterCount[t.charAt(i) - 'a'] == 0){
                return false;
            }
            letterCount[t.charAt(i) - 'a'] --;
            //如果数组letterCount每个值都是0,返回true,否则返回false
        }
        for (int count:letterCount){
            if (count != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 先排序
     * 再比较
     * @param args
     */
    public boolean isAnagram3(String s,String t){
        char[] sChar = s.toCharArray();
        char[] tchar = t.toCharArray();
        //排序
        Arrays.sort(sChar);
        Arrays.sort(tchar);
        return Arrays.equals(sChar,tchar);
    }

    /**
     * 一次遍历
     * 变量count记录新出现字符个数,同时遍历两个数组
     * 新字符count+1,消失字符count-1
     * 最后判断count是否等于0
     * @param args
     */
    public boolean isAnagram4(String s,String t){
        if (s.length() != t.length()){
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[26];
        int count = 0;
        for (int i = 0;i<cs.length;i++){
            //出现新字符
            if (++map[cs[i] - 'a'] == 1){
                count++;
            }
            if (--map[ct[i] - 'a'] == 0){
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        new IsAnagram_242().isAnagram4(s,t);
    }
}
