package sample.algorithms;

import sample.Pixel;

import java.util.LinkedList;

public interface DrawAlgorithm {
    LinkedList<Pixel> drawAndReset(Pixel pixel);

    LinkedList<Pixel> drawNoReset(Pixel pixel);
}
