package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Double> stackOfDoubles = MyStack.create();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void numOfElems() {
        assertEquals(0.0, stackOfDoubles.numOfElems());
        stackOfDoubles.push(56.25);
        stackOfDoubles.push(54.0);
        stackOfDoubles.push(47.6);
        assertEquals(3, stackOfDoubles.numOfElems());
    }

    @Test
    void push() {
        stackOfDoubles.push(10.3);
        assertEquals(10.3, stackOfDoubles.peek());

        stackOfDoubles.push(2.48);
        assertEquals(2.48, stackOfDoubles.peek());

        stackOfDoubles.push(3.0);
        assertEquals(3.0, stackOfDoubles.peek());
    }

    @Test
    void pop() {
        stackOfDoubles.push(10.3);
        stackOfDoubles.push(2.48);
        stackOfDoubles.push(3.0);

        assertEquals(3, stackOfDoubles.numOfElems());
        assertEquals(3.0, stackOfDoubles.pop());

        assertEquals(2, stackOfDoubles.numOfElems());
        assertEquals(2.48, stackOfDoubles.pop());

        assertEquals(1, stackOfDoubles.numOfElems());
        assertEquals(10.3, stackOfDoubles.pop());

        assertThrows(NoSuchElementException.class, () -> stackOfDoubles.pop());
    }

    @Test
    void peek() {
        stackOfDoubles.push(10.65);
        assertEquals(10.65, stackOfDoubles.peek());

        stackOfDoubles.push(48.70);
        assertEquals(48.70, stackOfDoubles.peek());

        stackOfDoubles.push(69.0);
        assertEquals(69.0, stackOfDoubles.peek());

        stackOfDoubles.pop();
        assertEquals(48.70, stackOfDoubles.peek());

        stackOfDoubles.pop();
        assertEquals(10.65, stackOfDoubles.peek());

        stackOfDoubles.pop();
        assertThrows(NoSuchElementException.class, () -> stackOfDoubles.peek());
    }

    @Test
    void isEmpty() {
        assertTrue(stackOfDoubles.isEmpty());

        stackOfDoubles.push(14.5);
        assertFalse(stackOfDoubles.isEmpty());

        stackOfDoubles.pop();
        assertTrue(stackOfDoubles.isEmpty());
    }
}