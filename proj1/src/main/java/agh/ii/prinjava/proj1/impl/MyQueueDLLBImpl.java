package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

import java.util.NoSuchElementException;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    //FIFO
    private DLinkList<E> elems = new DLinkList<>();


    @Override
    public void enqueue(E x) {
        elems.addLast(x);
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return elems.removeFirst();
    }

    @Override
    public int numOfElems() {
        return elems.getSize();
    }

    @Override
    public E peek() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return elems.getHead().getElem();
    }

    public boolean isEmpty() {
        return numOfElems() == 0;
    }
}
