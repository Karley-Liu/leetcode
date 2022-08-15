package tree;

public class SortedArrayToBST_108 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums,int start,int end){
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        if (end >= start){
            treeNode.left = sortedArrayToBST(nums,start,mid-1);
            treeNode.right = sortedArrayToBST(nums,mid+1,end);
            return treeNode;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }
}
