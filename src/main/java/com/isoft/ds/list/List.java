package com.isoft.ds.list;

/**
 * 线性表
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public interface List<E> {

    /**
     * 在表尾添加元素
     *
     * @param e 元素
     */
    void add(E e);

    /**
     * 在指定的位置插入元素
     *
     * @param index 指定的位置
     * @param e     要插入的元素
     */
    void add(int index, E e);

    /**
     * 获取指定位置的元素
     *
     * @param index 元素位置
     * @return 元素
     */
    E get(int index);

    /**
     * 获取某个指定元素的位置
     *
     * @param e 要查询的元素
     * @return 该元素在线性表中的位置
     */
    int indexOf(E e);

    /**
     * 删除指定位置的元素
     *
     * @param index 要删除元素的位置
     */
    void delete(int index);

    /**
     * 删除指定元素
     *
     * @param e 要删除的元素
     */
    void delete(E e);

    /**
     * 倒置
     */
    void reverse();

    /**
     * 线性表长度
     *
     * @return 线性表长度
     */
    int size();
}
