package array;

/**
 * 旋转数组
 */
public class Rotate_189 {

    /**
     * 自己的
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int numsL = nums.length;
        if (numsL!= 0 && k != 0){
            k %= numsL;
            int last = numsL - k;
            int[] newArr = new int[numsL];
            for (int i=0;i<numsL;i++){
                newArr[i] = nums[i];
            }
            for (int i = 1;i <= last;i++){
                nums[numsL-i] = newArr[last-i];
            }
            for (int i = 1;i <= k;i++){
                nums[k-i] = newArr[numsL-i];
            }
            printArr(nums);
        }
    }

    /**
     * 临时数组
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums,int k){
        /**
         * 原数组存放到临时数组中,再把临时数组的值重新赋给原数组
         * 重新赋值的时候保证每个元素往后移k位,如果超过数组长度从头开始
         */
        int length = nums.length;
        int[] temp = new int[length];
        //原数组放入临时数组中
        for(int i = 0;i<length;i++){
            temp[i] = nums[i];
        }
        //然后临时数组的值重新放到原数组,并且往右移动k位
        for (int i = 0;i<length;i++){
            nums[(i+k)%length] = temp[i];
        }
    }

    /**
     * 多次反转
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums,int k){
        /**
         * 先反转全部数组
         * 再反转前k个
         * 最后再反转剩余的
         */
        int length = nums.length;
        k %= length;
        reverse(nums,0,length-1); //先反转全部元素
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);

    }

    public static void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 环形旋转
     * @param nums
     * @param k
     */
    public static void rotate4(int[] nums,int k){
        /**
         * 元素移动每次动k个
         * 如果nums.length % k = 0,数组长度的倍数,数组原地打转
         * 使用visited数组表示元素有无访问过,访问过从下一个开始
         */
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i =0;i<length;i++){
            index = (index + k) % length;
            if (visited[i]){
                //访问过,再次访问原地打转
                //不能再访问,直接从下一个元素开始
                index = (index + 1) % length;
                hold = nums[index];
                i--;
            }else {
                //把当前值保存下一位置,保存之前把下一位置的值记录下来
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold=temp;
            }
        }
    }
    public static void printArr(int[] nums){
        for (int n:nums){
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
//        printArr(nums);
    }
}
