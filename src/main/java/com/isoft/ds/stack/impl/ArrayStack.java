package com.isoft.ds.stack.impl;

import com.isoft.ds.list.impl.ArrayList;
import com.isoft.ds.stack.Stack;

/**
 * 顺序栈
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> arrayList = new ArrayList<>();

    public void push(E e) {
        arrayList.add(e);
    }

    public E pop() {
        int lastIndex = arrayList.size() - 1;
        E lastElement = arrayList.get(lastIndex);
        arrayList.delete(lastIndex);
        return lastElement;
    }
}
