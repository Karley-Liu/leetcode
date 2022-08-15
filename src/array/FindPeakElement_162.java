package array;

public class FindPeakElement_162 {
    public int findPeakElement(int[] arr) {
        int left = 0,right = arr.length-1;
        while (left < right){
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid +1]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        new FindPeakElement_162().findPeakElement(arr);
    }
}
