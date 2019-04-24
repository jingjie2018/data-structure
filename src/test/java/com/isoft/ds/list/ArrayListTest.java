package com.isoft.ds.list;

import com.isoft.ds.list.impl.ArrayList;
import org.junit.Test;


/**
 * 顺序结构线性表测试
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public class ArrayListTest {

    @Test
    public void test() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(33);
        arrayList.add(44);
        arrayList.add(55);
        arrayList.add(2, 66);
        System.out.println("size:" + arrayList.size());
        print(arrayList);
        System.out.println("**************");
        arrayList.delete(0);
        print(arrayList);
        System.out.println("**************");
        Integer del = 66;
        arrayList.delete(del);
        print(arrayList);
    }

    private void print(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }


    @Test
    public void test2() {
        long time1 = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }
        arrayList.reverse();
        print(arrayList);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        System.out.println(System.currentTimeMillis() - time2);
    }
}
