package sample.algorithms;

import sample.Pixel;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class TwoDotsAlgorithm implements DrawAlgorithm{
    protected Pixel firstPixel = null;
    protected Pixel secondPixel = null;

    @Override
    public Iterator<Pixel> dot(Pixel pixel) {
        if (firstPixel == null){
            firstPixel = pixel;
            LinkedList<Pixel> pixels = new LinkedList<>();
            pixels.add(pixel);
            return pixels.iterator();
        }

        LinkedList<Pixel> pixels = new LinkedList<>();
        secondPixel = pixel;
        draw(pixels);
        firstPixel = null;
        return pixels.iterator();
    }

    protected abstract void draw(LinkedList<Pixel> pixels);
}
