package sample.algorithms;

import sample.Pixel;

import java.util.LinkedList;

public class Cda extends DrawLine {
    @Override
    protected void draw(LinkedList<Pixel> pixels) {
        int xx = Math.abs(secondPixel.x - firstPixel.x);
        int yy = Math.abs(secondPixel.y - firstPixel.y);
        int d = (xx > yy) ? xx : yy;
        double dx = ((double) (secondPixel.x - firstPixel.x)) / d;
        double dy = ((double) (secondPixel.x - firstPixel.x)) / d;

        double x = firstPixel.x + 0.5 * sign(dx);
        double y = firstPixel.y + 0.5 * sign(dy);

        pixels.add(new Pixel(x, y));

        for (int i = 0; i < d; i++) {
            x += dx;
            y += dy;
            pixels.add(new Pixel(x, y));
        }
    }

    private int sign(double x) {
        return (x > 0) ? 1 : (x < 0) ? -1 : 0;
    }
}
