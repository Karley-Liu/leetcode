package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams_438 {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        List<Integer> res = new ArrayList<>();

        for (int i = 0;i<pLen;i++){
            pCount[p.charAt(i) - 'a']++;
        }

        int left = 0,right = 0;
        while (right < sLen){
            sCount[s.charAt(right) - 'a']++;
            if (right - left == pLen-1){
                if (Arrays.equals(sCount,pCount)){
                    res.add(left);
                }else {
                    sCount = new int[26];
                    left++;
                    right = left;
                }
            }else {
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        String p = "a";
        new FindAnagrams_438().findAnagrams(s,p);
    }
}
