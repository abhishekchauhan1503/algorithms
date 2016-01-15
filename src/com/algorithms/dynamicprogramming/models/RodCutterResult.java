package com.algorithms.dynamicprogramming.models;

import java.util.List;

public class RodCutterResult {
    private int firstCutPosition;
    private int totalProfit;
    private List<Integer> lengthOfPieces;

    public List<Integer> getLengthOfPieces() {
        return lengthOfPieces;
    }

    public void setLengthOfPieces(List<Integer> lengthOfPieces) {
        this.lengthOfPieces = lengthOfPieces;
    }

    public int getFirstCutPosition() {
        return firstCutPosition;
    }

    public void setFirstCutPosition(int firstCutPosition) {
        this.firstCutPosition = firstCutPosition;
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(int totalProfit) {
        this.totalProfit = totalProfit;
    }
}
