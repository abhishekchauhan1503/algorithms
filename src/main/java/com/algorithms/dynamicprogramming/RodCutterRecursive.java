package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class RodCutterRecursive {

    public int getNumberOfWaysToCutRod(int lengthOfRod, int numberOfPieces) {
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