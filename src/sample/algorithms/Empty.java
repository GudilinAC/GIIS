package sample.algorithms;

import sample.Pixel;

import java.util.LinkedList;

public class Empty implements DrawAlgorithm {
    @Override
    public LinkedList<Pixel> drawAndReset(Pixel pixel) {
        return new LinkedList<>();
    }

    @Override
    public LinkedList<Pixel> drawNoReset(Pixel pixel) {
        return new LinkedList<>();
    }

    @Override
    public LinkedList<Pixel> drawAll(Pixel... inputs) {
        return new LinkedList<>();
    }
}
