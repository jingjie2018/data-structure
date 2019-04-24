package com.isoft.ds.queue;

/**
 * 队列
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public interface Queue<E> {

    void add(E e);

    E poll();

    int size();

    void clear();
}
