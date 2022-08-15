package string;

import java.util.*;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix_14 {

    public static String longestCommonPrefi(String[] strs){
        if (strs == null || strs.length == 0) {
            System.out.println("");
            return "";
        }
        if (strs.length == 1){
            System.out.println(strs[0]);
            return strs[0];
        }
        int shortestLength = strs[0].length();
        String tempString = "";
        int shortestIndex = 0;
        for (int i = 1;i<strs.length;i++) {
            int tempShortest = Math.min(shortestLength, strs[i].length());
            if (shortestLength != tempShortest) {
                shortestLength = tempShortest;
                shortestIndex = i;
            }
        }
        for (int i = 0;i<strs[shortestIndex].length();i++){
            //遍历最短str的字符
            for (int j = 0;j+1<strs.length;j++){
                //遍历str数组去比较
                if (!String.valueOf(strs[j].charAt(i)).equals(String.valueOf(strs[j+1].charAt(i)))){
                    System.out.println(tempString);
                    return tempString;
                }else {
                    if (j+1 == strs.length-1){
                        tempString = tempString.concat(String.valueOf(strs[j].charAt(i)));
                    }
                    continue;
                }
            }
        }
        System.out.println(tempString);
        return tempString;
    }

    public static void main(String[] args) {
        String[] strs = {"a"};
        longestCommonPrefi(strs);
    }
}
