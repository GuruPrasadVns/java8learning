package com.ds.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackOperationsTest {

    @Test
    public void infixToPostfixTest(){
        String exp = "A+B*C+D";
        assertEquals("ABC*+D+", StackOperations.infixToPostfix(exp));

        String secondExp = "((A+B)-C*(D/E))+F";
        assertEquals("AB+CDE/*-F+", StackOperations.infixToPostfix(secondExp));

        String thirdExp = "a+b*(c^d-e)^(f+g*h)-i";
        assertEquals("abcd^e-fgh*+^*+i-", StackOperations.infixToPostfix(thirdExp));

        String fourthExp = "(A-B)*[C/(D+E)+F]";
        assertEquals("AB-CDE+/F+*", StackOperations.infixToPostfix(fourthExp));
    }

    @Test
    public void prefixToInfixTest(){
        String prefixExp= "*+AB-CD";
        assertEquals("((A+B)*(C-D))", StackOperations.prefixToInfix(prefixExp));

        String secondPrefixExp= "*-A/BC-/AKL";
        assertEquals("((A-(B/C))*((A/K)-L))", StackOperations.prefixToInfix(secondPrefixExp));
    }

    @Test
    public void prefixToPostfixTest(){
        String prefixExp= "*+AB-CD";
        assertEquals("AB+CD-*", StackOperations.prefixToPostfix(prefixExp));

        String secondPrefixExp= "*-A/BC-/AKL";
        assertEquals("ABC/-AK/L-*", StackOperations.prefixToPostfix(secondPrefixExp));
    }

    @Test
    public void postfixToPrefixTest(){
        String firstPostfixExp= "AB+CD-*";
        assertEquals("*+AB-CD", StackOperations.postfixToPrefix(firstPostfixExp));

        String secondPostfixExp= "ABC/-AK/L-*";
        assertEquals("*-A/BC-/AKL", StackOperations.postfixToPrefix(secondPostfixExp));
    }

    @Test
    public void postfixToInfixTest(){
        String firstPostfixExp= "abc++";
        assertEquals("(a+(b+c))", StackOperations.postfixToInfix(firstPostfixExp));

        String secondPostfixExp= "ab*c+";
        assertEquals("((a*b)+c)", StackOperations.postfixToInfix(secondPostfixExp));
    }

    @Test
    public void isBalancedTest(){
        String exp = "[()]{}{[()()]()}";
        assertTrue(StackOperations.isBalanced(exp));

        String secondExp = "[(])";
        assertFalse(StackOperations.isBalanced(secondExp));
    }

    @Test
    public void evaluatePostfixTest(){
        String firstPostfixExp = "2 4 + 4 6 + *";
        assertEquals(60, StackOperations.evaluatePostfix(firstPostfixExp));

        String secondPostfixExp = "2 3 1 * + 9 -";
        assertEquals(-4, StackOperations.evaluatePostfix(secondPostfixExp));

        String thirdPostfixExp = "100 200 + 2 / 5 * 7 +";
        assertEquals(757, StackOperations.evaluatePostfix(thirdPostfixExp));
    }

    @Test
    public void precedanceTest(){
        assertEquals(2, StackOperations.precedance('^'));
        assertEquals(1, StackOperations.precedance('/'));
        assertEquals(1, StackOperations.precedance('*'));
        assertEquals(0, StackOperations.precedance('+'));
        assertEquals(0, StackOperations.precedance('-'));
        assertEquals(-1, StackOperations.precedance('('));
    }
}
