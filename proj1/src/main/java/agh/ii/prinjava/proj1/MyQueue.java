package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

import java.util.NoSuchElementException;

/**
 * The MyQueue interface represents a first-in-first-out (FIFO) queue of objects.
 * It provides methods for adding elements to the back of the queue,
 * removing elements from the front of the queue, peeking at the front element,
 * checking if the queue is empty, and getting the number of elements in the queue.
 *
 * @param <E> the type of elements in the queue
 */
public interface MyQueue<E> {

    /**
     * Adds an element to the back of the queue.
     *
     * @param x the element to be added to the queue
     */
    void enqueue(E x);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    E dequeue();

    /**
     * Returns whether the queue is empty or not.
     *
     * @return true if the queue is empty, false otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int numOfElems();

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    E peek();

    /**
     * Creates and returns a new instance of MyQueue.
     *
     * @param <T> the type of elements in the queue
     * @return a new instance of MyQueue
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}

