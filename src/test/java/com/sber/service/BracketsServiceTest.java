package com.sber.service;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BracketsServiceTest {

    private BracketsService service = new BracketsService();

    @Test
    public void testBalancedBrackets() {
        assertTrue(service.isBracketsBalanced("(это текст)"));
        assertFalse(service.isBracketsBalanced("()"));
        assertFalse(service.isBracketsBalanced("(())"));
    }

    @Test
    public void testUnbalancedBrackets() {
        assertFalse(service.isBracketsBalanced(")("));
        assertFalse(service.isBracketsBalanced("(нет закрывающей"));
    }
}