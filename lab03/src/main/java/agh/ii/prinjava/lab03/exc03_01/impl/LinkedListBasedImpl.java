package agh.ii.prinjava.lab03.exc03_01.impl;

/*import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

public class LinkedListBasedImpl implements QueueOfInts {

    private static class Node {
        int elem;
        Node next;
        Node prev;

        public Node(int elem) {
            this.elem = elem;
        }

        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }


    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;
}
    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x);
        Node last = null;
        Node first = null;
        int numOfElems = 0;
        if (last == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            prev = last;
            last = newNode;
        }
        newNode.numOfElems++;
    }

    @Override
    public int dequeue() {
        Node last = null;
        Node first = null;
        int numOfElems = 0;
        if (first == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int elem = first.elem;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        numOfElems--;
        return elem;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (first == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return first.elem;
    }
}
}*/
