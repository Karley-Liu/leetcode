package tree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class IsValidBST_98 {
    /**
     * 递归写法
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long minVal,long maxVal){
        if (root == null){
            return true;
        }
        /**
         * 节点超过范围直接返回
         */
        if (root.val >= maxVal || root.val <= minVal){
            return false;
        }
        /**
         * 分别左右两个子节点分别判断
         * 左子树范围最小为minVal,最大值
         */
        return isValidBST(root.left,minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    /**
     * 中序遍历递归
     * @param args
     */
    TreeNode prev;
    public boolean isValidBST2(TreeNode root){
        if (root == null){
            return true;
        }
        //访问左子树
        if (!isValidBST2(root.left)){
            return false;
        }
        //访问当前节点,如果当前节点等于小于中序遍历的前一个节点直接返回false
        if (prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        //访问右子树
        if (!isValidBST2(root.right)){
            return false;
        }
        return true;
    }


    /**
     * 中序遍历非递归
     * @param args
     */
    public boolean isValidBST3(TreeNode root){
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val){
                return false;
            }
            //保存前一个访问的节点
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        TreeNode pre = treeNode.right;
        pre.left = new TreeNode(3);
        pre.right = new TreeNode(7);
        IsValidBST_98 isValidBST_98 = new IsValidBST_98();
        isValidBST_98.isValidBST3(treeNode);
    }

}
