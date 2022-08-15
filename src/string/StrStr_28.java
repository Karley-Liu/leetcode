package string;

/**
 * 实现 strStr()
 */
public class StrStr_28 {

    public static int strStr(String haystack,String needle){
        if (needle.length() == 0){
            System.out.println(0);
            return 0;
        }
        if (haystack.contains(needle)){
            System.out.println(haystack.indexOf(needle));
            return haystack.indexOf(needle);
        }
        System.out.println(-1);
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        strStr(haystack,needle);
    }
}
