package agh.ii.prinjava.proj1.impl;

import java.util.NoSuchElementException;

public class DLinkList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public static class Node<T> {
        private T elem;
        private Node<T> next;
        private Node<T> prev;

        Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }

        public T getElem() {
            return elem;
        }
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @param elem the element to be added to the beginning of the list
     */
    public void addFirst(E elem) {
        Node<E> node = new Node<>(elem, null, head);
        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param elem the element to be added to the end of the list
     */
    public void addLast(E elem) {
        Node<E> node = new Node<>(elem, tail, null);
        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    /**
     * Removes and returns the first element from the list.
     *
     * @return the first element from the list
     * @throws NoSuchElementException if the list is empty
     */
    public E removeFirst() throws NoSuchElementException{
        if (head == null) {
            throw new NoSuchElementException();
        }
        E elem = head.elem;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return elem;
    }

    /**
     * Removes and returns the last element from the list.
     *
     * @return the last element from the list
     * @throws NoSuchElementException if the list is empty
     */
    public E removeLast() throws NoSuchElementException{
        if (tail == null) {
            throw new NoSuchElementException();
        }
        E elem = tail.elem;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return elem;
    }


    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> node = head;
        while (node != null) {
            sb.append(node.elem);
            if (node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

