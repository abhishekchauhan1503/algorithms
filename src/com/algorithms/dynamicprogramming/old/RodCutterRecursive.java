package com.algorithms.dynamicprogramming.old;

public class RodCutterRecursive {

    public double getNumberOfWaysToCutRod(int lengthOfRod) {
        return getNumberOfWaysToCutRodRecursively(lengthOfRod);
    }

    private double getNumberOfWaysToCutRodRecursively(Integer lengthOfRod) {
        if (1 == lengthOfRod) {
            return 1;
        }
        double numOfWays = 1;
        for (int i = 1; i < lengthOfRod; i++) {
            numOfWays = (numOfWays + (getNumberOfWaysToCutRodRecursively(lengthOfRod - i)));
        }
        return numOfWays;
    }
}