package linkedList;

/**
 * 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd_19 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre = head;
          int last = length(head) - n;
          if (last == 0){
              return head.next;
          }
          while (head != null){
              if (last > 1){
                  pre = pre.next;
                  last--;
              }else {
                  pre.next = pre.next.next;
                  break;
              }
          }
          head.print();
          return head;
    }

    public static int length(ListNode head){
          int len = 0;
          while (head!=null){
              len++;
              head = head.next;
          }
          return len;
    }

    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        int n = 2;
        ListNode listNode = new ListNode(head[0]);
        for (int i = 1;i< head.length;i++){
            listNode.add(head[i]);
        }
        removeNthFromEnd(listNode,n);
    }

}
