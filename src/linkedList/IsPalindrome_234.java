package linkedList;

/**
 * 回文链表
 */
public class IsPalindrome_234 {

    public static boolean isPalindrome(ListNode head) {
        int length = length(head);
        int[] listNodeArr = new int[length];
        ListNode pre = head;
        for (int i = 0;i<length;i++){
            listNodeArr[i] = pre.val;
            pre = pre.next;
        }
        for (int i = 0;i<length/2;i++){
            if (listNodeArr[i] != listNodeArr[length-1-i]){
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    public static int length(ListNode head){
        int length = 0;
        while (head != null){
            head = head.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] head = {1,2};
        ListNode listNode = new ListNode(head[0]);
        for (int i = 1;i< head.length;i++){
            listNode.add(head[i]);
        }
        isPalindrome(listNode);
    }
}
