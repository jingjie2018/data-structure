package com.isoft.ds.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 排序算法
 *
 * @author Jingjie
 * @since 2019/4/22
 */
public class SortAlgorithm {


    private List<Integer> list;

    @Before
    public void init() {
        list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            list.add(random.nextInt(100000));
        }
    }

    @Test
    public void testSort() {
        long time1 = System.currentTimeMillis();
        Collections.sort(list);
        System.out.println(System.currentTimeMillis() - time1);
        System.out.println(list);
    }

    /**
     * 插入排序
     */
    @Test
    public void insertSort() {
        long time1 = System.currentTimeMillis();
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > temp) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, temp);
        }
        System.out.println(System.currentTimeMillis() - time1);
        System.out.println(list);
    }

    /**
     * 希尔排序
     */
    @Test
    public void shellSort() {
        long time1 = System.currentTimeMillis();
        for (int increment = list.size() / 8; increment >= 1; increment /= 2) {
            for (int i = increment; i < list.size(); i++) {
                int temp = list.get(i);
                int j = i - increment;
                while (j >= 0 && list.get(j) > temp) {
                    list.set(j + increment, list.get(j));
                    j -= increment;
                }
                list.set(j + increment, temp);
            }
        }
        System.out.println(System.currentTimeMillis() - time1);

        System.out.println(list.size());
        System.out.println(list);
    }

    /**
     * 选择排序
     */
    @Test
    public void selectSort() {
        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    Integer temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(list);
    }

    /**
     * 归并排序
     */
    @Test
    public void mergeSort() {

    }

    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSort() {
        System.out.println(list);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j + 1) < list.get(j)) {
                    Integer temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - time1);
        System.out.println(list);
    }

    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSort2() {
        System.out.println(list);
        long time1 = System.currentTimeMillis();
        int index = list.size() - 1;
        for (int i = 0; i < list.size() - 1; i++) {
            int lastSwapIndex = 0;
            for (int j = 0; j < index; j++) {
                if (list.get(j + 1) < list.get(j)) {
                    Integer temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                    lastSwapIndex = j;
                }
            }
            index = lastSwapIndex;
        }
        System.out.println(System.currentTimeMillis() - time1);
        System.out.println(list);
    }

    /**
     * 基于链表基数排序
     */
    @Test
    public void baseSortByLink() {
    }

    /**
     * 基于顺序存储结构的基数排序
     */
    @Test
    public void baseSortByArray() {

    }

    /**
     * 外部排序
     */
    @Test
    public void outMemorySort() {

    }
}
