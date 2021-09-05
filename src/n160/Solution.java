/*
 * Cainiao.com Inc.
 * Copyright (c) 2013-2021 All Rights Reserved.
 */

package n160;

/**
 * @author suwenguang
 * @since 2021-09-05 14:30
 */
public class Solution {

    public static void main(String[] args) {
        ListNode headA = new ListNode(8);
        System.out.println(getIntersectionNode(headA, headA));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode pa= headA;
        while (pa != null){
            ListNode pb = headB;
            while (pb != null){
                if (pa == pb){
                    return pa;
                }
                pb = pb.next;
            }
            pa = pa.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }
}


