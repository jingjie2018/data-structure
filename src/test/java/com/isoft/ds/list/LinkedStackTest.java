package com.isoft.ds.list;

import com.isoft.ds.stack.Stack;
import com.isoft.ds.stack.impl.LinkedStack;
import org.junit.Test;

/**
 * 链栈测试
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public class LinkedStackTest {

    @Test
    public void test() {
        Stack<Integer> linkedStack = new LinkedStack<>();

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            linkedStack.push(i);
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println(linkedStack.pop());
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
