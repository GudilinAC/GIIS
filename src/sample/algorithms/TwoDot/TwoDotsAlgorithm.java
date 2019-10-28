package sample.algorithms.TwoDot;

import sample.Pixel;
import sample.algorithms.DrawAlgorithm;

import java.util.Collection;
import java.util.LinkedList;

public abstract class TwoDotsAlgorithm implements DrawAlgorithm {
    protected Pixel firstPixel = null;
    protected Pixel secondPixel = null;

    @Override
    public Collection<Pixel> drawAndReset(Pixel pixel) {
        LinkedList<Pixel> pixels = new LinkedList<>();
        if (firstPixel == null) {
            firstPixel = pixel;
            pixels.add(pixel);
        } else {
            secondPixel = pixel;
            if (secondPixel.x != firstPixel.x || secondPixel.y != firstPixel.y)
                draw(pixels);
            clear();
        }
        return pixels;
    }

    @Override
    public Collection<Pixel> drawNoReset(Pixel pixel) {
        LinkedList<Pixel> pixels = new LinkedList<>();
        if (firstPixel != null) {
            secondPixel = pixel;
            if (secondPixel.x != firstPixel.x || secondPixel.y != firstPixel.y)
                draw(pixels);
        }
        return pixels;
    }

    @Override
    public Collection<Pixel> drawAll(Pixel... inputs) {
        LinkedList<Pixel> pixels = new LinkedList<>();
        for (Pixel pixel : inputs) {
            pixels.addAll(drawAndReset(pixel));
        }
        return pixels;
    }

    @Override
    public void clear() {
        firstPixel = null;
    }

    protected abstract void draw(Collection<Pixel> pixels);
}
