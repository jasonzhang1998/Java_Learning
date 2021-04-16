package course;

import java.util.List;

public class Linked_List_Cycle_141 {
    //判断链表是否有环
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = null;
        ListNode next = null;
        for (int i : array) {
            if (head == null) {
                head = new ListNode(i);
                next = head;
            } else {
                next.next = new ListNode(i);
                next = next.next;
            }
        }
//        next.next = head.next;
        System.out.println(solution_1(head));
    }

    //快慢指针法，如果有环则两个指针必定会重合
    //时间复杂度O（n），空间复杂度O（1）
    public static boolean solution_1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
