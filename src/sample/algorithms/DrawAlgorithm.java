package sample.algorithms;

import sample.Pixel;

import java.util.Collection;

public interface DrawAlgorithm {
    Collection<Pixel> drawAndReset(Pixel pixel);

    Collection<Pixel> drawNoReset(Pixel pixel);

    Collection<Pixel> drawAll(Pixel... inputs);

    void clear();
}
