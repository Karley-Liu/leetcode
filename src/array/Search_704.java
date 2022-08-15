package array;

public class Search_704 {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0,right = length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        new Search_704().search(nums,target);
    }
}
