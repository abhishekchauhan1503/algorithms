package com.algorithms.dynamicprogramming;


import junit.framework.Assert;
import org.junit.Test;

public class RodCutterRecursiveTest {
    private RodCutterRecursive cut = new RodCutterRecursive();

    @Test
    public void testGetNumberOfWaysToCutRod() {
        //Recursive approach becomes very slow with n>27
        for (int length = 1; length <= 25; length++) {
            int numOfWaysToCut = 0;
            for (int i = 0; i <= length; i++) {
                numOfWaysToCut += cut.getNumberOfWaysToCutRod(length, i);
            }
            Assert.assertEquals((int)Math.pow(2, length - 1), numOfWaysToCut);
        }
    }
}