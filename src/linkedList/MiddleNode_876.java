package linkedList;

import java.util.List;

public class MiddleNode_876 {

    public ListNode middleNode(ListNode head) {
        int len = length(head);
        len=len/2;
        ListNode pre=head;
        while (len != 0){
            pre=pre.next;
            len--;
        }
        return pre;
    }

    int length(ListNode head){
        int len=0;
        ListNode pre=head;
        while (pre!=null){
            len++;
            pre=pre.next;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] n={1,2,3,4,5,6};
        ListNode listNode = new ListNode(1);
        for (int i=1;i<n.length;i++){
            listNode.add(n[i]);
        }
        new MiddleNode_876().middleNode(listNode);
    }
}
