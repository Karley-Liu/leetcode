package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder_102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!deque.isEmpty()){
            //每一层的个数
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i<size;i++){
                TreeNode pop = deque.pop();
                list.add(pop.val);
                if (pop.left != null){
                    deque.addLast(pop.left);
                }
                if (pop.right !=null){
                    deque.addLast(pop.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
