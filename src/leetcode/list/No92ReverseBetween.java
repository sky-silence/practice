package leetcode.list;

import java.util.List;

/**
 * 92.反转列表II
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/18
 * @since practice 1.0.0
 */
public class No92ReverseBetween {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode l = head;
        ListNode r = head;
        int flag = 1;
        ListNode pre = new ListNode();
        ListNode next = new ListNode();
        while (flag <= right){
            if (flag <= left){
                l = l.next;
            }
            if (flag <= left - 1){
                pre = pre.next;
            }
            if (flag <= right){
                r = r.next;
            }
            if (flag <= right + 1){
                next = r.next;
            }
            flag ++;
        }
        return l;
    }

    public void reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
