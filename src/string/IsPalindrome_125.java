package string;

/**
 * 验证回文串
 */
public class IsPalindrome_125 {

    public static boolean isPalindrome(String s){
        //过滤只考虑字母,数字字符,空格
        //大小写不敏感,同统一转换小写
        if (s.length() == 1){
            return true;
        }
        String newS = s.toLowerCase();
        for (int i = 0;i<newS.length();i++){
            if (!Character.isLetterOrDigit(newS.charAt(i))){
                //subString左闭合右开口
                newS = newS.substring(0,i).concat(newS.substring(i+1));
                i--;
            }
        }
        for (int i = 0;i<newS.length();i++){
            String a = String.valueOf(newS.charAt(i));
            String b = String.valueOf(newS.charAt(newS.length()-1-i));
            if (!a.equals(b)){
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        isPalindrome(s);
    }
}
