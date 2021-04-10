package week4;

import course.ListNode;

public class Sort_List_148 {
    public static void main(String[] args) {
        int[] array = new int[]{2, -1, 4, 9, 5, 0};
        //head可以理解为一个存放地址的变量，此时为第一个节点的地址值
        ListNode head = new ListNode(1);
        //next和head一样，此时将第一个节点的值放在next变量里保存
        ListNode next = head;
        //尾插法，next指针一直指向尾节点
        for (int i : array) {
            /*next.next表示的是next指向的节点的指针域，此时第一个节点
            的指针域存放新节点节点的地址值。
            等号左边的.next是指针域，等号右边的.next是存放的地址值*/
            next.next = new ListNode(i);
            //此时将新节点的地址值存放到next变量，即指针指向新节点
            next = next.next;
        }
//        while(head!=null){
//            System.out.println(head.val);
//            head = head.next;
//        }
        ListNode result = sortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

}
