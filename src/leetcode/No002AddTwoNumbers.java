package leetcode;

/**
 * @description:
 * @author: chengzeshan
 * @date: 2019-12-11 11:39
 */
public class No002AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode target = new ListNode(0);
        ListNode cur = target;
        boolean flag = false;
        while (l1 != null || l2 != null || flag == true) {
            if (l1 != null && l2 != null) {
                cur.next = new ListNode((l1.val + l2.val) % 10);

                if (flag == true) {
                    int temp = (cur.next.val + 1) % 10;
                    flag = false;
                    if (cur.next.val + 1 >= 10) {
                        flag = true;
                    }
                    cur.next.val = temp;
                }
                if ((l1.val + l2.val) >= 10) {
                    flag = true;
                }
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                cur.next = new ListNode(l1.val);
                if (flag == true) {
                    int temp = (cur.next.val + 1) % 10;
                    flag = false;
                    if (cur.next.val + 1 >= 10) {
                        flag = true;
                    }
                    cur.next.val = temp;
                }

                cur = cur.next;
                l1 = l1.next;
            } else if (l2 != null) {
                cur.next = new ListNode(l2.val);
                if (flag == true) {
                    int temp = (cur.next.val + 1) % 10;
                    flag = false;
                    if (cur.next.val + 1 >= 10) {
                        flag = true;
                    }
                    cur.next.val = temp;
                }

                cur = cur.next;
                l2 = l2.next;
            } else if (flag == true) {
                cur.next = new ListNode(1);
                break;
            }
        }
        return target.next;
    }
}
