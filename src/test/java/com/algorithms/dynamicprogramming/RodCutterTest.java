package com.algorithms.dynamicprogramming;


import junit.framework.Assert;
import org.junit.Test;

public class RodCutterTest {
    private RodCutter cut = new RodCutter();

    @Test
    public void testGetNumberOfWaysToCutRod() {
        for (int length = 1; length <= 100; length++) {
            int numOfWaysToCut = 0;
            for (int i = 0; i <= length; i++) {
                numOfWaysToCut += cut.getNumberOfWaysToCutRod(length, i);
            }
            System.out.println("Number of ways to cut a rod of length " + length + " = " + numOfWaysToCut);
            Assert.assertEquals((int)Math.pow(2, length - 1), numOfWaysToCut);
        }
    }
}
