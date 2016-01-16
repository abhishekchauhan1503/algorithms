package com.algoriths.dynamicprogramming;

import com.algoriths.dynamicprogramming.models.RodCutterResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a rod of length n, a table containing profit received for length i,
 * determine the optimal cuts on the rod.
 */
public class RodCutter {
    public RodCutterResult cutRod(int lengthOfRod, Map<Integer, Integer> pieceLengthToProfitMap) {
        Map<Integer, RodCutterResult> rodLengthToMaxProfitMap = prepareInitialProfitsMap(lengthOfRod);
        for (int i = 1; i <= lengthOfRod; i++) {
            prepareProfits(pieceLengthToProfitMap, i, rodLengthToMaxProfitMap);
        }
        RodCutterResult result = getMaximumProfit(rodLengthToMaxProfitMap);
        prepareLengthOfPieces(result, rodLengthToMaxProfitMap, lengthOfRod);
        //printResults(rodLengthToMaxProfitMap, result);
        return result;
    }

    private void printResults(Map<Integer, RodCutterResult> rodLengthToMaxProfitMap, RodCutterResult result) {
        System.out.println("===============RESULTS==================");
        for (Map.Entry<Integer, RodCutterResult> entry : rodLengthToMaxProfitMap.entrySet()) {
            System.out.println("Rod Length: " + entry.getKey() + " Max Profit: " + entry.getValue().getTotalProfit() + " First Cut: " + entry.getValue().getFirstCutPosition());
        }
        System.out.println("===============END RESULTS==================");
        System.out.println("===============PIECES==================");
        for (Integer piece : result.getLengthOfPieces()) {
            System.out.println(piece);
        }
        System.out.println("===============END PIECES==================");
    }

    private void prepareLengthOfPieces(RodCutterResult result, Map<Integer, RodCutterResult> rodLengthToMaxProfitMap, int lengthOfRod) {
        int firstCut = result.getFirstCutPosition();
        int diff = lengthOfRod - firstCut;
        List<Integer> pieces = new ArrayList<>();
        pieces.add(firstCut);
        while (diff > 0) {
            pieces.add(rodLengthToMaxProfitMap.get(diff).getFirstCutPosition());
            diff = diff - rodLengthToMaxProfitMap.get(diff).getFirstCutPosition();
        }
        result.setLengthOfPieces(pieces);
    }

    private RodCutterResult getMaximumProfit(Map<Integer, RodCutterResult> rodLengthToMaxProfitMap) {
        int maxProfit = -1;
        RodCutterResult result = null;
        for (Map.Entry<Integer, RodCutterResult> entry : rodLengthToMaxProfitMap.entrySet()) {
            if (entry.getValue().getTotalProfit() > maxProfit) {
                maxProfit = entry.getValue().getTotalProfit();
                result = entry.getValue();
            }
        }
        return result;
    }

    private Map<Integer, RodCutterResult> prepareInitialProfitsMap(int lengthOfRod) {
        Map<Integer, RodCutterResult> firstCutLengthToMaxProfitMap = new HashMap<>();
        for (int i = 0; i <= lengthOfRod; i++) {
            RodCutterResult result = new RodCutterResult();
            result.setTotalProfit(Integer.MIN_VALUE);
            result.setFirstCutPosition(-1);
            firstCutLengthToMaxProfitMap.put(i, result);
        }
        return firstCutLengthToMaxProfitMap;
    }

    private void prepareProfits(Map<Integer, Integer> pieceLengthToProfitMap, int miniRodLength, Map<Integer, RodCutterResult> rodLengthToMaxProfitMap) {
        if (miniRodLength == 1) {
            int totalProfit = pieceLengthToProfitMap.get(miniRodLength);
            RodCutterResult rodCutterResult = new RodCutterResult();
            rodCutterResult.setFirstCutPosition(miniRodLength);
            rodCutterResult.setTotalProfit(totalProfit);
            rodLengthToMaxProfitMap.put(miniRodLength, rodCutterResult);
        } else {
            for (int i = 1; i <= miniRodLength; i++) {
                if (i == miniRodLength) {
                    int totalProfit = pieceLengthToProfitMap.get(i);
                    RodCutterResult rodCutterResult = new RodCutterResult();
                    rodCutterResult.setFirstCutPosition(i);
                    rodCutterResult.setTotalProfit(totalProfit);
                    rodLengthToMaxProfitMap.put(miniRodLength, getMax(rodLengthToMaxProfitMap.get(i), rodCutterResult));
                } else {
                    RodCutterResult maxResult = getMax(rodLengthToMaxProfitMap.get(miniRodLength), addRodCutterResults(rodLengthToMaxProfitMap.get(i), rodLengthToMaxProfitMap.get(miniRodLength - i)));
                    maxResult.setFirstCutPosition(maxResult.getFirstCutPosition());
                    rodLengthToMaxProfitMap.put(miniRodLength, maxResult);
                }
            }
        }
    }

    private RodCutterResult addRodCutterResults(RodCutterResult base, RodCutterResult target) {
        RodCutterResult result = new RodCutterResult();
        if (base == null && target == null) {
            return null;
        }
        if (target == null) {
            return base;
        }
        if (base == null) {
            return target;
        }
        result.setTotalProfit(base.getTotalProfit() + target.getTotalProfit());
        result.setFirstCutPosition(base.getFirstCutPosition());
        return result;
    }

    private RodCutterResult getMax(RodCutterResult curValue, RodCutterResult newValue) {
        if (curValue.getTotalProfit() >= newValue.getTotalProfit()) {
            return curValue;
        }
        return newValue;
    }

}
