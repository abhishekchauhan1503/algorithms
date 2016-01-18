package com.algoriths.dynamicprogramming.old;

import org.junit.Assert;
import org.junit.Test;

public class RodCutterDynamicProgrammingTest {

    private RodCutterDynamicProgramming cut = new RodCutterDynamicProgramming();

    @Test
    public void testGetNumberOfWaysToCutRod() {
        //Dynamic programming approach works fine with large values of n
        int maxLength = 1000;
        cut.initializeList(maxLength);
        for (int length = 1; length <= maxLength; length++) {
            double numOfWaysToCut = cut.getNumberOfWaysToCutRod(length);
            Assert.assertEquals(Math.pow(2, length - 1), numOfWaysToCut, 0);
        }
    }
}
