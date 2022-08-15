package array;

public class MaxArea_11 {
    public int maxArea(int[] height) {
        int left = 0,right = height.length-1;
        int ans = 0;
        while (left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans,area);
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        new MaxArea_11().maxArea(height);
    }
}
