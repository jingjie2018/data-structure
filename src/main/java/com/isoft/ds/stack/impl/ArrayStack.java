package com.isoft.ds.stack.impl;

import com.isoft.ds.list.impl.ArrayList;
import com.isoft.ds.stack.Stack;

/**
 * 顺序栈
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> arrayList;

    public ArrayStack() {
        this.arrayList = new ArrayList<>();
    }

    public ArrayStack(int capacity) {
        this.arrayList = new ArrayList<>(capacity);
    }

    public void push(E e) {
        arrayList.add(e);
    }

    public E pop() {
        int lastIndex = arrayList.size() - 1;
        E lastElement = arrayList.get(lastIndex);
        arrayList.delete(lastIndex);
        return lastElement;
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
