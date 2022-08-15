package string;

/**
 * 反转字符串
 */
public class ReverseString_344 {

    /**
     * 双指针
     * @param s
     */
    public static void reverseString(char[] s){
        int length = s.length;
        int mid;
        if (length % 2 == 1){
            mid = length / 2 +1;
        }else {
            mid = length / 2;
        }
        char temp;
        for (int i = 0;i < mid;i++){
            temp = s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = temp;
        }
    }

    public void reverseString2(char[] s){
        if (s == null || s.length == 0){
            return;
        }
        reverseStringDiGui(s,0,s.length-1);
    }

    public void reverseStringDiGui(char[] s,int left,int right){
        if (left >= right){
            return;
        }
        swap(s,left,right);
        reverseStringDiGui(s,++left,--right);
    }

    private void swap(char[] array,int i,int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o','!'};
        reverseString(s);
    }
}
