package string.Incomplete;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MinWindow_76 {

    //自己写的瞎逼算法
    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0;i<tLen;i++){
            needs.put(t.charAt(i),needs.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0,right = 0;
        String temp = "";
        while (right < sLen){
            if (needs.containsKey(s.charAt(right))){
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right),0)+1);
            }
            if (needs.equals(window)){
                left++;
            }
        }
        return null;
    }

    public String minWindow2(String s,String t){
        if (t.length() > s.length()){
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0,right = 0;
        //valid表示窗口中哪些字符满足了条件
        int valid = 0;
        //记录最小覆盖子串的起始索引及长度
        int start = 0,len = Integer.MAX_VALUE;
        while (right < s.length()){
            //c是将移入窗口的子串
            char c = s.charAt(right);
            //扩大窗口
            right++;
            //窗口数据一系列更新
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //判断左侧窗口是否要收缩
            while (valid == need.size()){
                //更新最小覆盖子串
                if (right-left < len){
                    start = left;
                    len = right - left;
                }

                //d是将移出窗口的字符
                char d = s.charAt(left);
                //缩小窗口
                left++;
                //进行窗口内数据的一系列更新
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        System.out.println(len == Integer.MAX_VALUE?"":s.substring(start,start+len));
        return len == Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        new MinWindow_76().minWindow2(s,t);
    }
}
