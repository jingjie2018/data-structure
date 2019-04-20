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

        linkedStack.push(11);
        linkedStack.push(22);
        linkedStack.push(33);
        linkedStack.push(44);

        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
    }
}
