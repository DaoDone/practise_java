package com.adjiang.practise.arithmetic.linkedList_tag;


import com.adjiang.practise.common.ListNode;

/**
 * diffculty:Medium
 * Related Topics 递归 链表
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * @author jianad001
 * @date 2021/9/12
 */
public class leetcode_92_ReverseListII {


    /**
     * 思路：记录遍历前一个的指针位置和遍历后一个指针位置
     * 然后将反转后的链表重新连起来
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //设置一个虚拟节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        //保证 prev 移动到 left -1 的位置
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        //将rightNode移动到right+1的位置
        ListNode rightNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //切断链表
        ListNode leftNode = prev.next;
        ListNode curr = rightNode.next;
        prev.next = null;
        rightNode.next = null;
        //进行链表翻转
        reverseList1(leftNode);
        //重新拼接链表
        prev.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    public static ListNode reverseList1(ListNode head) {
        //初始化两个指针，prev指向前一个节点 curr指向当前节
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }


    /**
     * 方法二 一次遍历（穿针引线），头插法
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        //先利用虚拟节点，让node来到left-1节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyNode.next;
    }

    // 测试
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode res = reverseBetween2(n1, 2, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}

