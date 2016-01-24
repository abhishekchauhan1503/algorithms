package com.algorithms.dynamicprogramming;

import com.algorithms.dynamicprogramming.models.RodCutterResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class RodCutterTest {
    @InjectMocks
    private RodCutter cut;

    @Test
    public void testCutRodUnitLength() {
        int lengthOfRod = 1;
        int firstCut = 1;
        int expectedProfit = 10;
        List<Integer> pieces = new ArrayList<Integer>();
        pieces.add(1);
        Map<Integer, Integer> pieceLengthToProfitMap = new HashMap<Integer, Integer>();
        pieceLengthToProfitMap.put(0, 0);
        pieceLengthToProfitMap.put(1, 10);
        RodCutterResult rodCutterResult = cut.cutRod(lengthOfRod, pieceLengthToProfitMap);
        Assert.assertNotNull(rodCutterResult);
        Assert.assertEquals(firstCut, rodCutterResult.getFirstCutPosition());
        Assert.assertEquals(expectedProfit, rodCutterResult.getTotalProfit());
        Assert.assertEquals(pieces, rodCutterResult.getLengthOfPieces());
    }

    @Test
    public void testCutRodSmallRodSingleCut() {
        int lengthOfRod = 4;
        int firstCut = 1;
        List<Integer> pieces = new ArrayList<Integer>();
        pieces.add(1);
        pieces.add(3);
        int expectedProfit = 9;
        Map<Integer, Integer> pieceLengthToProfitMap = new HashMap<Integer, Integer>();
        pieceLengthToProfitMap.put(0, 0);
        pieceLengthToProfitMap.put(1, 2);
        pieceLengthToProfitMap.put(2, 3);
        pieceLengthToProfitMap.put(3, 7);
        pieceLengthToProfitMap.put(4, 5);
        RodCutterResult rodCutterResult = cut.cutRod(lengthOfRod, pieceLengthToProfitMap);
        Assert.assertNotNull(rodCutterResult);
        Assert.assertEquals(firstCut, rodCutterResult.getFirstCutPosition());
        Assert.assertEquals(expectedProfit, rodCutterResult.getTotalProfit());
        Assert.assertEquals(pieces, rodCutterResult.getLengthOfPieces());
    }

    @Test
    public void testCutRodLongRodNoCut() {
        int lengthOfRod = 10;
        int firstCut = 10;
        int expectedProfit = 30;
        List<Integer> pieces = new ArrayList<Integer>();
        pieces.add(10);
        Map<Integer, Integer> pieceLengthToProfitMap = new HashMap<Integer, Integer>();
        pieceLengthToProfitMap.put(0, 0);
        pieceLengthToProfitMap.put(1, 1);
        pieceLengthToProfitMap.put(2, 5);
        pieceLengthToProfitMap.put(3, 8);
        pieceLengthToProfitMap.put(4, 9);
        pieceLengthToProfitMap.put(5, 10);
        pieceLengthToProfitMap.put(6, 17);
        pieceLengthToProfitMap.put(7, 17);
        pieceLengthToProfitMap.put(8, 20);
        pieceLengthToProfitMap.put(9, 24);
        pieceLengthToProfitMap.put(10, 30);
        RodCutterResult rodCutterResult = cut.cutRod(lengthOfRod, pieceLengthToProfitMap);
        Assert.assertNotNull(rodCutterResult);
        Assert.assertEquals(firstCut, rodCutterResult.getFirstCutPosition());
        Assert.assertEquals(expectedProfit, rodCutterResult.getTotalProfit());
        Assert.assertEquals(pieces, rodCutterResult.getLengthOfPieces());
    }

    @Test
    public void testCutRodLongRodSingleCut() {
        int lengthOfRod = 9;
        int firstCut = 3;
        int expectedProfit = 25;
        List<Integer> pieces = new ArrayList<Integer>();
        pieces.add(3);
        pieces.add(6);
        Map<Integer, Integer> pieceLengthToProfitMap = new HashMap<Integer, Integer>();
        pieceLengthToProfitMap.put(0, 0);
        pieceLengthToProfitMap.put(1, 1);
        pieceLengthToProfitMap.put(2, 5);
        pieceLengthToProfitMap.put(3, 8);
        pieceLengthToProfitMap.put(4, 9);
        pieceLengthToProfitMap.put(5, 10);
        pieceLengthToProfitMap.put(6, 17);
        pieceLengthToProfitMap.put(7, 17);
        pieceLengthToProfitMap.put(8, 20);
        pieceLengthToProfitMap.put(9, 24);
        RodCutterResult rodCutterResult = cut.cutRod(lengthOfRod, pieceLengthToProfitMap);
        Assert.assertNotNull(rodCutterResult);
        Assert.assertEquals(firstCut, rodCutterResult.getFirstCutPosition());
        Assert.assertEquals(expectedProfit, rodCutterResult.getTotalProfit());
        Assert.assertEquals(pieces, rodCutterResult.getLengthOfPieces());
    }

    @Test
    public void testCutRodLongRodMultipleCuts() {
        int lengthOfRod = 9;
        int firstCut = 1;
        int expectedProfit = 27;
        List<Integer> pieces = new ArrayList<Integer>();
        pieces.add(1);
        pieces.add(4);
        pieces.add(4);
        Map<Integer, Integer> pieceLengthToProfitMap = new HashMap<Integer, Integer>();
        pieceLengthToProfitMap.put(0, 0);
        pieceLengthToProfitMap.put(1, 1);
        pieceLengthToProfitMap.put(2, 5);
        pieceLengthToProfitMap.put(3, 8);
        pieceLengthToProfitMap.put(4, 13);
        pieceLengthToProfitMap.put(5, 10);
        pieceLengthToProfitMap.put(6, 17);
        pieceLengthToProfitMap.put(7, 17);
        pieceLengthToProfitMap.put(8, 20);
        pieceLengthToProfitMap.put(9, 24);
        RodCutterResult rodCutterResult = cut.cutRod(lengthOfRod, pieceLengthToProfitMap);
        Assert.assertNotNull(rodCutterResult);
        Assert.assertEquals(firstCut, rodCutterResult.getFirstCutPosition());
        Assert.assertEquals(expectedProfit, rodCutterResult.getTotalProfit());
        Assert.assertEquals(pieces, rodCutterResult.getLengthOfPieces());
    }
}
