package com.isoft.ds.list;

import java.util.NoSuchElementException;

/**
 * 单向链表
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public class LinkedList<E> {

    // 链表长度
    private int size;

    // 链表头结点
    private Node<E> head;

    /**
     * 添加元素
     *
     * @param e 要添加的元素
     * @return 元素所在的位置
     */
    public int add(E e) {
        Node<E> headNode = head;
        Node<E> newNode = new Node<>(e, null);
        if (headNode == null) {
            head = newNode;
        } else {
            Node tempNode = headNode.next;
            if (tempNode == null) {
                headNode.next = newNode;
            } else {
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                }
                tempNode.next = newNode;
            }
        }
        size++;
        return size - 1;
    }

    /**
     * 指定位置添加元素
     *
     * @param e 要添加的元素
     * @return 元素所在的位置
     */
    public int add(int index, E e) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        Node<E> tempNode = head;
        Node<E> newNode = new Node<>(e, null);
        int i = 0;
        while (i < size && tempNode != null) {
            if (i == (index - 1)) {
                newNode.next = tempNode.next;
                tempNode.next = newNode;
                size++;
                return index;
            }
            i++;
            tempNode = tempNode.next;
        }
        return -1;
    }

    /**
     * 删除元素
     *
     * @param e 要删除的元素
     * @return 元素所在的位置
     */
    public int delete(E e) {
        int index = indexOf(e);
        if (index == -1) {
            throw new NoSuchElementException("NoSuchElementException...");
        }
        return delete(index);
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 元素位置
     * @return 元素所在的位置
     */
    public int delete(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        Node<E> tempNode = head;
        int i = 0;
        while (i < size && tempNode != null) {
            if (i == (index - 1)) {
                tempNode.next = tempNode.next.next;
                size--;
                return index;
            }
            i++;
            tempNode = tempNode.next;
        }
        return -1;
    }

    /**
     * 查找指定元素的位置
     *
     * @param e 元素
     * @return 元素所在的位置
     */
    public int indexOf(E e) {
        Node<E> tempNode = head;
        int i = 0;
        while (i < size && tempNode != null) {
            if (tempNode.element.equals(e)) {
                return i;
            }
            i++;
            tempNode = tempNode.next;
        }
        return -1;
    }

    /**
     * 根据位置获取元素
     *
     * @param index 元素位置
     * @return 元素
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        Node<E> tempNode = head;
        int i = 0;
        while (i < size && tempNode != null) {
            if (i == index) {
                return tempNode.element;
            }
            i++;
            tempNode = tempNode.next;
        }
        return null;
    }

    /**
     * 获取链表长度
     *
     * @return 链表长度
     */
    public int size() {
        return size;
    }

    /**
     * 链表结点
     *
     * @param <E>
     */
    private static class Node<E> {

        E element;
        Node next;

        public Node() {
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
