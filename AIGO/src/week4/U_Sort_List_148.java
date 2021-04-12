package week4;

import course.ListNode;

public class U_Sort_List_148 {
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
        ListNode result = solution_1(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode solution_1(ListNode head) {
        //如果链表为空或者只有一个元素，则直接返回头节点
        if (head == null || head.next == null)
            return head;
        //使用快慢指针找到链表的中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //tmp指向第二个链表的头节点，即链表中点
        ListNode tmp = slow.next;
        //将链表切为两段
        slow.next = null;
        //left
        ListNode left = solution_1(head);
        ListNode right = solution_1(tmp);
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
        if (left != null) {
            h.next = left;
        } else {
            h.next = right;
        }
        return res.next;
    }

}
