package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsSymmetric_101 {

    /**
     * 递归
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetricDiGui(root.left,root.right);
    }

    public static boolean isSymmetricDiGui(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }
        return isSymmetricDiGui(left.left,right.right) && isSymmetricDiGui(left.right,right.left);
    }

    /**
     * 非递归
     * @param args
     */
    public boolean isSymmetric2(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return true;
        }
        //左子节点和右子节点同时入队
        queue.add(root.left);
        queue.add(root.right);
        //队列不为空继续循环
        while (!queue.isEmpty()){
            //每两个出队
            TreeNode left = queue.poll(),right = queue.poll();
            //如果都为空继续循环
            if (left == null && right == null){
                continue;
            }
            //如果一个为空一个不为空,不对称,直接false
            if (left == null ^ right == null){
                return false;
            }
            //如果两个值不相同,也不对称,直接false
            if (left.val != right.val){
                return false;
            }
            //这里要记住入队顺序,每两个出队
            //左子节点的左和右子节点的右同时入队,同时比较
            //左子节点的右和右子节点的左同时入队,同时比较
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(2);
//        TreeNode pre = treeNode.left;
        treeNode.right.right = new TreeNode(3);
//        pre.right = new TreeNode(3);
//        pre = treeNode.right;
//        pre.left = new TreeNode(4);
//        pre.right = new TreeNode(3);
        new IsSymmetric_101().isSymmetric2(treeNode);
    }
}
