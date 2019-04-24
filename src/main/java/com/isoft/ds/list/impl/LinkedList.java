package com.isoft.ds.list.impl;

import com.isoft.ds.list.List;
import com.isoft.ds.stack.Stack;
import com.isoft.ds.stack.impl.ArrayStack;

import java.util.NoSuchElementException;

/**
 * 单向链表
 *
 * @author Jingjie
 * @since 2019/4/20
 */
public class LinkedList<E> implements List<E> {

    // 链表长度
    private int size;

    // 链表头结点
    private Node<E> first;

    // 链表尾结点
    private Node<E> last;

    /**
     * 添加元素
     *
     * @param e 要添加的元素
     * @return 元素所在的位置
     */
    @Override
    public void add(E e) {
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
        if (index == 0) {
            first = newNode;
            newNode.next = tempNode;
        } else {
            Node<E> preNode = getNodeByIndex(index - 1);
            newNode.next = preNode.next;
            preNode.next = newNode;
        }
        size++;
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
        Node<E> deleteNode;
        if (index == 0) {
            deleteNode = first;
            first = deleteNode.next;
        } else {
            Node<E> preNode = getNodeByIndex(index - 1);
            deleteNode = preNode.next;
            preNode.next = deleteNode.next;
        }
        helpGc(deleteNode); // help gc
        size--;
    }

    /**
     * help Gc
     *
     * @param node 结点
     */
    private void helpGc(Node<E> node) {
        if (node == null) {
            return;
        }
        node.element = null;
        node.next = null;
        node = null;
    }

    /**
     * 查找指定元素的位置
     *
     * @param e 元素
     * @return 元素所在的位置
     */
    @Override
    public int indexOf(E e) {
        int index = 0;
        for (Node<E> tempNode = first; tempNode != null; tempNode = tempNode.next) {
            if (e.equals(tempNode.element)) {
                return index;
            }
            index++;
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
        Node<E> node = getNodeByIndex(index);
        if (node == null) {
            return null;
        }
        return node.element;
    }

    /**
     * 根据元素位置获取结点
     *
     * @param index 元素位置
     * @return 结点
     */
    private Node<E> getNodeByIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException...");
        }
        int currentIndex = 0;
        for (Node<E> tempNode = first; tempNode != null; tempNode = tempNode.next) {
            if (currentIndex == index) {
                return tempNode;
            }
            currentIndex++;
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

    /**
     * 清空链表
     */
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
    private final static class Node<E> {

        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
