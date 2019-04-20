package com.isoft.ds.list;

import org.junit.Test;

/**
 * 顺序结构线性表测试
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public class ArrayListTest {

    @Test
    public void test() {
        ArrayList<Integer> arrayList = new ArrayList<>();
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

    private void print(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
