package linkedList;

import java.util.Stack;

/**
 * 反转链表
 */
public class ReverseList_206 {

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pre = head;
        while (pre != null){
            stack.add(pre);
            pre = pre.next;
        }
        if (stack.isEmpty()){
            return null;
        }
        ListNode newListNode = stack.pop();
        pre = newListNode;
        while (!stack.empty()){
            ListNode pop = stack.pop();
            pre.next = pop;
            pre = pre.next;
        }
        pre.next = null;
        newListNode.print();
        return newListNode;
    }

    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        ListNode listNode = new ListNode(head[0]);
        for (int i = 1;i< head.length;i++){
            listNode.add(head[i]);
        }
        reverseList(listNode);
    }
}
