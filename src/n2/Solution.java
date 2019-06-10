package n2;

/**
 * description:
 * @author suwenguang
 * @date 2019/6/10
 * @version 1.0.0
 **/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(2);

        ListNode l3 = solution.addTwoNumbers(l1, l2);

        while (l3 != null) {
            System.out.printf(String.valueOf(l3.val));
            l3 = l3.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //参数校验
        if (l1 == null || l2 == null) {
            return null;
        }
        if (l1.val < 0 || l2.val < 0) {
            return null;
        }
        //将链表转为整数
        int a = 0;
        int b = 0;
        int i = 1;
        ListNode tempNode;
        tempNode = l1;
        while (tempNode != null) {
            a = a + (tempNode.val * i);
            tempNode = tempNode.next;
            i *= 10;
        }
        i = 1;
        tempNode = l2;
        while (tempNode != null) {
            b = b + (tempNode.val * i);
            tempNode = tempNode.next;
            i *= 10;
        }

        //相加
        int res = a + b;

        //结果转链表返回
        i = 10;
        int temp = 11;

        ListNode head = new ListNode(-1);
        tempNode = head;

        while (res / 10 > 0) {
            temp = res % 10;
            ListNode next = new ListNode(temp);
            tempNode.next = next;
            tempNode = next;
            res /= 10;
        }
        ListNode end = new ListNode(res);
        tempNode.next = end;

        return head.next;
    }
}
