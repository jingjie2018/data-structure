package com.isoft.ds.queue.impl;

import com.isoft.ds.list.impl.LinkedList;
import com.isoft.ds.queue.Queue;

/**
 * 队列（链式）
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public class LinkedQueue<E> implements Queue<E> {

    private LinkedList<E> linkedList = new LinkedList<>();

    public void add(E e) {
        linkedList.add(e);
    }

    public E poll() {
        E e = linkedList.get(0);
        linkedList.delete(0);
        return e;
    }
}
