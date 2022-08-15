package array;

public class PeakIndexInMountainArray_852 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0,right = arr.length-1;
        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] > arr[mid]){
                left = mid;
            }else if (arr[mid - 1] > arr[mid] && arr[mid + 1] < arr[mid]){
                right = mid;
            }else if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]){
                System.out.println(mid);
                return mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {18,29,38,59,98,100,99,98,90};
        new PeakIndexInMountainArray_852().peakIndexInMountainArray(arr);
    }
}
