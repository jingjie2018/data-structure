package com.isoft.ds.algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 查找算法
 *
 * @author Jingjie
 * @since 2019/4/22
 */
public class SearchAlgorithm {

    private List<Integer> list;

    @Before
    public void init() {
        list = new ArrayList<>(Arrays.asList(99, 32, 73, 12, 26, 65, 18, 89, 43, 67, 51));
    }

    @Test
    public void orderSearch() {
        int searchNum = 89;
        for (int i = 0; i < list.size(); i++) {
            Integer num = list.get(i);
            if (searchNum == num) {
                System.out.println("第" + (i + 1) + "个数为：" + searchNum);
            }
        }
    }

    @Test
    public void binarySearch() {
        Collections.sort(list);
        int searchNum = 99;
        int start = 0;
        int end = list.size() - 1;
        int mid = (start + end) / 2;
        int count = 0;
        while (start <= end) {
            count++;
            if (searchNum == list.get(mid)) {
                System.out.println("第" + count + "查找，找到：" + searchNum);
                break;
            }
            if (searchNum < list.get(mid)) {
                end = mid - 1;
            }
            if (searchNum > list.get(mid)) {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
    }
}
