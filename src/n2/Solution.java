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
        ListNode l3 = solution.addTwoNumbers(solution.long2ListNode(342), solution.long2ListNode(465));
        sout(l3);

        //特殊:单链表
        l3 = solution.addTwoNumbers(solution.long2ListNode(619), solution.long2ListNode(0));
        sout(l3);
        //特殊:边界进位
        l3 = solution.addTwoNumbers(solution.long2ListNode(5), solution.long2ListNode(5));
        sout(l3);

        l3 = solution.addTwoNumbers(solution.long2ListNode(1), solution.long2ListNode(99));
        sout(l3);
    }

    private static void sout(ListNode l3) {
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
        System.out.println("---------");
    }

    /**
     * 说明: 使用进位
     * @author  suwenguang
     * @date    2019/6/10
     * @return  n2.ListNode <- 返回类型
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //参数校验
        if (l1 == null || l2 == null) {
            return null;
        }
        if (l1.val < 0 || l2.val < 0) {
            return null;
        }
        //主逻辑
        //进位链表
        ListNode carrier = new ListNode(0);
        //结果链表
        ListNode res = new ListNode(0);
        //临时链表
        ListNode temp =res;

        while (l1!=null && l2!=null){
            //相加进位
            int val = l1.val + l2.val+ carrier.val;
            if (val>=10){
                carrier.next = new ListNode(1);
            }else {
                carrier.next=new ListNode(0);
            }
            //赋值res
            int remain = val % 10;
            temp.next=new ListNode(remain);

            //指针移动
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
            carrier=carrier.next;
        }
        while (l1!=null){
            int val = carrier.val + l1.val;
            if (val>=10){
                carrier.next=new ListNode(1);
            }else {
                carrier.next=new ListNode(0);
            }

            //赋值
            int remain = val % 10;
            temp.next=new ListNode(remain);

            //指针移动
            l1=l1.next;
            carrier=carrier.next;
            temp=temp.next;

        }
        while (l2!=null){
            int val = carrier.val + l2.val;
            if (val>=10){
                carrier.next=new ListNode(1);
            }else {
                carrier.next=new ListNode(0);
            }

            //赋值
            int remain = val % 10;
            temp.next=new ListNode(remain);

            //指针移动
            l2=l2.next;
            carrier=carrier.next;
            temp=temp.next;

        }

        //判定是否还有进位
        if (carrier.val==1){
            temp.next=new ListNode(1);
        }

        return res.next;
    }

    /**
     * 说明:暴力破解
     * @author  suwenguang
     * @date    2019/6/10
     * @return  n2.ListNode <- 返回类型
     */
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

    /**
     * 说明:  ListNode 转 long
     * @author  suwenguang
     * @date    2019/6/10
     * @return  long <- 返回类型
     */
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
     * 说明: long 转 ListNode
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
        return head.next;
    }
}
