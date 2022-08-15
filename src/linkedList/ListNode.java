package linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }
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
