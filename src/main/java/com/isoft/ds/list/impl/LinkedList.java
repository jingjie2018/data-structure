package com.isoft.ds.list.impl;

import com.isoft.ds.list.List;
import com.isoft.ds.stack.Stack;
import com.isoft.ds.stack.impl.ArrayStack;

import java.util.NoSuchElementException;

/**
 * 单向链表
 *
 * @Author Jingjie
 * @Since 2019/4/20
 */
public class LinkedList<E> implements List<E> {

    // 链表长度
    private int size;

    // 链表头结点
    private Node<E> first;

    private Node<E> last;

    /**
     * 添加元素
     *
     * @param e 要添加的元素
     * @return 元素所在的位置
     */
    @Override
    public void add(E e) {
        /*Node<E> headNode = first;
        Node<E> newNode = new Node<>(e, null);
        if (headNode == null) {
            first = newNode;
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
        }*/
        final Node<E> tempLastNode = last;
        final Node<E> newNode = new Node<>(e, null);
        last = newNode;
        if (tempLastNode == null) {
            first = newNode;
        } else {
            tempLastNode.next = newNode;
        }
        size++;
    }

    /**
     * 指定位置添加元素
     *
     * @param e 要添加的元素
     * @return 元素所在的位置
     */
    public void add(int index, E e) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        Node<E> tempNode = first;
        Node<E> newNode = new Node<>(e, null);
        int i = 0;
        while (i < size && tempNode != null) {
            if (i == (index - 1)) {
                newNode.next = tempNode.next;
                tempNode.next = newNode;
                size++;
            }
            i++;
            tempNode = tempNode.next;
        }
    }

    /**
     * 删除元素
     *
     * @param e 要删除的元素
     * @return 元素所在的位置
     */
    @Override
    public void delete(E e) {
        int index = indexOf(e);
        if (index == -1) {
            throw new NoSuchElementException("NoSuchElementException...");
        }
        delete(index);
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 元素位置
     * @return 元素所在的位置
     */
    @Override
    public void delete(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        if (index == 0) {
            first = first.next;
            size--;
        }
        Node<E> tempNode = first;
        int i = 0;
        while (i < size && tempNode != null) {
            if (i == (index - 1)) {
                tempNode.next = tempNode.next.next;
                size--;
            }
            i++;
            tempNode = tempNode.next;
        }
    }

    /**
     * 查找指定元素的位置
     *
     * @param e 元素
     * @return 元素所在的位置
     */
    @Override
    public int indexOf(E e) {
        Node<E> tempNode = first;
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
    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        Node<E> tempNode = first;
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
    @Override
    public int size() {
        return size;
    }

    /**
     * 倒置
     */
    @Override
    public void reverse() {
        //栈实现
        Stack<E> arrayStack = new ArrayStack<>(size);
        for (int i = 0; i < size; i++) {
            E e = get(i);
            arrayStack.push(e);
        }

        clear();

        int size = arrayStack.size();
        for (int i = 0; i < size; i++) {
            E e = arrayStack.pop();
            add(e);
        }
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.element = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
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
