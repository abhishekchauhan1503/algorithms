package com.algoriths.dynamicprogramming;

import com.algoriths.dynamicprogramming.models.SumOfSquaresMetadata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Determine the minimum number of squares that sum up to a given number
 * Returns a metadata containing the number of squares and a list of those numbers
 */
public class SumOfSquares {
    private int opCount = 0;

    public SumOfSquaresMetadata getSquares(int n) {

        Map<Integer, SumOfSquaresMetadata> numberToSquaresMap = prepareInitialMetadataMap(n);
        for (int i = 1; i <= n; i++) {
            getSquaresMetadata(i, numberToSquaresMap);
        }
        //System.out.println("n = " + n + " opCount = " + opCount);
        return numberToSquaresMap.get(n);
    }

    private void getSquaresMetadata(int n, Map<Integer, SumOfSquaresMetadata> squaresMetadata) {
        if (squaresMetadata.get(n).getSquares() != null) {
            return;
        }
        if (isPerfectSquare(n)) {
            opCount++;
            SumOfSquaresMetadata metadata = new SumOfSquaresMetadata();
            metadata.setNumberOfSquaresNeeded(1);
            metadata.setSquares(Arrays.asList((int) Math.sqrt(n)));
            squaresMetadata.put(n, metadata);
            return;
        }
        for (int i = 1; i * i <= n; i++) {
            opCount++;
            squaresMetadata.put(n, getMinSquares(squaresMetadata.get(n), squaresMetadata.get(i * i).add(squaresMetadata.get(n - i * i))));
        }
    }

    private SumOfSquaresMetadata getMinSquares(SumOfSquaresMetadata base, SumOfSquaresMetadata target) {
        if (base.compareTo(target) > 0) {
            return target;
        }
        return base;
    }

    private boolean isPerfectSquare(int numberToCheck) {
        int squareRoot = (int) Math.sqrt(numberToCheck);
        return (squareRoot * squareRoot == numberToCheck);
    }

    private Map<Integer, SumOfSquaresMetadata> prepareInitialMetadataMap(int size) {
        Map<Integer, SumOfSquaresMetadata> numberToSquaresMap = new HashMap<Integer, SumOfSquaresMetadata>();
        for (int i = 1; i <= size; i++) {
            SumOfSquaresMetadata metadata = new SumOfSquaresMetadata();
            metadata.setNumberOfSquaresNeeded(Integer.MAX_VALUE);
            metadata.setSquares(null);
            numberToSquaresMap.put(Integer.valueOf(i), metadata);
        }
        return numberToSquaresMap;
    }

}
