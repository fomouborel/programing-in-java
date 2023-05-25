package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

import java.util.NoSuchElementException;

/**
 * The MyStack interface represents a last-in-first-out (LIFO) stack of objects.
 * It provides methods for pushing, popping, peeking at the top element,
 * checking if the stack is empty, and getting the number of elements in the stack.
 *
 * @param <E> the type of elements in the stack
 */
public interface MyStack<E> {

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    E pop();

    /**
     * Adds an element to the top of the stack.
     *
     * @param x the element to be added to the stack
     */
    void push(E x);

    /**
     * Returns whether the stack is empty or not.
     *
     * @return true if the stack is empty, false otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    int numOfElems();

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    E peek();

    /**
     * Creates and returns a new instance of MyStack.
     *
     * @param <T> the type of elements in the stack
     * @return a new instance of MyStack
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}

