package com.isoft.ds.queue.impl;

import com.isoft.ds.list.impl.ArrayList;
import com.isoft.ds.queue.Queue;

/**
 * 顺序队列
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> arrayList = new ArrayList<>();

    @Override
    public void add(E e) {
        arrayList.add(e);
    }

    @Override
    public E poll() {
        E e = arrayList.get(0);
        arrayList.delete(0);
        return e;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public void clear() {
        arrayList.clear();
    }
}
