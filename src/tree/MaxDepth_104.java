package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxDepth_104 {

    /**
     * 递归
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return depth;
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root){
        if (root == null){
            return 0;
        }
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()){
            //每一层的个数
            int size = deque.size();
            while (size-- > 0){ //比较后自减
                TreeNode cur = deque.pop();
                if (cur.left != null){
                    deque.addLast(cur.left);
                }
                if (cur.right !=null){
                    deque.addLast(cur.right);
                }
            }
            count++;
        }
        return count;
    }

    /**
     * DFS
     * @param root
     * @return
     */
    public static int maxDepth3(TreeNode root){
        if (root == null){
            return 0;
        }
        //stack记录的是结点，level中的元素和stack中的元素
        //是同时入栈同时出栈，并且level记录的结点是在第几层
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
        int max = 0;
        while (!stack.isEmpty()){
            //stack中的元素和level中的元素同时出栈
            TreeNode node = stack.pop();
            int temp = level.pop();
            max = Math.max(temp, max);
            if (node.left != null){
                //同时入栈
                stack.push(node.left);
                level.push(temp+1);
            }
            if (node.right != null){
                //同时入栈
                stack.push(node.right);
                level.push(temp+1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        TreeNode pre = treeNode.right;
        pre.left = new TreeNode(15);
        pre.right = new TreeNode(7);
        maxDepth3(treeNode);
    }
}
