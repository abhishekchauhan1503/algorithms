package com.algorithms.dynamicprogramming.models;


public class SubStringSequenceResult {
    private String sequence;
    private int lastIndex;

    public SubStringSequenceResult(String sequence, int lastIndex) {
        this.sequence = sequence;
        this.lastIndex = lastIndex;
    }

    public SubStringSequenceResult() {
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }
}