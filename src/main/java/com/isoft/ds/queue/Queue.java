package com.isoft.ds.queue;

/**
 * 队列
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public interface Queue<E> {

    void add(E e);

    E poll();
}
