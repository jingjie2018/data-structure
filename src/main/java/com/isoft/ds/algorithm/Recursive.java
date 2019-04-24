package com.isoft.ds.algorithm;

import com.isoft.ds.stack.Stack;
import com.isoft.ds.stack.impl.ArrayStack;
import org.junit.Test;

/**
 * TODO 功能描述
 *
 * @author Jingjie
 * @since 2019/4/25
 */
public class Recursive {

    /**
     * 阶乘问题
     */
    @Test
    public void testFact() {
        System.out.println("***********factByRecursive*************");
        System.out.println(factByRecursive(0));
        System.out.println(factByRecursive(1));
        System.out.println(factByRecursive(2));
        System.out.println(factByRecursive(3));
        System.out.println(factByRecursive(4));
        System.out.println("**********factByCycle**************");
        System.out.println(factByCycle(0));
        System.out.println(factByCycle(1));
        System.out.println(factByCycle(2));
        System.out.println(factByCycle(3));
        System.out.println(factByCycle(4));
    }

    /**
     * 递归实现阶乘
     *
     * @param n
     * @return
     */
    private int factByRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            return 1;
        }
        return n * factByRecursive(n - 1);
    }

    /**
     * 循环实现阶乘
     *
     * @param n
     * @return
     */
    private int factByCycle(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            return 1;
        }
        int result = n;
        while (n > 1) {
            result *= --n;
        }
        return result;
    }

    /**
     * 斐波那契
     */
    @Test
    public void testFibonacci() {
        System.out.println("***********fibonacciByRecursive*************");
        System.out.println(fibonacciByRecursive(0));
        System.out.println(fibonacciByRecursive(1));
        System.out.println(fibonacciByRecursive(2));
        System.out.println(fibonacciByRecursive(3));
        System.out.println(fibonacciByRecursive(4));
        System.out.println(fibonacciByRecursive(5));
        System.out.println(fibonacciByRecursive(6));
        System.out.println(fibonacciByRecursive(7));

        System.out.println("***********fibonacciByCycle*************");
        System.out.println(fibonacciByCycle(0));
        System.out.println(fibonacciByCycle(1));
        System.out.println(fibonacciByCycle(2));
        System.out.println(fibonacciByCycle(3));
        System.out.println(fibonacciByCycle(4));
        System.out.println(fibonacciByCycle(5));
        System.out.println(fibonacciByCycle(6));
        System.out.println(fibonacciByCycle(7));
    }

    /**
     * 斐波那契递归实现
     */
    public int fibonacciByRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            return n;
        }
        return fibonacciByRecursive(n - 1) + fibonacciByRecursive(n - 2);
    }

    /**
     * 循环实现斐波那契
     *
     * @param n
     * @return
     */
    public int fibonacciByCycle(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            return n;
        }
        int pre = 0, now = 1, next = 0;
        int i = 2;
        while (i <= n) {
            next = pre + now;
            pre = now;
            now = next;
            i++;
        }
        return next;
    }

    /**
     * 回文串
     */
    @Test
    public void testPalindrome() {
        System.out.println("***********isPalindromeByRecursive**************");
        System.out.println(isPalindromeByRecursive("a", 0, 1));
        System.out.println(isPalindromeByRecursive("abc", 0, 2));
        System.out.println(isPalindromeByRecursive("abcba", 0, 4));
        System.out.println(isPalindromeByRecursive("abccba", 0, 5));
        System.out.println(isPalindromeByRecursive("abbcbba", 0, 6));
        System.out.println("***********isPalindromeByCycle**************");
        System.out.println(isPalindromeByCycle("a"));
        System.out.println(isPalindromeByCycle("abc"));
        System.out.println(isPalindromeByCycle("abcba"));
        System.out.println(isPalindromeByCycle("abccba"));
        System.out.println(isPalindromeByCycle("abbcbba"));
        System.out.println("***********isPalindromeByStack**************");
        System.out.println(isPalindromeByStack("a"));
        System.out.println(isPalindromeByStack("abc"));
        System.out.println(isPalindromeByStack("abcba"));
        System.out.println(isPalindromeByStack("abccba"));
        System.out.println(isPalindromeByStack("abbcbba"));
    }

    /**
     * 回文串递归实现
     *
     * @param input
     * @return
     */
    public boolean isPalindromeByRecursive(String input, int start, int end) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.length() == 1) {
            return true;
        }
        input = input.toLowerCase();
        if (start >= end) {
            return true;
        }
        if (input.charAt(start) == input.charAt(end)) {
            return isPalindromeByRecursive(input, ++start, --end);
        }
        return false;
    }

    /**
     * 回文串循环实现
     *
     * @param input
     * @return
     */
    public boolean isPalindromeByCycle(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.length() == 1) {
            return true;
        }
        input = input.toLowerCase();
        int start = 0, end = input.length() - 1;
        while (start <= end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 回文串栈实现
     *
     * @param input
     * @return
     */
    public boolean isPalindromeByStack(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        int length = input.length();
        if (length == 1) {
            return true;
        }
        input = input.toLowerCase();
        Stack<Character> stack = new ArrayStack<>();
        int halfIndex = (int) (0.5 + length / 2.0) - 1;
        for (int i = 0; i < length; i++) {
            if (i <= halfIndex) {
                if (length % 2 != 0 && i == halfIndex) {
                    continue;
                }
                stack.push(input.charAt(i));
            } else {
                if (!stack.pop().equals(input.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
