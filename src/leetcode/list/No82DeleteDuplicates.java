package leetcode.list;

/**
 * 82.删除排序链表中的重复元素II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/26
 * @since practice 1.0.0
 */
public class No82DeleteDuplicates {
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
                while (cur.next != null && cur.next.val == x){
                    cur.next =  cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        return dumpNode.next;
    }
}
