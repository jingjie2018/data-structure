package com.isoft.ds.list;

import com.isoft.ds.stack.Stack;
import com.isoft.ds.stack.impl.ArrayStack;
import org.junit.Test;

/**
 * 顺序栈测试
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public class ArrayStackTest {

    @Test
    public void test() {
        Stack<Integer> arrayStack = new ArrayStack<>();

        arrayStack.push(11);
        arrayStack.push(22);
        arrayStack.push(33);
        arrayStack.push(44);

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
