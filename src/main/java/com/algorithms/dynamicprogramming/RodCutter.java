package com.algorithms.dynamicprogramming;


import com.algorithms.dynamicprogramming.models.RodCutterResult;

import java.util.Map;

public interface RodCutter {
    public static final String BEAN_NAME = "rod.cutter";
    RodCutterResult cutRod(int lengthOfRod, Map<Integer, Integer> pieceLengthToProfitMap);
}
