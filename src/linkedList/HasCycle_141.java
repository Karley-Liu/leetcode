package linkedList;

import java.util.*;

/**
 * 环形链表
 */
public class HasCycle_141 {

    public static boolean hasCycle(ListNode head){
        if (head == null || head.next==null){
            return false;
        }
        ListNode pre = head;
        Set<ListNode> set = new HashSet<>();
        while (pre != null){
            if (set.contains(pre)) {
                System.out.println("true");
                System.out.println("true");
                return true;
            }else {
                set.add(pre);
                pre = pre.next;
            }
        }
        System.out.println("false");
        return false;
    }

//    public static int length(linkedList.ListNode head){
//        int length = 0;
//        while (head != null){
//            head = head.next;
//            length++;
//        }
//        return length;
//    }

    public static void main(String[] args) {
        int[] head = {1,2};
        int pos = -1;
        ListNode listNode = new ListNode(head[0]);
        ListNode pre = listNode;
        ListNode targetListNode = listNode;
        for (int i = 1;i< head.length;i++){
            listNode.add(head[i]);
            if (i <= pos && pos != -1){
                targetListNode = targetListNode.next;
            }
            pre = pre.next;
        }
        if (pos != -1){
            pre.next = targetListNode;
        }
        hasCycle(listNode);
    }
}
