package com.algoriths.dynamicprogramming.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abhishek
 * Date: 1/5/16
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class SumOfSquaresMetadata implements Comparable<SumOfSquaresMetadata> {
    private Integer numberOfSquaresNeeded;
    private List<Integer> squares;

    public Integer getNumberOfSquaresNeeded() {
        return numberOfSquaresNeeded;
    }

    public void setNumberOfSquaresNeeded(Integer numberOfSquaresNeeded) {
        this.numberOfSquaresNeeded = numberOfSquaresNeeded;
    }

    public List<Integer> getSquares() {
        return squares;
    }

    public void setSquares(List<Integer> squares) {
        this.squares = squares;
    }

    public SumOfSquaresMetadata add(SumOfSquaresMetadata target) {
        if (target == null) {
            return this;
        }
        SumOfSquaresMetadata result = new SumOfSquaresMetadata();
        result.setNumberOfSquaresNeeded(this.numberOfSquaresNeeded + target.getNumberOfSquaresNeeded());
        List<Integer> resultSquares = new ArrayList<Integer>();
        resultSquares.addAll(this.squares);
        resultSquares.addAll(target.getSquares());
        result.setSquares(resultSquares);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SumOfSquaresMetadata)) return false;

        SumOfSquaresMetadata metadata = (SumOfSquaresMetadata) o;

        if (!numberOfSquaresNeeded.equals(metadata.numberOfSquaresNeeded)) return false;
        if (!squares.equals(metadata.squares)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberOfSquaresNeeded.hashCode();
        result = 31 * result + squares.hashCode();
        return result;
    }

    @Override
    public int compareTo(SumOfSquaresMetadata o) {
        if (this.equals(o)) {
            return 0;
        }
        if (this.numberOfSquaresNeeded < o.numberOfSquaresNeeded) {
            return -1;
        }
        return 1;
    }
}
