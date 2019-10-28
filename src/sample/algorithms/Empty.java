package sample.algorithms;

import sample.Pixel;

import java.util.Collection;
import java.util.LinkedList;

public class Empty implements DrawAlgorithm {
    @Override
    public Collection<Pixel> drawAndReset(Pixel pixel) {
        return new LinkedList<>();
    }

    @Override
    public Collection<Pixel> drawNoReset(Pixel pixel) {
        return new LinkedList<>();
    }

    @Override
    public Collection<Pixel> drawAll(Pixel... inputs) {
        return new LinkedList<>();
    }

    @Override
    public void clear() {

    }
}
