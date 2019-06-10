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

//todo:边界溢出

// [9]
//[1,9,9,9,9,9,9,9,9,9]

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        //基本测试
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(2);

        //边界溢出测试
        //solution.long2ListNode(9999999991)


        ListNode l3 = solution.addTwoNumbersFail(l1, l2);

        while (l3 != null) {
            System.out.printf(String.valueOf(l3.val));
            l3 = l3.next;
        }
    }


    @Deprecated
    public ListNode addTwoNumbersFail(ListNode l1, ListNode l2) {
        //参数校验
        if (l1 == null || l2 == null) {
            return null;
        }
        if (l1.val < 0 || l2.val < 0) {
            return null;
        }
        //将链表转为整数
        long a = listNode2Long(l1);
        long b = listNode2Long(l2);

        //相加
        long res = a + b;

        //结果转链表返回
        ListNode head = long2ListNode(res);

        return head.next;
    }

    private long listNode2Long(ListNode l2) {
        int i = 1;
        long res = 0;
        ListNode tempNode;
        tempNode = l2;
        while (tempNode != null) {
            res = res + (tempNode.val * i);
            tempNode = tempNode.next;
            i *= 10;
        }
        return res;
    }

    /**
     * 说明: int 转 ListNode
     * @author suwenguang
     * @date 2019/6/10
     * @return n2.ListNode <- 返回类型
     */
    private ListNode long2ListNode(long res) {
        ListNode tempNode;
        long temp = 11;

        ListNode head = new ListNode(-1);
        tempNode = head;

        while (res / 10 > 0) {
            temp = res % 10;
            ListNode next = new ListNode((int) temp);
            tempNode.next = next;
            tempNode = next;
            res /= 10;
        }
        ListNode end = new ListNode((int) res);
        tempNode.next = end;
        return head;
    }
}
