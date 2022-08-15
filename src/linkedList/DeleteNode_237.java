package linkedList;

/**
 * 删除链表中的节点
 */
public class DeleteNode_237 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public void add(int newVal){
            ListNode newNode = new ListNode(newVal);
            if (this.next == null){
                this.next = newNode;
            }else {
                this.next.add(newVal);
            }
        }

        public void print(){
            System.out.println(this.val);
            if (this.next != null){
                System.out.print("-->");
                this.next.print();
            }
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] head = {4,1,5,9};
        int node = 5;
        ListNode listNode = new ListNode(head[0]);
        for (int i = 1;i< head.length;i++){
            listNode.add(head[i]);
        }
        listNode.print();
    }

}
