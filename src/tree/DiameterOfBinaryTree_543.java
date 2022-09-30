package tree;

public class DiameterOfBinaryTree_543 {

    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        //后序位置
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter,myDiameter);
        return 1+Math.max(leftMax,rightMax);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode pre = root.left;
        pre.left = new TreeNode(4);
        pre.right = new TreeNode(5);
        root.right = new TreeNode(3);
        new DiameterOfBinaryTree_543().diameterOfBinaryTree(root);
    }
}
