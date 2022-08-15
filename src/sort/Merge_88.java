package sort;

import array.Rotate_189;

public class Merge_88 {

    public void merge(int[] nums1,int m,int[] nums2,int n){
        if (m == 0){
            for (int i = 0;i<n;i++){
                nums1[i] = nums2[i];
            }
        }
        if (m != 0){
            int[] tempNums = new int[m];
            for (int i = 0;i<m;i++){
                tempNums[i] = nums1[i];
            }
            int nums1P = 0,nums2P=0;
            for (int i = 0;i<nums1.length;i++){
                if (nums1P < m && nums2P < n){
                    if (tempNums[nums1P] < nums2[nums2P]){
                        nums1[i] = tempNums[nums1P];
                        nums1P++;
                    }else if (tempNums[nums1P] > nums2[nums2P]){
                        nums1[i] = nums2[nums2P];
                        nums2P++;
                    }else {
                        nums1[i] = tempNums[nums1P];
                        nums1P++;
                        i++;
                        nums1[i] = nums2[nums2P];
                        nums2P++;
                    }
                }else if (nums1P == m && nums2P < n){
                    nums1[i] = nums2[nums2P];
                    nums2P++;
                }else if (nums1P < m && nums2P == n){
                    nums1[i] = tempNums[nums1P];
                    nums1P++;
                }
            }
        }
        new Rotate_189().printArr(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        new Merge_88().merge(nums1,m,nums2,n);
    }
}
