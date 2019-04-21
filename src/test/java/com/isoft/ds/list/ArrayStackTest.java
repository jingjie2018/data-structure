package com.isoft.ds.list;

import com.isoft.ds.stack.Stack;
import com.isoft.ds.stack.impl.ArrayStack;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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


    @Test
    public void test2() {
        String s = "33+2+{3*[2*(5+3)]+(1+2)+[5*(9+7)]+(2+3)}(3+2)";
        List<String> left = Arrays.asList("{", "[", "(");
        List<String> right = Arrays.asList("}", "]", ")");
        Stack<String> stack = new ArrayStack<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                String charStr = s.charAt(i) + "";
                stack.push(charStr);
                int count = 0;
                while (right.contains(charStr) && !get(charStr).equals(stack.pop())) {
                    count++;
                }
                if (count < 3 && count > 0) {
                    System.out.println("非法运算。");
                    return;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("非法运算。");
            return;
        }
        int i = 0;
        while (i < stack.size()) {
            if (left.contains(stack.pop())) {
                System.out.println("非法运算。");
                return;
            }
            i++;
        }
        System.out.println("合法运算。");
    }

    private String get(String input) {
        String s;
        switch (input) {
            case ")":
                s = "(";
                break;
            case "]":
                s = "[";
                break;
            case "}":
                s = "{";
                break;
            default:
                s = null;
                break;
        }
        return s;
    }
}
