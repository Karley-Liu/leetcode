package linkedList;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists_21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null){
            return null;
        }
        if (list1 == null || list2 == null){
            return list1 == null?list2:list1;
        }
        ListNode newListNode = new ListNode();
        ListNode pre = newListNode;

        ListNode l1Pre = list1;
        ListNode l2Pre = list2;

        while (l1Pre != null && l2Pre != null){
            if (l1Pre.val == l2Pre.val){
                pre.next = new ListNode(l1Pre.val);
                pre = pre.next;
                pre.next = new ListNode(l2Pre.val);
                pre = pre.next;
                l1Pre = l1Pre.next;
                l2Pre = l2Pre.next;
            }else {
                int min = Math.min(l1Pre.val, l2Pre.val);
                if (min == l1Pre.val){
                    pre.next = new ListNode(l1Pre.val);
                    l1Pre = l1Pre.next;
                }else {
                    pre.next = new ListNode(l2Pre.val);
                    l2Pre = l2Pre.next;
                }
                pre = pre.next;
            }
        }
        if (l1Pre == null){
            pre.next = l2Pre;
        }else {
            pre.next = l1Pre;
        }
        pre = newListNode.next;
        pre.print();
        return pre;
    }

    public static void main(String[] args) {
        int[] list1 = {2};
        int[] list2 = {1};

        ListNode listNode1 = new ListNode(list1[0]);
        for (int i = 1;i< list1.length;i++){
            listNode1.add(list1[i]);
        }
        ListNode listNode2 = new ListNode(list2[0]);
        for (int i = 1;i< list2.length;i++){
            listNode2.add(list2[i]);
        }

        mergeTwoLists(listNode1,listNode2);
    }
}
