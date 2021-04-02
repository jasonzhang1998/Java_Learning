package course;

public class Reverse_Linked_List_206 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        ListNode head = null;
        ListNode next = null;
        for(int i:array){
            if(head==null){
                head = new ListNode(i);
                next = head;
            }else{
                next.next = new ListNode(i);
                next = next.next;
            }
        }

        head = solution_1(head);
        System.out.println(head.val);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode solution_1(ListNode head){
        ListNode dummy = null;
        ListNode next;
        while(head!=null){
            if(dummy==null){
                dummy = new ListNode(head.val);
            }else{
                next = new ListNode(head.val);
                next.next = dummy;
                dummy = next;
            }
            head = head.next;
        }
        return dummy;
    }
}
