package string;

import java.util.Arrays;

public class CheckInclusion_567 {

    public boolean checkInclusion(String s1, String s2) {
        //s1是子串
        char[] s1Char = s1.toCharArray();

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (Character c:s1Char){
            s1Count[c - 'a']++;
        }
        int left = 0,right = 0;
        int s1Len = s1.length();
        int s2Len = s2.length();
        while (right < s2Len){
            s2Count[s2.charAt(right) - 'a']++;
            if (right - left == s1Len-1){
                if (Arrays.equals(s1Count,s2Count)){
                    return true;
                }else {
                    s2Count = new int[26];
                    left++;
                    right = left;
                }
            }else {
                right++;
            }
        }
        return false;
    }

    public boolean checkInclusion2(String s1,String s2){
        int n = s1.length(),m = s2.length();
        if (n > m){
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0;i<n;i++){
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1,cnt2)){
            return true;
        }
        for (int i = n;i<m;i++){
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i-n) - 'a']--;
            if (Arrays.equals(cnt1,cnt2)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        new CheckInclusion_567().checkInclusion2(s1,s2);
    }
}
