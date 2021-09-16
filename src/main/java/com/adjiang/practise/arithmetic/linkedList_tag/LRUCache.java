//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
//
//
// 实现 LRUCache 类：
//
//
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//
//
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10000
// 0 <= value <= 105
// 最多调用 2 * 105 次 get 和 put
//
// Related Topics 设计 哈希表 链表 双向链表
// 👍 1622 👎 0

package com.adjiang.practise.arithmetic.linkedList_tag;

import com.adjiang.practise.common.DLinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心思路：
 * 利用头，尾，两个固定虚拟节点
 * 利用头尾节点能精确规避空指针情况
 */
class LRUCache {
    private DLinkedNode tail;
    private DLinkedNode head;

    private int capacity;
    private int size;
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail = new DLinkedNode();
        head = new DLinkedNode();
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.v;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            //添加节点到到头部先，并用map缓存起来
            addToHead(node);
            cache.put(key, node);
            //如果添加的元素导致容量溢出
            if (++size > capacity) {
                //移除最少使用的尾部节点,并从cache移除，oldTailPrev 是被移除的尾部节点
                DLinkedNode oldTailPrev = removeTail();
                cache.remove(oldTailPrev.k);
                //并且size要减一，精确保持元素个数
                size--;
            }
            cache.put(key, node);
        } else {
            node.v = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 把元素移动到头部
     * 1、先删除原来节点所在位
     * 2、把节点添加到头部
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 超级重点
     * @return
     */
    private DLinkedNode removeTail() {
        //先取出最后一个节点
        DLinkedNode res = tail.prev;
        //然后做节点删除
        removeNode(res);
        return res;
    }


}
