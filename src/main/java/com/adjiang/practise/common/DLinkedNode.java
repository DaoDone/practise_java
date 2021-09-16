package com.adjiang.practise.common;


/**
 * 双向链表结构
 * @author jianad001
 * @date 2021/9/17
 */
public class DLinkedNode {


    public int k;
    public int v;
    public DLinkedNode next;
    public DLinkedNode prev;

    public DLinkedNode(int k, int v) {
        this.k = k;
        this.v = v;
    }

    public DLinkedNode() {

    }
}
