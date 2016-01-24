package com.algorithms.dynamicprogramming;


import com.algorithms.dynamicprogramming.models.SumOfSquaresMetadata;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SumOfSquaresTest {
    @InjectMocks
    private SumOfSquares cut;

    @Test
    public void testGetSquaresForPerfectSquare() {
        int n = 1;
        SumOfSquaresMetadata expected = new SumOfSquaresMetadata();
        expected.setNumberOfSquaresNeeded(1);
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(Integer.valueOf(1));
        expected.setSquares(listOfNumbers);
        SumOfSquaresMetadata result = cut.getSquares(n);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getNumberOfSquaresNeeded(), result.getNumberOfSquaresNeeded());
        Assert.assertEquals(expected.getSquares(), result.getSquares());
    }

    @Test
    public void testGetSquares() {
        int n = 2;
        SumOfSquaresMetadata expected = new SumOfSquaresMetadata();
        expected.setNumberOfSquaresNeeded(2);
        expected.setSquares(Arrays.asList(1, 1));
        SumOfSquaresMetadata result = cut.getSquares(n);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getNumberOfSquaresNeeded(), result.getNumberOfSquaresNeeded());
        Assert.assertEquals(expected.getSquares(), result.getSquares());
    }

    @Test
    public void testGetSquaresLargeNumber() {
        int n = 200000;
        SumOfSquaresMetadata expected = new SumOfSquaresMetadata();
        expected.setNumberOfSquaresNeeded(2);
        expected.setSquares(Arrays.asList(440, 80));
        SumOfSquaresMetadata result = cut.getSquares(n);
        /*System.out.println("Number of squares needed for "+ n +" = "+result.getNumberOfSquaresNeeded());
        System.out.println("List of squares: ");
        for(Integer square : result.getSquares()) {
            System.out.println(square);
        }*/
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.getNumberOfSquaresNeeded(), result.getNumberOfSquaresNeeded());
        Assert.assertEquals(expected.getSquares(), result.getSquares());
    }
}
