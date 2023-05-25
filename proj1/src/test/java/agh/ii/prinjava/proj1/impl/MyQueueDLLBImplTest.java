package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {
    MyQueue<Character> queueOfCharacters = MyQueue.create();

    @BeforeEach
    void setUp() {
        /**
         *   Add items to the queue to test methods
         */

        queueOfCharacters.enqueue('d');
        queueOfCharacters.enqueue('k');
        queueOfCharacters.enqueue('k');
        queueOfCharacters.enqueue('b');
    }

    @AfterEach
    void tearDown() {
        /**
         *  Empty the queue after each test
         */
        // Empty the queue after each test
        while (!queueOfCharacters.isEmpty()) {
            queueOfCharacters.dequeue();
        }
    }

    @Test
    void enqueue() {
        /**
         * Check that the size of the queue increases after adding test
          */
        assertEquals(4, queueOfCharacters.numOfElems());
        queueOfCharacters.enqueue('s');
        assertEquals(5, queueOfCharacters.numOfElems());
    }

    @Test
    void dequeue() {
        /**
         * Check that the item at the top of the queue is deleted
         */

        assertEquals('d', queueOfCharacters.dequeue());
        assertEquals('k', queueOfCharacters.peek());
        assertEquals('k', queueOfCharacters.dequeue());
        assertEquals('k', queueOfCharacters.peek());
    }

    @Test
    void peek() {
        /**
         * Check that the item at the head of the queue is returned
         */

        assertEquals('d', queueOfCharacters.peek());
        queueOfCharacters.dequeue();
        assertEquals('k', queueOfCharacters.peek());
    }

    @Test
    void isEmpty() {

        assertFalse(queueOfCharacters.isEmpty());
        queueOfCharacters.dequeue();
        queueOfCharacters.dequeue();
        queueOfCharacters.dequeue();
        queueOfCharacters.dequeue();
        assertTrue(queueOfCharacters.isEmpty());
    }

}