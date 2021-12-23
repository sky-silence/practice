package leetcode.list;

/**
 * 83.删除排序链表中的重复元素I
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * @author chengzeshan
 * @version 1.0, 2021/03/26
 * @since practice 1.0.0
 */
public class No83DeleteDuplicates {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpNode = new ListNode(0,head);
        ListNode cur = dumpNode;
        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next.next != null && cur.next.next.val == x){
                    cur.next.next = cur.next.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dumpNode.next;
    }

}
