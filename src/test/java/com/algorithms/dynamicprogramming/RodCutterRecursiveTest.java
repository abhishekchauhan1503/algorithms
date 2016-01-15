package com.algorithms.dynamicprogramming;


import junit.framework.Assert;
import org.junit.Test;

public class RodCutterRecursiveTest {
    private RodCutterRecursive cut = new RodCutterRecursive();

    @Test
    public void testGetNumberOfWaysToCutRod() {
        //Recursive approach becomes very slow with n>27
        int maxLength = 25;
        for (int length = 1; length <= maxLength; length++) {
            double numOfWaysToCut = cut.getNumberOfWaysToCutRod(length);
            Assert.assertEquals(Math.pow(2, length - 1), numOfWaysToCut);
        }
    }
}