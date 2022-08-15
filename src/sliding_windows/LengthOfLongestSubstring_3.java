package sliding_windows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring_3 {

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        char[] sChar = s.toCharArray();
        int length = s.length();
        Set<Character> set = new HashSet<>();
        // 右指针,初始值为-1,相当于我们在字符串左边界的左侧,没有开始移动
        int right = -1;
        int res = 0;
        for (int i = 0;i < length;++i){
            if (i != 0){
                //左指针向右移动一格,移除一个字符
                set.remove(sChar[i-1]);
            }
            while (right + 1 < length && !set.contains(sChar[right+1])){
                //不停移动右指针
                set.add(sChar[right+1]);
                ++right;
            }
            res = Math.max(res,right-i+1);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        new LengthOfLongestSubstring_3().lengthOfLongestSubstring(s);
    }
}
