package sample.algorithms;

import sample.Pixel;

import java.util.Iterator;

public interface DrawAlgorithm {
    Iterator<Pixel> dot(Pixel pixel);
}
