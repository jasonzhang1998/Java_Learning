package course;

public class Reverse_Linked_List_206 {
    //将链表反转
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

        head = solution_2(head);
        System.out.println(head.val);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    //使用尾插法，重新建立一个新链表
    //时间复杂度O(n),空间复杂度O(n)
    public static ListNode solution_1(ListNode head) {
        ListNode dummy = null;
        ListNode next;
        while (head != null) {
            if (dummy == null) {
                dummy = new ListNode(head.val);
            } else {
                next = new ListNode(head.val);
                next.next = dummy;
                dummy = next;
            }
            head = head.next;
        }
        return dummy;
    }

    //使用三个指针实现链表反转
    //时间复杂度O(n),空间复杂度O(1)
    public static ListNode solution_2(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
