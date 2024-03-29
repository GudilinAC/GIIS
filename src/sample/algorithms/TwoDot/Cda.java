package sample.algorithms.TwoDot;

import sample.Pixel;

import java.util.Collection;

public class Cda extends TwoDotsAlgorithm {
    @Override
    protected void draw(Collection<Pixel> pixels) {
        int d = Math.max(Math.abs(secondPixel.x - firstPixel.x), Math.abs(secondPixel.y - firstPixel.y));
        double dx = ((double) (secondPixel.x - firstPixel.x)) / d;
        double dy = ((double) (secondPixel.y - firstPixel.y)) / d;

        double x = firstPixel.x;
        double y = firstPixel.y;

        for (int i = 0; i < d; i++) {
            x += dx;
            y += dy;
            pixels.add(new Pixel(x + 0.5, y + 0.5));
        }
    }
}
