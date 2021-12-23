package leetcode.list;

/**
 * 141.环形链表
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/29
 * @since practice 1.0.0
 */
public class No141HasCycle {
    private class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null ||head.next == null || head.next.next ==null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (true){
            if (fast == null || fast.next == null){
                return false;
            }
            if (fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
    }
}
