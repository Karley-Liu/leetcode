package linkedList;

public class DeleteDuplicates_83 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head,fast = head;
        while (fast != null){
            if (slow.val != fast.val){
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode pre;
        pre = node;
        pre.next = new ListNode(1);
        pre = pre.next;
        pre = new ListNode(2);
        deleteDuplicates(node);
    }
}
