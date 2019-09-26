package sample.algorithms;

import sample.Pixel;

import java.util.Collections;
import java.util.Iterator;

public class Empty implements DrawAlgorithm {
    @Override
    public Iterator<Pixel> dot(Pixel pixel) {
        return Collections.emptyIterator();
    }
}
