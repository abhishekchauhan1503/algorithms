package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class RodCutter {
    private List<Integer> NUM_OF_WAYS_TO_CUT_ROD = new ArrayList<>();

    public void initializeList() {
        NUM_OF_WAYS_TO_CUT_ROD.add(0, 0);
        NUM_OF_WAYS_TO_CUT_ROD.add(1, 1);
    }

    public int getNumberOfWaysToCutRod(int lengthOfRod, int numberOfPieces) {
        initializeList();
        if (numberOfPieces > lengthOfRod || numberOfPieces <= 0) {
            return 0;
        }
        if (numberOfPieces == lengthOfRod || numberOfPieces == 1) {
            return 1;
        }
        int numOfWays = 0;
        for (int i = 1; i <= lengthOfRod; i++) {
            numOfWays = (numOfWays + (getNumberOfWaysToCutRod(lengthOfRod - i, numberOfPieces - 1)));
        }
        return numOfWays;
    }
}