package com.isoft.ds.list;

import com.isoft.ds.queue.Queue;
import com.isoft.ds.queue.impl.ArrayQueue;
import org.junit.Test;

/**
 * 顺序队列
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public class ArrayQueueTest {

    @Test
    public void test() {
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.add(11);
        arrayQueue.add(22);
        arrayQueue.add(33);
        arrayQueue.add(44);

        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
    }
}
