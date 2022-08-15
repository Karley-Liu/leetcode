package array;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int left = 0,right = 0;
        while (left < sChars.length && right < tChars.length){
            if (sChars[left] == tChars[right]){
                left++;
            }
            right++;
        }
        return left == sChars.length;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        new IsSubsequence_392().isSubsequence(s,t);
    }
}
