package com.adjiang.practise.arithmetic.linkedList_tag.easy;

import com.adjiang.practise.common.ListNode;

/**
 * 思路：双指针：prev，curr指针相差一步
 * @author jianad001
 * @date 2021/9/23
 */
public class leetcode_203_reomoveElement {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        ListNode curr = dummyNode.next;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            }else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummyNode.next;
    }
}
