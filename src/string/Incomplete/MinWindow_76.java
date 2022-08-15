package string.Incomplete;

import java.util.HashMap;
import java.util.Map;

public class MinWindow_76 {
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

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        new MinWindow_76().minWindow(s,t);
    }
}
