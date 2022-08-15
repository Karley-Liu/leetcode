package array;

/**
 * 接雨水
 */
public class Trap_44 {

    //双指针
    public int trap(int[] height) {
        int ans = 0;
        int left = 0,right = height.length-1;
        int leftMax = 0,rightMax = 0;
        while (left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (height[left] < height[right]){
                ans += leftMax - height[left];
                left++;
            }else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    //动态规划
    public int trap2(int[] height){
        int length = height.length;
        if (length == 0){
            return 0;
        }

        //从左起遍历获取最大值
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1;i<length;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        //从右起遍历获取最大值
        int[] rightMax = new int[length];
        rightMax[length-1] = height[length-1];
        for (int i = length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        //遍历答案,用两者最小的减去height[i],记为雨水数量,加和
        int ans = 0;
        for (int i = 0;i<length;i++){
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }

    //单调栈
//    public int trap3(int[] height){
//
//    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        new Trap_44().trap(height);
    }
}
