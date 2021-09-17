package com.adjiang.practise.arithmetic.linkedList_tag;

import com.adjiang.practise.common.ListNode;

/**
 * 题目：两两交换链表节点
 * @author jianad001
 * @date 2021/9/17
 */
public class leetCode_24_swapPairs {


    /**
     * 方法一
     * 思路：设置虚拟节点，临时变量初始化 tmp 指向虚拟节点
     * 两两交换就是交换 tmp.next tmp.next.next
     * 步骤如下：
     * 1：tmp.prev.next -->tmp.next.next
     * 2：tmp.next.next-->tmp.next
     * 3、tmp.next --> tmp.next.next.next
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode tmp = dummyNode;
        //tmp.next tmp.next.next 不为空时进行节点交换
        while (tmp.next != null && tmp.next.next != null) {
            ListNode node = tmp.next;
            ListNode node1 = tmp.next.next;
            //这一步很关键，tmp.prev.next -->tmp.next.next
            tmp.next = node1;
            //tmp.next --> tmp.next.next.next
            node.next = node1.next;
            //tmp.next.next-->tmp.next
            node1.next = node;
            tmp = node;
        }
        return dummyNode.next;
    }

    /**
     * 方法二：递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;
        one.next = swapPairs2(three);
        return two;
    }

}
