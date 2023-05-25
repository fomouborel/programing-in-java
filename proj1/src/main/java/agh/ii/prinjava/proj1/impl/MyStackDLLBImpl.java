package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

import java.util.NoSuchElementException;

public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems;
    //LIFO
    public MyStackDLLBImpl() {
        elems = new DLinkList<>();
    }
    public MyStackDLLBImpl(DLinkList<E> elems) {
        this.elems=elems;
    }

    @Override
    public E pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is already empty !!!");
        }
        return elems.removeFirst();
    }

    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    @Override
    public int numOfElems() {
        return elems.getSize();
    }

    @Override
    public E peek() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty !!!");
        }
        return elems.getHead().getElem();
    }
    @Override
    public boolean isEmpty() {
        return numOfElems() == 0;
    }
}
