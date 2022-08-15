package array;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 加一
 */
public class PlusOne_66 {

    public static int[] plusOne(int[] digits) {

        int length = digits.length;

        for (int i = length-1;i>=0;i--){
            if (digits[i] != 9){
                digits[i]++;
                printArr(digits);
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int[] newArr = new int[length + 1];
        newArr[0] = 1;
        return newArr;
    }

    public static void printArr(int[] nums){
        for (int n:nums){
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        int[] digits = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        plusOne(digits);
    }
}
