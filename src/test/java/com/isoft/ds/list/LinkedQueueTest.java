package com.isoft.ds.list;

import com.isoft.ds.queue.Queue;
import com.isoft.ds.queue.impl.LinkedQueue;
import org.junit.Test;

/**
 * 链式队列测试
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public class LinkedQueueTest {

    @Test
    public void test() {
        Queue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.add(11);
        linkedQueue.add(22);
        linkedQueue.add(33);
        linkedQueue.add(44);

        System.out.println(linkedQueue.poll());
        System.out.println(linkedQueue.poll());
        System.out.println(linkedQueue.poll());
        System.out.println(linkedQueue.poll());
    }
}
