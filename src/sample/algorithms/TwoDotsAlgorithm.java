package sample.algorithms;

import sample.Pixel;

import java.util.LinkedList;

public abstract class TwoDotsAlgorithm implements DrawAlgorithm {
    protected Pixel firstPixel = null;
    protected Pixel secondPixel = null;

    @Override
    public LinkedList<Pixel> drawAndReset(Pixel pixel) {
        if (firstPixel == null) {
            firstPixel = pixel;
            LinkedList<Pixel> pixels = new LinkedList<>();
            pixels.add(pixel);
            return pixels;
        }

        LinkedList<Pixel> pixels = new LinkedList<>();
        secondPixel = pixel;
        if (secondPixel.x == firstPixel.x && secondPixel.y == firstPixel.y)
            return pixels;
        draw(pixels);
        firstPixel = null;
        return pixels;
    }

    @Override
    public LinkedList<Pixel> drawNoReset(Pixel pixel) {
        if (firstPixel != null) {
            LinkedList<Pixel> pixels = new LinkedList<>();
            secondPixel = pixel;
            if (secondPixel.x == firstPixel.x && secondPixel.y == firstPixel.y)
                return pixels;
            draw(pixels);
            return pixels;
        } else return new LinkedList<>();
    }

    protected abstract void draw(LinkedList<Pixel> pixels);
}
