package com.adjiang.practise.arithmetic;

import com.adjiang.practise.common.ListNode;

/**
 * @author jianad001
 * @date 2021/9/16
 */
public class leetCode_19_removeNthFromEnd {

    /**
     * 方法一；先走完一个一遍链表得链表长度
     * 在移动指针到n-1的节点
     * 跳过n-1.next节点（移除节点）
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1, head);
        int length = getLenght(head);
        ListNode curr = dummyNode;
        for (int i = 1; i < length - n + 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummyNode.next;

    }

    //获取链表长度
    int getLenght(ListNode head) {
        int lenght = 0;
        while (head != null) {
            lenght++;
            head = head.next;
        }
        return lenght;
    }

    /**
     * 方法二：快慢指针
     *  快指针先走到n的位置
     *  慢指针开始走，等到快指针走到链表尾端后
     *  慢指针所处的位置刚好是n-1的节点位置，因为慢指针是从虚拟节点开始走的
     * 左指针和右指针保持距离n
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode low = dummyNode, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            low = low.next;
            fast = fast.next;
        }
        low.next = low.next.next;
        return dummyNode.next;
    }
}
