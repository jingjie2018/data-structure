package com.isoft.ds.stack;

/**
 * 栈
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    int size();

    void clear();
}
