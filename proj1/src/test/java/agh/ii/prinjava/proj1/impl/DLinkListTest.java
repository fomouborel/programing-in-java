package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {
    DLinkList<Integer> dLinkList = new DLinkList<>();

    @BeforeEach
    void setUp() {
        dLinkList.addLast(4);
        dLinkList.addLast(6);
        dLinkList.addLast(9);
        dLinkList.addLast(14);
    }

    @AfterEach
    void tearDown() {
        dLinkList = new DLinkList<>();
    }

    @Test
    void testAddFirst() {
        //given
        dLinkList.addFirst(10);
        //when
        String result = "[10, 4, 6, 9, 14]";
        //then
        assertEquals(result, dLinkList.toString());
        assertEquals(5, dLinkList.getSize());
    }

    @Test
    void testAddLast() {
        //given
        dLinkList.addLast(18);
        //when
        String result ="[4, 6, 9, 14, 18]";
        //then
        assertEquals(result, dLinkList.toString());
        assertEquals(5, dLinkList.getSize());
    }

    @Test
    void testRemoveFirst() {
        //given
        int elem = dLinkList.removeFirst();
        //then
        assertEquals(4, elem);
        //when
        String result = "[6, 9, 14]";
        //then
        assertEquals("[6, 9, 14]", dLinkList.toString());
        assertEquals(3, dLinkList.getSize());
    }

    @Test
    void testRemoveLast() {
        //given
        int elem = dLinkList.removeLast();
        //when
        String result = "[4, 6, 9]";
        //then
        assertEquals(14, elem);
        assertEquals(result, dLinkList.toString());
        assertEquals(3, dLinkList.getSize());
    }
}
