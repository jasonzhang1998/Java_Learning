package course;

import java.util.List;

public class Swap_Nodes_in_Pairs_24 {
    //交换链表中成对的元素，如第1、2个元素交换，第3、4个元素交换等
    //本题其实考察的是交换两个链表元素的指针操作
    public static void main(String[] args) {
        System.out.println("pku_sece_cs_cis_master_zx");
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
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
        next = solution_1(head);
        while (next != null) {
            System.out.print(next.val + " ");
            next = next.next;
        }
    }

    //由于涉及到两个节点的交换，因此需要存储这两个节点前驱和后继
    //还需存储待交换节点的地址，所以需要三个指针
    public static ListNode solution_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode next = head.next;
        ListNode prev = new ListNode();
        head = head.next;
        while (curr != null && curr.next != null) {
            next = curr.next;
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
