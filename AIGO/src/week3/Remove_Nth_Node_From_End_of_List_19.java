package week3;


public class Remove_Nth_Node_From_End_of_List_19 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4};
        //head可以理解为一个存放地址的变量，此时为第一个节点的地址值
        ListNode head = new ListNode(1);
        //next和head一样，此时将第一个节点的值放在next变量里保存
        ListNode next = head;
        //尾插法，next指针一直指向尾节点
        for (int i : array) {
            /*next.next表示的是next指向的节点的指针域，此时第一个节点
            的指针域存放新节点节点的地址值。
            等号左边的.next是指针域，等号右边的.next是存放的地址值*/
            System.out.println(next.val);
            next.next = new ListNode(i);
            //此时将新节点的地址值存放到next变量，即指针指向新节点
            next = next.next;
        }
        System.out.println(next.val);
        System.out.println("============");
        headInsert();
//        while(head!=null){
//            System.out.println(head.val);
//            head = head.next;
//        }
//        System.out.println(head.val);
//        head = solution_1(head, 2);
    }

    //头插法：将新节点每次都插在链表的表头，需要一个一直指向头节点的指针；
    public static void headInsert() {
        int[] array = new int[]{5, 6, 7, 8};
        ListNode head, next;
        head = null;
        next = null;
        for (int i : array) {
            if (head == null) {
                head = new ListNode(i);
            } else {
                next = new ListNode(i);
                next.next = head;
                head = next;
            }
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /*
    双指针法，两个指针之间的距离为n，当前一个指针指向尾节
    点时，后一个指针指向被删除节点的前驱节点
    */
    public static ListNode solution_1(ListNode head, int n) {
        //新建一个一个虚拟头节点，作为头节点的前驱
        ListNode dummy = new ListNode(0, head);
        //first指向头节点
        ListNode first = head;
        //second指向虚拟头节点
        ListNode second = dummy;
        //first后移n位
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        /*first一直后移到为空，此时second在first前面n+1位，刚好
        指向待删除节点的前驱节点*/
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        //删除待删除节点
        second.next = second.next.next;
        //返回虚拟头节点的后继节点，即此时的头节点
        ListNode ans = dummy.next;
        return ans;
    }
}
