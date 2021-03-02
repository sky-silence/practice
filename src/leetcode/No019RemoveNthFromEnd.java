package leetcode;

/**
 * @description:
 * @author: chengzeshan
 * @date: 2019-12-11 11:06
 */
public class No019RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode target = new ListNode(0);
        target.next = head;
        ListNode first = target;
        ListNode second = target;
        for(int i = 0 ; i < n ; i ++){
            first = first.next;
        }
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return target.next;
    }
}
