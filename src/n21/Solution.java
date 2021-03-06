package n21;

/**
 * description:
 * @author suwenguang
 * @date 2019/6/19
 * @version 1.0.0
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);

        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);

        ListNode res = solution.mergeTwoLists(l1,l2);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }

    /**
     * 21. 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //递归写法,先写边界条件
        if (l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }
        else if (l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
