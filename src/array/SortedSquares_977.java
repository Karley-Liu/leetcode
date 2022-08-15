package array;

import java.util.Arrays;

public class SortedSquares_977 {

    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] newArr = new int[length];
        for (int i = 0;i<length;i++){
            newArr[i] = nums[i] * nums[i];
        }
        Arrays.sort(newArr);
        return newArr;
    }

    //双指针1+归并排序
    public int[] sortedSquares2(int[] nums){
        int n = nums.length;
        int negative = -1;
        for (int  i =0;i<n;i++){
            if (nums[i] < 0){
                negative = i;
            }else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0,i = negative,j = negative+1;
        while (i >= 0 || j < n){
            if (i < 0){
                ans[index] = nums[j] * nums[j];
                j++;
            }else if (j == n){
                ans[index] = nums[i] * nums[i];
                i--;
            }else if (nums[i] * nums[i] < nums[j] * nums[j]){
                ans[index] = nums[i] * nums[i];
                i--;
            }else {
                ans[index] = nums[j] * nums[j];
                j++;
            }
            index++;
        }
        return ans;
    }

    //双指针+倒叙排序
    public int[] sortedSquares3(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0,j = n-1,pos = n-1;i <= j;){
            if (nums[i] * nums[i] > nums[j] * nums[j]){
                ans[pos] = nums[i] * nums[i];
                i++;
            }else {
                ans[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        new SortedSquares_977().sortedSquares3(nums);
    }
}
