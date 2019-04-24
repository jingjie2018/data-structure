package com.isoft.ds.list;

import com.isoft.ds.list.impl.LinkedList;
import org.junit.Before;
import org.junit.Test;


/**
 * 链表测试
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public class LinkedListTest {

    List<Integer> linkedList = new LinkedList<>();

    @Before
    public void testAdd() {
        // add(e)
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);

        // add(index,e)
        linkedList.add(1, 44);

        print(linkedList);
        System.out.println("***********************");
    }


    @Test
    public void testIndexOf() {
        // indexOf(e)
        System.out.println(linkedList.indexOf(44));
        System.out.println(linkedList.indexOf(55));
    }

    @Test
    public void testDelete() {
        //delete(index)
        linkedList.delete(1);

        //delete(e)
        Integer delEle = 22;
        linkedList.delete(delEle);

        print(linkedList);
    }

    @Test
    public void testGet() {
        print(linkedList);
    }

    @Test
    public void testReverse() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.reverse();
        print(list);
    }

    @Test
    public void testTime() {
        long time1 = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        //print(linkedList);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        java.util.List<Integer> list = new java.util.LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        System.out.println(System.currentTimeMillis() - time2);
    }

    private void print(List<Integer> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
