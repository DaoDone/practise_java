package com.adjiang.practise.arithmetic.linkedList_tag;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 基于链表实现LRUCache
 * @author jianad001
 * @date 2021/9/20
 */
public class LRUCacheII extends LinkedHashMap<Integer, Integer> {

    int capacity;

    LRUCacheII(int capcity){
        super(capcity);
        this.capacity =capcity;
    }


    public int get(int key) {
     return   super.getOrDefault(key, -1);
}

    public int put(int key,int value) {
        return   super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()> capacity;
    }
}
