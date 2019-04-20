package com.isoft.ds.list;

import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * 链表测试
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public class LinkedListTest {


    @Test
    public void test() {
        // add(e)
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList.add(11));
        System.out.println(linkedList.add(22));
        System.out.println(linkedList.add(33));

        // add(index,e)
        System.out.println(linkedList.add(1, 44));

        // indexOf(e)
        System.out.println(linkedList.indexOf(44));

        //delete(index)
//        System.out.println(linkedList.delete(1));

        //delete(e)
        Integer delEle = 22;
//        linkedList.delete(delEle);

        //get(index)
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }

    @Test
    public void test2() {
        long time1 = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
//        print(linkedList);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        List<Integer> list = new java.util.LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        System.out.println(System.currentTimeMillis() - time2);
    }

    private void print(LinkedList<Integer> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
