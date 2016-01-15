package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class RodCutterDynamicProgramming {
    private List<Double> NUM_OF_WAYS_TO_CUT_ROD;

    public void initializeList(Integer size) {
        NUM_OF_WAYS_TO_CUT_ROD = new ArrayList<>();
        NUM_OF_WAYS_TO_CUT_ROD.add(0, 0.0);
        NUM_OF_WAYS_TO_CUT_ROD.add(1, 1.0);
        for (int i = 2; i <= size; i++) {
            NUM_OF_WAYS_TO_CUT_ROD.add(i, null);
        }
    }

    private void printList() {
        for (int i = 0; i < NUM_OF_WAYS_TO_CUT_ROD.size(); i++) {
            System.out.println("value at " + i + " = " + NUM_OF_WAYS_TO_CUT_ROD.get(i));
        }
    }

    public double getNumberOfWaysToCutRod(Integer lengthOfRod) {
        double numOfWaysToCut = 0;
        numOfWaysToCut += getNumberOfWaysToCutRodRecursively(lengthOfRod);
        NUM_OF_WAYS_TO_CUT_ROD.set(lengthOfRod, numOfWaysToCut);
        return numOfWaysToCut;
    }

    private double getNumberOfWaysToCutRodRecursively(Integer lengthOfRod) {
        if (1 == lengthOfRod) {
            return 1;
        }
        if (NUM_OF_WAYS_TO_CUT_ROD.get(lengthOfRod) != null) {
            return NUM_OF_WAYS_TO_CUT_ROD.get(lengthOfRod);
        }

        double numOfWays = 1;
        for (int i = 1; i <= lengthOfRod; i++) {
            numOfWays = (numOfWays + (getNumberOfWaysToCutRodRecursively(lengthOfRod - i)));
        }
        return numOfWays;
    }
}