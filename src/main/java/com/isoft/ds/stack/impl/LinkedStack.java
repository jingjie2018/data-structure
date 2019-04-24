package com.isoft.ds.stack.impl;

import com.isoft.ds.list.impl.LinkedList;
import com.isoft.ds.stack.Stack;

/**
 * 链栈
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> linkedList = new LinkedList<>();

    public void push(E e) {
        linkedList.add(e);
    }

    public E pop() {
        int lastIndex = linkedList.size() - 1;
        E e = linkedList.get(lastIndex);
        linkedList.delete(lastIndex);
        return e;
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public void clear() {
        linkedList.clear();
    }
}
