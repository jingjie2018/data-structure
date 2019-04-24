package com.isoft.ds.list.impl;

import com.isoft.ds.list.List;

/**
 * 顺序结构线性表
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public class ArrayList<E> implements List<E> {

    private int size;

    private Object[] elementArray;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this.elementArray = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0 || initialCapacity >= Integer.MAX_VALUE - 8) {
            throw new IllegalArgumentException("Illegal initialCapacity");
        }
        this.elementArray = new Object[initialCapacity];
    }

    /**
     * 在表尾添加元素
     *
     * @param e 元素
     */
    public void add(E e) {
        if (size >= this.elementArray.length) {
            extensionArray();
        }
        elementArray[size++] = e;
    }

    /**
     * 在指定的位置插入元素
     *
     * @param index 指定的位置
     * @param e     要插入的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        if (size >= this.elementArray.length) {
            extensionArray();
        }
        for (int i = size - 1; i >= index; i--) {
            elementArray[i + 1] = elementArray[i];
        }
        elementArray[index] = e;
        size++;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 元素位置
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        return (E) this.elementArray[index];
    }

    /**
     * 获取某个指定元素的位置
     *
     * @param e 要查询的元素
     * @return 该元素在线性表中的位置
     */
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            Object obj = this.elementArray[i];
            if (obj.equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 要删除元素的位置
     */
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        for (int i = index; i < size - 1; i++) {
            this.elementArray[i] = this.elementArray[i + 1];
        }
        this.elementArray[--size] = null;
    }

    /**
     * 删除指定元素
     *
     * @param e 要删除的元素
     */
    public void delete(E e) {
        int index = indexOf(e);
        delete(index);
    }

    /**
     * 倒置
     */
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            Object temp = this.elementArray[i];
            this.elementArray[i] = this.elementArray[size - 1 - i];
            this.elementArray[size - 1 - i] = temp;
        }
    }

    @Override
    public void clear() {
        for (Object element : elementArray) {
            element = null;
        }
        size = 0;
    }

    /**
     * 线性表长度
     *
     * @return 线性表长度
     */
    public int size() {
        return size;
    }

    /**
     * 数组扩容
     */
    private void extensionArray() {
        //扩容策略：原始容量翻倍
        Object[] newArray = new Object[size * 2];
        System.arraycopy(this.elementArray, 0, newArray, 0, size);
        this.elementArray = newArray;
    }
}
